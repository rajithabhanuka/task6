package com.code.task6.model;

import com.code.task6.dto.PlanDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plan")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_level", referencedColumnName="id")
    private HierDimEntity planLevel;

    @Column(name = "role")
    private String role;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "action")
    private String action;

    @Column(name = "version")
    private Long versionNbr;

    public PlanDto toDto(){
        PlanDto dto =  new PlanDto();
        BeanUtils.copyProperties(this ,dto);
        return dto;
    }
}
