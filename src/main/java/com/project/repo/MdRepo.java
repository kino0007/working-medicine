package com.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Md;

@Repository
public interface MdRepo extends JpaRepository<Md, Integer> {

	@Transactional
	@Modifying
	@Query("Update Md Set stock= :stock where name=:name")
	public Integer updateByName(String name, int stock);
	
	public Md findByName(String name);
	
	public List<Md> findByNameContains(String name);
	
	@Transactional
	@Modifying
	@Query("Update Md Set stock= :stock, price = :price where name=:name")
	public Integer updateByName(String name, int stock, double price);
	
}
