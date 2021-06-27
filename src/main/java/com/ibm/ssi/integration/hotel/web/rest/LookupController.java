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

import com.ibm.ssi.integration.hotel.service.BackendService;
import com.ibm.ssi.integration.hotel.service.dto.BookingDataDTO;
import com.ibm.ssi.integration.hotel.service.dto.CheckInCredentialDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import javax.validation.Valid;
import java.util.List;

@Tag(name="Lookup Controller", description = "Search for a guests in Backend")
@RestController
@RequestMapping("/api")
public class LookupController {

    private final Logger log = LoggerFactory.getLogger(LookupController.class);

    @Autowired
    BackendService backendService;

    @PostMapping("/lookup")
    @Operation(security = @SecurityRequirement(name = "X-API-Key"))
    public ResponseEntity<List<BookingDataDTO>> lookup(@RequestParam(name = "buchungsnummer", required = false, defaultValue = "") String bookingNumber,
                                                 @Valid @RequestBody CheckInCredentialDTO checkInCredentialDTO) {
        log.debug("REST request to look for Buchungsnummer {} and Firstname {}, Lastname {}",
            bookingNumber, checkInCredentialDTO.getCorporateId().getFirstName(), checkInCredentialDTO.getCorporateId().getFamilyName());

        List<BookingDataDTO> foundGuests = backendService.lookup(bookingNumber, checkInCredentialDTO);

        return new ResponseEntity<List<BookingDataDTO>>(foundGuests, new HttpHeaders(), HttpStatus.OK);
    }
}
