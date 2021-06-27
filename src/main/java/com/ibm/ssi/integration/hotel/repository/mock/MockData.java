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

package com.ibm.ssi.integration.hotel.repository.mock;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.ssi.integration.hotel.service.dto.BookingDataDTO;

@Service
public class MockData {

    public List<BookingDataDTO> getMockData() {

        List<BookingDataDTO> list = new ArrayList<>();

        BookingDataDTO r1 = new BookingDataDTO();
        BookingDataDTO r2 = new BookingDataDTO();
        BookingDataDTO r3 = new BookingDataDTO();
        BookingDataDTO r4 = new BookingDataDTO();
        BookingDataDTO r5 = new BookingDataDTO();
        BookingDataDTO r6 = new BookingDataDTO();
        BookingDataDTO r7 = new BookingDataDTO();

        r1.setFirstName("John");
        r1.setLastName("Doe");
        r1.setCompanyEmail("johndoe@ssi.de");
        r1.setArrivalDate(new Date());
        r1.setDepartureDate(new Date());
        r1.setBookingId("JD1234");
        r1.setGuestId("G001");
        r1.setCompanyAddressCity("Stutt");
        r1.setCompanyAddressStreet("Moonstrasse 21");
        r1.setCompanyAddressZipCode("05532");

        r2.setFirstName("Shanaya");
        r2.setLastName("Smith");
        r2.setCompanyEmail("shanayasmith@ssi.de");
        r2.setArrivalDate(new Date());
        r2.setDepartureDate(new Date());
        r2.setBookingId("SS01234");
        r2.setGuestId("G002");
        r2.setCompanyAddressCity("Bern");
        r2.setCompanyAddressStreet("Sunstrasse 1");
        r2.setCompanyAddressZipCode("04364");

        r3.setFirstName("Ben");
        r3.setLastName("Franklin");
        r3.setCompanyEmail("benfranklin@ssi.de");
        r3.setArrivalDate(new Date());
        r3.setDepartureDate(new Date());
        r3.setBookingId("BF01234");
        r3.setGuestId("G003");
        r3.setCompanyAddressCity("Haurg");
        r3.setCompanyAddressStreet("Starstrasse 2");
        r3.setCompanyAddressZipCode("72345");

        r4.setFirstName("Allison");
        r4.setLastName("Stark");
        r4.setCompanyEmail("allisonstark@ssi.de");
        r4.setArrivalDate(new Date());
        r4.setDepartureDate(new Date());
        r4.setBookingId("AS01234");
        r4.setGuestId("G004");
        r4.setCompanyAddressCity("Stutt");
        r4.setCompanyAddressStreet("Moonstrasse 21");
        r4.setCompanyAddressZipCode("05532");

        r5.setFirstName("Elliot");
        r5.setLastName("Higgs");
        r5.setCompanyEmail("elliothiggs@ssi.com");
        r5.setArrivalDate(new Date());
        r5.setDepartureDate(new Date());
        r5.setBookingId("EH01234");
        r5.setGuestId("G005");
        r5.setCompanyAddressCity("Shels");
        r5.setCompanyAddressStreet("Jupiterstrasse");
        r5.setCompanyAddressZipCode("71032");

        r6.setFirstName("Marian");
        r6.setLastName("Hossa");
        r6.setCompanyEmail("markhossa@ssi.de");
        r6.setArrivalDate(new Date());
        r6.setDepartureDate(new Date());
        r6.setBookingId("MH01234");
        r6.setGuestId("G006");
        r6.setCompanyAddressCity("Bern");
        r6.setCompanyAddressStreet("Saturnstrasse");
        r6.setCompanyAddressZipCode("10969");

        r7.setFirstName("Peter");
        r7.setLastName("Sagan");
        r7.setCompanyEmail("");
        r7.setArrivalDate(new Date());
        r7.setDepartureDate(new Date());
        r7.setBookingId("PE01234");
        r7.setGuestId("G007");
        r7.setCompanyAddressCity("Koll");
        r7.setCompanyAddressStreet("Starstrasse 1");
        r7.setCompanyAddressZipCode("123456");

        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        list.add(r6);
        list.add(r7);

        return list;
    }
}
