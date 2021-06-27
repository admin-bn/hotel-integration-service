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

package com.ibm.ssi.integration.hotel.service.dto;

import java.time.LocalDate;
import java.util.Objects;

public class MasterIdDTO {
    private String firstName;
    private String familyName;
    private String addressStreet;
    private String addressCountry;
    private String addressCity;
    private String addressZipCode;
    private LocalDate dateOfBirth;
    private boolean valid;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setLocalDate(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterIdDTO that = (MasterIdDTO) o;
        return valid == that.valid && Objects.equals(firstName, that.firstName) && Objects.equals(familyName, that.familyName) && Objects.equals(addressStreet, that.addressStreet) && Objects.equals(addressCountry, that.addressCountry) && Objects.equals(addressCity, that.addressCity) && Objects.equals(addressZipCode, that.addressZipCode) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, familyName, addressStreet, addressCountry, addressCity, addressZipCode, dateOfBirth, valid);
    }

    @Override
    public String toString() {
        return "MasterIdDTO [addressCity=" + addressCity + ", addressCountry=" + addressCountry + ", addressStreet="
            + addressStreet + ", addressZipCode=" + addressZipCode + ", familyName=" + familyName + ", firstName="
            + firstName + ", dateOfBirth=" + dateOfBirth + ", valid=" + valid + "]";
    }

}
