/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.jmsdz10.service;

/**
 *
 * @author Jovana BGD
 */
import com.it355.jmsdz10.model.Kozmetika;
import java.util.Map;

public interface KozmetikaRepository {

    public void putKozmetika(Kozmetika kozmetika);

    public Kozmetika getKozmetika(String kozmetikaId);

    public Map<String, Kozmetika> getKozmetike();
}
