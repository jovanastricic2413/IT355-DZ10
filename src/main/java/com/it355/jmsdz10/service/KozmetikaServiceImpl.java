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
import com.it355.jmsdz10.messaging.MessageSender;
import com.it355.jmsdz10.model.DrogerijaResponse;
import com.it355.jmsdz10.model.Kozmetika;
import com.it355.jmsdz10.model.KozmetikaStatus;
import com.it355.jmsdz10.util.BasicUtil;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("kozmetikaService")
public class KozmetikaServiceImpl implements KozmetikaService {

    static final Logger LOG = LoggerFactory.getLogger(KozmetikaServiceImpl.class);
    @Autowired
    MessageSender messageSender;
    @Autowired
    KozmetikaRepository kozmetikaRepository;

    @Override
    public void sendKozmetika(Kozmetika kozmetika) {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        kozmetika.setKozmetikaId(BasicUtil.getUniqueId());
        kozmetika.setStatus(KozmetikaStatus.CREATED);
        kozmetikaRepository.putKozmetika(kozmetika);
        LOG.info("Application : sending order request {}", kozmetika);
        messageSender.sendMessage(kozmetika);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void updateKozmetika(DrogerijaResponse response) {
        Kozmetika kozmetika = kozmetikaRepository.getKozmetika(response.getKozmetikaId());
        if (response.getReturnCode() == 200) {
            kozmetika.setStatus(KozmetikaStatus.CONFIRMED);
        } else if (response.getReturnCode() == 300) {
            kozmetika.setStatus(KozmetikaStatus.FAILED);
        } else {
            kozmetika.setStatus(KozmetikaStatus.PENDING);
        }
        kozmetikaRepository.putKozmetika(kozmetika);
    }

    public Map<String, Kozmetika> getKozmetike() {
        return kozmetikaRepository.getKozmetike();
    }
}
