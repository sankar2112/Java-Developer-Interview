package com.ordermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ordermgmt.model.MenuItem;
import com.ordermgmt.repo.MenuItemRepo;

@Service
public class OrderService {

	@Autowired
	private MenuItemRepo menuItemRepo;

	public MenuItem createMenuItem(MenuItem menuItem) {

		return menuItemRepo.save(menuItem);

	}

}
