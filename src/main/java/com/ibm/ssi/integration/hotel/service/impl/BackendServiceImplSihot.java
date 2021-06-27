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
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="IntegrationServiceOpera")
@Profile("sihot")
public class BackendServiceImplSihot implements BackendService {

    @Override
    public List<BookingDataDTO> lookup(String bookingNumber, CheckInCredentialDTO checkInCredentialDTO) {

        List<BookingDataDTO> foundReservations = new ArrayList<>();

        return foundReservations;

    }

    @Override
    public PMSDataDTO pmsData(PMSDataDTO pmsDataDTO) {
        return null;
    }

}
