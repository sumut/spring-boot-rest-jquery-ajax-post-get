package com.sumutella.queryajax.repositories;

import com.sumutella.queryajax.entities.Country;
import com.sumutella.queryajax.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author sumutella
 * @time 12:30 PM
 * @since 12/8/2019, Sun
 */
@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findCountriesByRegion(Region region);
}
