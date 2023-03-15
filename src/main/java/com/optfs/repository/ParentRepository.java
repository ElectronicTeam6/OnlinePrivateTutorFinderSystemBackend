package com.optfs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optfs.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
	
	@Query("from Parent p where p.id=:id")
	public Parent getParentById(@Param(value="id")Integer id );

	
	@Query("from Parent p where p.email=:email and p.password=:password")
	public Parent findParentByEmailPassword(@Param(value="email") String email, @Param(value="password")String password);
	
}