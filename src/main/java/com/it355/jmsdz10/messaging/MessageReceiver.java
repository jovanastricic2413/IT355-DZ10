/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.jmsdz10.messaging;

/**
 *
 * @author Jovana BGD
 */
import com.it355.jmsdz10.model.DrogerijaResponse;
import com.it355.jmsdz10.service.KozmetikaService;
import javax.jms.JMSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
    private static final String KOZMETIKA_RESPONSE_QUEUE = "kozmetika-response-queue";
    @Autowired
    KozmetikaService kozmetikaService;

    @JmsListener(destination = KOZMETIKA_RESPONSE_QUEUE)
    public void receiveMessage(final Message<DrogerijaResponse> message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers = message.getHeaders();
        LOG.info("Application : headers received : {}", headers);
        DrogerijaResponse response = message.getPayload();
        LOG.info("Application : response received : {}", response);
        kozmetikaService.updateKozmetika(response);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
