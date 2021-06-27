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

package com.ibm.ssi.integration.hotel.xml;

import java.util.Date;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Meldeschein {

    Date DatumAnkunft;

    Date DatumAbreise;

    String Familienname;

    String Vornamen;

    Anschrift Anschrift;

    String Geburtsdatum;

    Staatsangehoerigkeiten staatsangehoerigkeit;

    Beherbergungsstaette beherbergungsstaette;


    @XmlElement
    public Date getDatumAnkunft() {
        return DatumAnkunft;
    }

    public void setDatumAnkunft(Date datumAnkunft) {
        DatumAnkunft = datumAnkunft;
    }

    @XmlElement
    public Date getDatumAbreise() {
        return DatumAbreise;
    }

    public void setDatumAbreise(Date datumAbreise) {
        DatumAbreise = datumAbreise;
    }

    @XmlElement
    public String getFamilienname() {
        return Familienname;
    }

    public void setFamilienname(String familienname) {
        Familienname = familienname;
    }

    @XmlElement
    public String getVornamen() {
        return Vornamen;
    }

    public void setVornamen(String vornamen) {
        Vornamen = vornamen;
    }

    @XmlElement
    public String getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    @XmlElement
    public Staatsangehoerigkeiten getStaatsangehoerigkeit() {
        return staatsangehoerigkeit;
    }

    public void setStaatsangehoerigkeit(Staatsangehoerigkeiten staatsangehoerigkeit) {
        this.staatsangehoerigkeit = staatsangehoerigkeit;
    }

    @XmlElement
    public Beherbergungsstaette getBeherbergungsstaette() {
        return beherbergungsstaette;
    }

    public void setBeherbergungsstaette(Beherbergungsstaette beherbergungsstaette) {
        this.beherbergungsstaette = beherbergungsstaette;
    }

    @XmlElement
    public com.ibm.ssi.integration.hotel.xml.Anschrift getAnschrift() {
        return Anschrift;
    }

    public void setAnschrift(com.ibm.ssi.integration.hotel.xml.Anschrift anschrift) {
        Anschrift = anschrift;
    }
}
