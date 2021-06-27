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

package com.ibm.ssi.integration.hotel.web.rest;

import com.ibm.ssi.integration.hotel.exceptions.CouldNotUploadXmlFileException;
import com.ibm.ssi.integration.hotel.service.BackendService;
import com.ibm.ssi.integration.hotel.service.UploadToSMBService;
import com.ibm.ssi.integration.hotel.service.dto.PMSDataDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PMSData Controller", description = "receive PMSData for the backend of the integration services")
@RestController
@RequestMapping("/api")
public class PMSDataController {

    private final Logger log = LoggerFactory.getLogger(PMSDataController.class);

    @Autowired
    BackendService backendService;

    @Autowired
    UploadToSMBService uploadToSMBService;

    @PostMapping("/sendDataToPMS")
    @Operation(security = @SecurityRequirement(name = "X-API-Key"))
    public ResponseEntity<PMSDataDTO> sendDataToPMS(@RequestBody PMSDataDTO pmsDataDTO) {
        log.debug("REST request to send pmsData {}", pmsDataDTO);

        PMSDataDTO validPMSData = backendService.pmsData(pmsDataDTO);

        try {
            uploadToSMBService.createAndSendXml(pmsDataDTO);
        } catch (CouldNotUploadXmlFileException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<PMSDataDTO>(validPMSData, new HttpHeaders(), HttpStatus.OK);
    }
}
