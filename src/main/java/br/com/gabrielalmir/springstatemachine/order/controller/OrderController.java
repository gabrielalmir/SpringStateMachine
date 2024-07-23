package br.com.gabrielalmir.springstatemachine.order.controller;

import br.com.gabrielalmir.springstatemachine.order.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("new")
    public String newOrder() {
        orderService.newOrder();
        return "new order";
    }

    @PostMapping("pay")
    public String payOrder() {
        orderService.payOrder();
        return "pay order";
    }

    @PostMapping("ship")
    public String shipOrder() {
        orderService.shipOrder();
        return "ship order";
    }

    @PostMapping("complete")
    public String completeOrder() {
        orderService.completeOrder();
        return "complete order";
    }
}
