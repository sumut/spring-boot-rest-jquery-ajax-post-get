package com.sumutella.queryajax.controllers;

import com.sumutella.queryajax.repositories.RegionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sumutella
 * @time 11:28 AM
 * @since 12/8/2019, Sun
 */
@Controller
public class RegionController {
    private final RegionRepository regionRepository;

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @GetMapping({"/regions",  "/regions.html"})
    public String homepage(Model model){
        model.addAttribute("regions", regionRepository.findAll());
        return "regions";
    }
}
