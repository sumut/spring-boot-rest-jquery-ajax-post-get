package com.sumutella.queryajax.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sumutella
 * @time 10:54 AM
 * @since 12/7/2019, Sat
 */
@Controller
public class IndexController {

    @GetMapping({"/", "/index", "", "/index.html"})
    public String homepage(){
        return "index";
    }
}