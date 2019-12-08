package com.sumutella.queryajax.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author sumutella
 * @time 11:21 AM
 * @since 12/8/2019, Sun
 */

@Entity
@Table(name = "countries")
@Setter
@Getter
@NoArgsConstructor
public class Country {
    @Id
    @Column(name = "country_id")
    @JsonIgnore
    private String id;
    @Column(name = "country_name")
    private String countryName;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "region_id")
    private Region region;
}
