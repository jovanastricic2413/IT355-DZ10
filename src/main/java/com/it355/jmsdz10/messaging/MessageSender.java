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
import com.it355.jmsdz10.model.Kozmetika;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Kozmetika kozmetika) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws
                    JMSException {
                ObjectMessage objectMessage
                        = session.createObjectMessage(kozmetika);
                return objectMessage;
            }
        });
    }
}
