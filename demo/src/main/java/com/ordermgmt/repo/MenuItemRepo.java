package com.ordermgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ordermgmt.model.MenuItem;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long>{
	
	

}
