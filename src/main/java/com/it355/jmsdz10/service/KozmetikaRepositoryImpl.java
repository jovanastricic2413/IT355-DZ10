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
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service("kozmetikaRepository")
public class KozmetikaRepositoryImpl implements KozmetikaRepository {

    private final Map<String, Kozmetika> kozmetike = new ConcurrentHashMap<String, Kozmetika>();

    @Override
    public void putKozmetika(Kozmetika kozmetika) {
        kozmetike.put(kozmetika.getKozmetikaId(), kozmetika);
    }

    @Override
    public Kozmetika getKozmetika(String kozmetikaId) {
        return kozmetike.get(kozmetikaId);
    }

    @Override
    public Map<String, Kozmetika> getKozmetike() {
        return kozmetike;
    }
}
