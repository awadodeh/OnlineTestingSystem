package com.mum.pm.user_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.pm.user_module.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRole(String role);
	Role findById(int id);
}
