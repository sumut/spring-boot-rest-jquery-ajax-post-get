package com.sumutella.queryajax.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sumutella
 * @time 11:20 AM
 * @since 12/8/2019, Sun
 */


@Entity
@Table(name = "regions")
@Setter
@Getter
@NoArgsConstructor
public class Region {

    @Id
    @Column(name = "region_id")
    @SequenceGenerator(name = "seqRegion", sequenceName = "REGIONS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "seqRegion", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="region_name")
    private String name;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region" )
    private Set<Country> countries = new HashSet<>();
}
