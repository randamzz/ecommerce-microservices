package com.randa.inventory_service.dto;

/*
 * DTO = Data Transfer Object
 *
 * Son rôle est de définir les données que notre API va retourner au client.
 *
 * On ne retourne pas directement nos objets métier.
 * On définit volontairement une réponse propre et simple.

 */

public record InventoryResponse( //record évite d'écrire manuellement private final , getters/setters... Java génère automatiquement ces éléments.

        // Identifiant du produit
        Long productId,

        // Nom du produit
        String productName,

        // Quantité disponible en stock
        Integer quantity,

        // Indique si le produit est disponible
        Boolean available

) {
}