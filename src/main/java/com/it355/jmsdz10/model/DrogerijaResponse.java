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

public class DrogerijaResponse implements Serializable {

    private String kozmetikaId;
    private int returnCode;
    private String comment;

    public String getKozmetikaId() {
        return kozmetikaId;
    }

    public void setKozmetikaId(String kozmetikaId) {
        this.kozmetikaId = kozmetikaId;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        DrogerijaResponse kozmetika = (DrogerijaResponse) obj;
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
        return "DrogerijaResponse [kozmetikaId=" + kozmetikaId + ", returnCode = " + returnCode + ", comment = " + comment + "]";
    }
}
