package com.sumutella.queryajax.controllers;

import com.sumutella.queryajax.entities.Country;
import com.sumutella.queryajax.entities.Region;
import com.sumutella.queryajax.entities.ResponseEntity;
import com.sumutella.queryajax.repositories.CountryRepository;
import com.sumutella.queryajax.repositories.RegionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author sumutella
 * @time 2:04 PM
 * @since 12/8/2019, Sun
 */
@RestController
@RequestMapping("api/regions")
public class RegionRestController {
    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    public RegionRestController(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    @GetMapping("/api/{regionId}")
    public ResponseEntity<Country> getCountries(@PathVariable Integer regionId){
        ResponseEntity<Country> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus("Done");
        responseEntity.setData(countryRepository.findCountriesByRegion(regionRepository.findRegionById(regionId)));
        return responseEntity;
    }




}
