/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.jmsdz10.service;

import com.it355.jmsdz10.model.DrogerijaResponse;
import com.it355.jmsdz10.model.Kozmetika;
import java.util.Map;

/**
 *
 * @author Jovana BGD
 */
public interface KozmetikaService {

    public void sendKozmetika(Kozmetika kozmetika);

    public void updateKozmetika(DrogerijaResponse response);

    public Map<String, Kozmetika> getKozmetike();
}
