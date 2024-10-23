//package com.ordermgmt.model;
//
//import java.time.LocalTime;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Data
//@Table(name = "order")
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@OneToMany(cascade = CascadeType.PERSIST)
//	@JoinColumn
//	private List<OrderItem> orderItems;
//	private Double totalAmount;
//	private Category Category;
//	private String customerName;
//	private String customerPhone;
//	private LocalTime createdAt;
//
//}