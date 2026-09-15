package com.randa.order_service.controller;

import com.randa.order_service.dto.CreateOrderRequest;
import com.randa.order_service.dto.OrderResponse;
import com.randa.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    /*
     * Spring injecte automatiquement OrderService.
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*
     * POST /orders
     *
     * Cette méthode reçoit une requête contenant
     * les informations nécessaires pour créer une commande.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(
            @RequestBody CreateOrderRequest request
    ) {

        /*
         * Le Controller ne contient pas la logique métier.
         *
         * Il reçoit la requête puis délègue
         * le travail au Service.
         */
        return orderService.createOrder(request);
    }
}