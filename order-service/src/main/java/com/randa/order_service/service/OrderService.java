package com.randa.order_service.service;

import com.randa.order_service.dto.CreateOrderRequest;
import com.randa.order_service.dto.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {


    private final Map<Long, OrderResponse> orders = new HashMap<>();

    /*
     * Compteur permettant de générer automatiquement
     * un nouvel ID pour chaque commande.
     *
     * Première commande  -> 1
     * Deuxième commande  -> 2
     * Troisième commande -> 3
     */
    private Long nextOrderId = 1L;

    /*
     * Méthode métier permettant de créer une commande.
     */
    public OrderResponse createOrder(CreateOrderRequest request) {

        /*
         * On récupère le prochain ID disponible.
         */
        Long orderId = nextOrderId++;

        /*
         * On construit notre réponse.
         */
        OrderResponse order = new OrderResponse(
                orderId,
                request.productId(),
                request.quantity(),
                "CREATED"
        );

        /*
         * On sauvegarde la commande dans notre Map.
         */
        orders.put(orderId, order);

        /*
         * On retourne la commande créée.
         */
        return order;
    }
}