package com.code.task6.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hier")
public class HierDimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToOne(mappedBy = "planLevel")
    private PlanEntity planEntity;
}
