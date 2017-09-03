/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.jmsdz10.model;

/**
 *
 * @author Jovana BGD
 */
import java.io.Serializable;

public class Kozmetika implements Serializable {

    private String kozmetikaId;
    private String proizvodName;
    private int kolicina;
    private KozmetikaStatus status;

    public String getKozmetikaId() {
        return kozmetikaId;
    }

    public void setKozmetikaId(String kozmetikaId) {
        this.kozmetikaId = kozmetikaId;
    }

    public String getProizvodName() {
        return proizvodName;
    }

    public void setProizvodName(String proizvodName) {
        this.proizvodName = proizvodName;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public KozmetikaStatus getStatus() {
        return status;
    }

    public void setStatus(KozmetikaStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((kozmetikaId == null) ? 0 : kozmetikaId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Kozmetika kozmetika = (Kozmetika) obj;
        if (kozmetikaId == null) {
            if (kozmetika.kozmetikaId != null) {
                return false;
            }
        } else if (!kozmetikaId.equals(kozmetika.kozmetikaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kozmetika [kozmetikaId=" + kozmetikaId + ", proizvodName="
                + proizvodName + ", kolicina=" + kolicina + ", status="
                + status + "]";
    }
}
