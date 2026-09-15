package com.randa.inventory_service.controller;


import com.randa.inventory_service.dto.InventoryResponse;
import com.randa.inventory_service.exception.ProductNotFoundException;
import com.randa.inventory_service.service.InventoryService;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
 * @RestController indique que cette classe est un contrôleur REST.
 *
 * Elle reçoit les requêtes HTTP venant des clients
 * et retourne généralement des données JSON.
 */
@RestController

/*
 * Toutes les URLs de ce Controller commenceront par :
 *
 * /inventory
 *
 * Donc :
 *
 * @GetMapping("/{productId}") -> GET /inventory/{productId}
 */
@RequestMapping("/inventory")
public class InventoryController {

    /*
     * Notre Controller a besoin du InventoryService
     * pour exécuter la logique métier.
     * On utilise l'injection par constructeur.
     */
    private final InventoryService inventoryService;

    /*
     * Spring détecte automatiquement ce constructeur
     * et injecte une instance de InventoryService.
     * Grâce à @Service sur InventoryService,
     * Spring connaît déjà cet objet.
     */

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productId}")
    //@PathVariable permet de récupérer la valeur présente dans l'URL.
    public InventoryResponse getInventory(@PathVariable Long productId) { 
        return inventoryService.getInventory(productId);
    }

    /*
    @ExceptionHandler fonctionne comme un mécanisme d'interception automatique.
    Si une ProductNotFoundException se produit pendant le traitement d'une requête de ce Controller, utilise cette méthode pour la gérer.
     */
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleProductNotFound(
            ProductNotFoundException exception
    ) {

        return Map.of(
                "message",
                exception.getMessage()
        );
    }
}

