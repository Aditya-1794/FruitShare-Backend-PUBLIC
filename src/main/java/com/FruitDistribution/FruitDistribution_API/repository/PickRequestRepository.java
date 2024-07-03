package com.FruitDistribution.FruitDistribution_API.repository;

import com.FruitDistribution.FruitDistribution_API.domain.PickRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PickRequestRepository extends JpaRepository<PickRequest, String> {
    Optional<PickRequest> findByID(String id);
}
