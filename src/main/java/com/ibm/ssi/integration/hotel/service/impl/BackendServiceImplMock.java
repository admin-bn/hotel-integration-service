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

import com.ibm.ssi.integration.hotel.service.BackendService;
import com.ibm.ssi.integration.hotel.service.dto.BookingDataDTO;
import com.ibm.ssi.integration.hotel.service.dto.CheckInCredentialDTO;
import com.ibm.ssi.integration.hotel.service.dto.PMSDataDTO;
import com.ibm.ssi.integration.hotel.repository.mock.MockData;
import com.ibm.ssi.integration.hotel.web.rest.LookupController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service(value="MockServiceOpera")
@Profile("mock")
public class BackendServiceImplMock implements BackendService {

    private final Logger log = LoggerFactory.getLogger(LookupController.class);

    @Autowired
    MockData mockdataRepository;

    @Override
    public List<BookingDataDTO> lookup(String bookingNumber, CheckInCredentialDTO checkInCredentialDTO) {

        log.debug("lookup");
        List<BookingDataDTO> listMockData = mockdataRepository.getMockData();

        // Search by firstname, lastname or bookingNumber (if available)

        List<BookingDataDTO> foundReservations = new ArrayList<>();
        if (!bookingNumber.isEmpty()) {
            foundReservations = listMockData.stream()
                .filter(reservation -> reservation.getBookingId().equals(bookingNumber))
                .collect(Collectors.toList());
        } else {
             foundReservations = listMockData.stream()
                .filter(reservation -> reservation.getFirstName().equals(checkInCredentialDTO.getCorporateId().getFirstName()))
                .filter(reservation -> reservation.getLastName().equals(checkInCredentialDTO.getCorporateId().getFamilyName()))
                .collect(Collectors.toList());
        }

        return foundReservations;

    }

    @Override
    public PMSDataDTO pmsData(PMSDataDTO pmsDataDTO) {
        return pmsDataDTO;
    }

}
