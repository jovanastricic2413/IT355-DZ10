/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.jmsdz10.util;

/**
 *
 * @author Jovana BGD
 */
import java.util.UUID;

public class BasicUtil {

    public static String getUniqueId() {
        return UUID.randomUUID().toString();
    }
}
