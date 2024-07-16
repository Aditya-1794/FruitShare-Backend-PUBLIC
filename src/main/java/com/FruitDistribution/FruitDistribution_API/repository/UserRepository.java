package com.FruitDistribution.FruitDistribution_API.repository;

import com.FruitDistribution.FruitDistribution_API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
