package com.setplex.middleware.repository;

import com.setplex.middleware.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PackageRepo extends JpaRepository<Package, Integer> {

    @Query("SELECT DISTINCT p FROM Package p JOIN FETCH p.channels")
    public List<Package> findAllWithDeps();
}
