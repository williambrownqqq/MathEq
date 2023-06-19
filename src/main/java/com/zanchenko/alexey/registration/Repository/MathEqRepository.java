package com.zanchenko.alexey.registration.Repository;

import com.zanchenko.alexey.registration.Entity.MathematicalEquation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MathEqRepository extends JpaRepository<MathematicalEquation, Long> {
}
