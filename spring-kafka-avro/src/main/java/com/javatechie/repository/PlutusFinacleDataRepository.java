package com.javatechie.repository;

import com.javatechie.entity.PlutusFinacleDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlutusFinacleDataRepository extends JpaRepository<PlutusFinacleDataEntity, String> {
} 