package com.mindtree.foodOrder.controller;
import com.mindtree.foodOrder.model.*;
import com.mindtree.foodOrder.service.*;
import com.mindtree.foodOrder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CreateOrderController {
	 OrderService orderService;

	    @Autowired
	    public CreateOrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }

	    @RequestMapping(value = "/restaurants/{rid}/orders", method = RequestMethod.POST)
	    @ResponseStatus(value = HttpStatus.CREATED)
	    public Order createOder(@RequestBody Order order) {
	        return orderService.createOrder(order);
	    }
}
