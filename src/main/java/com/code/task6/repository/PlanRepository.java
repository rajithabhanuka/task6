package com.code.task6.repository;

import com.code.task6.model.PlanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanRepository extends CrudRepository<PlanEntity, Integer> {

    List<PlanEntity> findByUserId(int userId);

    @Query(value = "SELECT h.name as planLevel, p.role as role, p.type as type FROM plan p " +
            "INNER JOIN hier h ON p.plan_level=h.id " +
            "WHERE p.user_id = :userId", nativeQuery = true)
    List<CustomPlanEntity> findCustomPlanEntity(int userId);

    interface CustomPlanEntity {

        String getPlanLevel();

        String getRole();

        String getType();
    }
}
