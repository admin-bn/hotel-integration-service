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

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class CorporateIdDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String familyName;

    private String companyName;
    private String companySubject;
    private String companyAddressStreet;
    private String companyAddressZipCode;
    private String companyAddressCity;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanySubject() {
        return companySubject;
    }

    public void setCompanySubject(String companySubject) {
        this.companySubject = companySubject;
    }

    public String getCompanyAddressStreet() {
        return companyAddressStreet;
    }

    public void setCompanyAddressStreet(String companyAddressStreet) {
        this.companyAddressStreet = companyAddressStreet;
    }

    public String getCompanyAddressZipCode() {
        return companyAddressZipCode;
    }

    public void setCompanyAddressZipCode(String companyAddressZipCode) {
        this.companyAddressZipCode = companyAddressZipCode;
    }

    public String getCompanyAddressCity() {
        return companyAddressCity;
    }

    public void setCompanyAddressCity(String companyAddressCity) {
        this.companyAddressCity = companyAddressCity;
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
        CorporateIdDTO that = (CorporateIdDTO) o;
        return valid == that.valid && Objects.equals(firstName, that.firstName) && Objects.equals(familyName, that.familyName) && Objects.equals(companyName, that.companyName) && Objects.equals(companySubject, that.companySubject) && Objects.equals(companyAddressStreet, that.companyAddressStreet) && Objects.equals(companyAddressZipCode, that.companyAddressZipCode) && Objects.equals(companyAddressCity, that.companyAddressCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, familyName, companyName, companySubject, companyAddressStreet, companyAddressZipCode, companyAddressCity, valid);
    }

    @Override
    public String toString() {
        return "CorporateIdDTO [companyAddressCity=" + companyAddressCity + ", companyAddressStreet="
            + companyAddressStreet + ", companyAddressZipCode=" + companyAddressZipCode + ", companyName="
            + companyName + ", companySubject=" + companySubject + ", familyName=" + familyName + ", firstName="
            + firstName + ", valid=" + valid + "]";
    }


}
