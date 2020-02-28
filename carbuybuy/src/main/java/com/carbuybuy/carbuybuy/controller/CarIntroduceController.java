package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 汽车详情页面控制器
 */
@Controller
@RequestMapping("/cars")
public class CarIntroduceController {
    @Autowired
    private CarsService carsService;

    @RequestMapping("/index")
    public String index(String id, Model model, HttpSession session){
        if(id==null||session.getAttribute("userId")==null){
            return "404";
        }
        int carId = Integer.parseInt(id);
        Cars car = carsService.selectById(carId);
        model.addAttribute("car",car);
        return "productIndex";
    }

}
