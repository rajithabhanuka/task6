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
    private int id;

    @Column(name = "plan_level")
    private String planLevel;

    @Column(name = "role")
    private String role;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private int userId;

    public PlanDto toDto(){
        PlanDto dto =  new PlanDto();
        BeanUtils.copyProperties(this ,dto);
        return dto;
    }
}
