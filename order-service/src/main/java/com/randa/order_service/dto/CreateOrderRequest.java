package com.randa.order_service.dto;
/*
 * DTO utilisé pour recevoir les données
 * envoyées par le client lors de la création
 * d'une commande.
 *
 * Exemple de requête HTTP :
 *
 * POST /orders
 *
 * {
 *     "productId": 1,
 *     "quantity": 2
 * }
 */
public record CreateOrderRequest(
        Long productId,
        Integer quantity
) {
}