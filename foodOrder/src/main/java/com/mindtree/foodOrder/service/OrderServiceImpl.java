package com.mindtree.foodOrder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.foodOrder.model.Order;
import com.mindtree.foodOrder.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	 private OrderRepository orderRepository;

	    @Autowired
	    public OrderServiceImpl(OrderRepository orderRepository) {
	        this.orderRepository = orderRepository;
	    }

	    @Override
	    public Order createOrder(Order order) {
	        order.setOrderTime(System.currentTimeMillis());
	        order.setTotalPrice(order.getItems().stream().mapToInt(e -> e.getPrice() * e.getQuantity()).sum());
	        return orderRepository.save(order);
	    }

}
