package com.setplex.middleware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.setplex.middleware.domain.Package;

public interface PackageRepo extends JpaRepository<Package, Integer> {
}
