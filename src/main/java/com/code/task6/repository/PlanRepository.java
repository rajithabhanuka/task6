package com.code.task6.repository;

import com.code.task6.model.PlanEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanRepository extends CrudRepository<PlanEntity, Integer> {

    List<PlanEntity> findByUserId(int userId);

}
