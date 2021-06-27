/*
 * Copyright 2021 Bundesreplublik Deutschland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.ssi.integration.hotel.service.impl;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import com.ibm.ssi.integration.hotel.exceptions.CouldNotUploadXmlFileException;
import com.ibm.ssi.integration.hotel.service.UploadToSMBService;
import com.ibm.ssi.integration.hotel.service.dto.PMSDataDTO;
import com.ibm.ssi.integration.hotel.xml.Beherbergungsstaette;
import com.ibm.ssi.integration.hotel.xml.BeherbergungsstaetteAnschrift;
import com.ibm.ssi.integration.hotel.xml.Meldeschein;
import com.ibm.ssi.integration.hotel.xml.Anschrift;
import com.ibm.ssi.integration.hotel.xml.Staatsangehoerigkeiten;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;


@Service()
public class UploadToSMBServiceImpl implements UploadToSMBService {

    private final Logger log = LoggerFactory.getLogger(UploadToSMBServiceImpl.class);

    @Value("${ssibk.hotel.integrationservice.smbservercredentials.username}")
    private String username;

    @Value("${ssibk.hotel.integrationservice.smbservercredentials.password}")
    private String password;

    @Value("${ssibk.hotel.integrationservice.smbservercredentials.servername}")
    private String servername;

    @Value("${ssibk.hotel.integrationservice.smbservercredentials.port}")
    private String port;

    @Value("${ssibk.hotel.integrationservice.smbservercredentials.folder}")
    private String folder;


    @Override
    public void createAndSendXml(PMSDataDTO pmsDataDTO) throws CouldNotUploadXmlFileException {
        String FILE_NAME = "Bookingid-" + pmsDataDTO.getBookingData().getBookingId() + "-Timestamp-" + new SimpleDateFormat("yy_MM_dd_hh_mm_ss").format(new Date()) + ".xml";
        String REMOTE_URL = "smb://" + this.username + ":" + this.password + "@" + this.servername + ":" + this.port;
        String SMB_FOLDER = "//" + this.folder + "//";
        String LOCAL_FOLDER = "/src/main/java/com/ibm/ssi/integration/hotel/xml";
        try {
            Meldeschein meldeschein = new Meldeschein();
            meldeschein.setDatumAnkunft(pmsDataDTO.getBookingData().getArrivalDate());
            meldeschein.setDatumAbreise(pmsDataDTO.getBookingData().getDepartureDate());
            meldeschein.setFamilienname(pmsDataDTO.getCheckInCredential().getMasterId().getFamilyName());
            meldeschein.setVornamen(pmsDataDTO.getCheckInCredential().getMasterId().getFirstName());
            meldeschein.setGeburtsdatum(pmsDataDTO.getCheckInCredential().getMasterId().getDateOfBirth().toString());
            meldeschein.setStaatsangehoerigkeit(new Staatsangehoerigkeiten("Deutsch"));
            meldeschein.setAnschrift(new Anschrift(
                pmsDataDTO.getCheckInCredential().getMasterId().getAddressCountry(),
                pmsDataDTO.getCheckInCredential().getMasterId().getAddressCity(),
                pmsDataDTO.getCheckInCredential().getMasterId().getAddressStreet()
            ));
            meldeschein.setBeherbergungsstaette(new Beherbergungsstaette(
                pmsDataDTO.getHotel().getName(),
                new BeherbergungsstaetteAnschrift(
                    "Deutschland",
                    pmsDataDTO.getHotel().getAddress().getCity(),
                    pmsDataDTO.getHotel().getAddress().getStreet()
                ))
            );

            JAXBContext contextObj;
            contextObj = JAXBContext.newInstance(Meldeschein.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshallerObj.marshal(meldeschein, new FileOutputStream(new File(".").getCanonicalPath() + File.separator + LOCAL_FOLDER + File.separator + FILE_NAME));

            uploadXmlToSMBServer(REMOTE_URL, SMB_FOLDER, FILE_NAME, new File(".").getCanonicalPath() + File.separator + LOCAL_FOLDER);

        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new CouldNotUploadXmlFileException();
        }
    }

    private void uploadXmlToSMBServer(String remoteUrl, String shareFolderPath, String fileName, String localDir) {
        InputStream in = null;
        OutputStream out = null;
        log.debug("URL: " + remoteUrl + shareFolderPath + File.separator + fileName);
        log.debug("Local file : " + localDir + File.separator + fileName);
        try {
            SmbFile smbfile = new SmbFile(remoteUrl + shareFolderPath + fileName);
            File localFile = new File(localDir + File.separator + fileName);
            in = new BufferedInputStream(new FileInputStream(localFile));
            out = new BufferedOutputStream(new SmbFileOutputStream(smbfile));
            FileCopyUtils.copy(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(in, out);
            deleteXmlFile(fileName, localDir);
        }
    }

    private static void deleteXmlFile(String fileName, String path) {
        try {
            File file = new File(path + File.separator + fileName);
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeStream(InputStream in, OutputStream out) {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
