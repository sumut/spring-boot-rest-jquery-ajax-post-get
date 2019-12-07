package com.sumutella.queryajax.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sumutella
 * @time 10:41 AM
 * @since 12/7/2019, Sat
 */
@Entity
@Table(name ="EMPLOYEES")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @Column(name = "employee_id")
    @SequenceGenerator(sequenceName = "EMPLOYEES_SEQ", name = "empSeq", allocationSize = 1)
    @GeneratedValue(generator = "empSeq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "hire_date")
    private Date hireDate;
}
