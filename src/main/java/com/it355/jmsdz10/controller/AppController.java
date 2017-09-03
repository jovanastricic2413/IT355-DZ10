/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.jmsdz10.controller;

/**
 *
 * @author Jovana BGD
 */
import com.it355.jmsdz10.model.Kozmetika;
import com.it355.jmsdz10.service.KozmetikaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @Autowired
    KozmetikaService kozmetikaService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String prepareProduct(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = {"/newKozmetika"}, method = RequestMethod.GET)
    public String prepareKozmetika(ModelMap model) {
        Kozmetika kozmetika = new Kozmetika();
        model.addAttribute("kozmetika", kozmetika);
        return "kozmetika";
    }

    @RequestMapping(value = {"/newKozmetika"}, method = RequestMethod.POST)
    public String sendKozmetika(@Valid Kozmetika kozmetika, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "kozmetika";
        }
        kozmetikaService.sendKozmetika(kozmetika);
        model.addAttribute("success", "Kozmetika for "
                + kozmetika.getProizvodName() + " registered.");
        return "kozmetikasuccess";

    }

    @RequestMapping(value = {"/checkStatus"}, method = RequestMethod.GET)
    public String checkOrderStatus(ModelMap model) {
        model.addAttribute("kozmetike",
                kozmetikaService.getKozmetike());
        return "kozmetikaStatus";
    }
}
