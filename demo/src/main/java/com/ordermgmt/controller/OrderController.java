package com.ordermgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermgmt.model.MenuItem;
import com.ordermgmt.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create_menu_item")
	private MenuItem createMenuItem(@RequestBody MenuItem menuItem) {

		return orderService.createMenuItem(menuItem);
	}
}
