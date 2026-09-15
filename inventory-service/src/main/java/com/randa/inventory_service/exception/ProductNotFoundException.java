package com.randa.inventory_service.exception;

/*
 * Exception métier personnalisée.
 *
 * Cette exception sera lancée lorsqu'un produit
 * demandé n'existe pas dans notre inventaire cela va etre utile lorsque on va ajouter order-service
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long productId) {

        /*
         * Le message sera utilisé dans notre réponse HTTP.
         */
        super("Product with id " + productId + " not found");
    }
}
