package com.randa.inventory_service.service;


import com.randa.inventory_service.dto.InventoryResponse;
import com.randa.inventory_service.exception.ProductNotFoundException;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 * @Service indique à Spring que cette classe service donc contient la logique métier.
 *
 * Spring va créer automatiquement une instance de cette classe
 * et pourra l'injecter dans d'autres composants.
 */
@Service
public class InventoryService {


    private final Map<Long, InventoryResponse> inventory = new HashMap<>(); 

    /*
     * Pour le moment, nous n'avons PAS de base de données.
     *
     * Nous simulons donc notre stock directement en mémoire.
     *
     * Plus tard, nous pourrons inejcter Repositorypour avoire au final :
     *
     * Controller
     *     ↓
     * Service
     *     ↓
     * Repository
     *     ↓
     * Database
     */

        /*
     * Constructeur :
     * on initialise nos 3 produits en mémoire.
     */
    public InventoryService() {

        inventory.put(
                1L,
                new InventoryResponse(
                        1L,
                        "Laptop",
                        10,
                        true
                )
        );

        inventory.put(
                2L,
                new InventoryResponse(
                        2L,
                        "Mouse",
                        25,
                        true
                )
        );

        inventory.put(
                3L,
                new InventoryResponse(
                        3L,
                        "Keyboard",
                        0,
                        false
                )
        );
    }

    public InventoryResponse getInventory(Long productId) {  //Recherche du produit dans la mémoire
        
        InventoryResponse product = inventory.get(productId);
        if (product == null) { // Si le produit n'existe pas on lance notre exception métier.
            throw new ProductNotFoundException(productId);
        }
            return product;

    }
}
