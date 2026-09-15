package com.randa.order_service.dto;
/*
 * DTO utilisé pour retourner les informations
 * d'une commande créée.
 *
 * Exemple de réponse :
 *
 * {
 *     "orderId": 1,
 *     "productId": 1,
 *     "quantity": 2,
 *     "status": "CREATED"
 * }
 */
public record OrderResponse(
        Long orderId,
        Long productId,
        Integer quantity,
        String status
) {
}