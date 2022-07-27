package com.example.reactivepostgresdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.security.RolesAllowed;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private Integer id;
    @Column
    private String name;
}
