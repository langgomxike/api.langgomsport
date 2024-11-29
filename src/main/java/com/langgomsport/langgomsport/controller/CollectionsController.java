package com.langgomsport.langgomsport.controller;

import com.langgomsport.langgomsport.dtos.ResponseDTO.CollectionDTO;
import com.langgomsport.langgomsport.dtos.ResponseDTO.ProductDTO;
import com.langgomsport.langgomsport.models.Collection;
import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.models.VariantImage;
import com.langgomsport.langgomsport.service.CollectionService;
import com.langgomsport.langgomsport.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
@RequestMapping("/api/collections")
public class CollectionsController {
    @Autowired
    private CollectionService collectionService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<CollectionDTO>> getAllCollections(){
        List<CollectionDTO> collectionsResponse = new ArrayList<>();
        List<Collection> collections = collectionService.getAllCollections();
        for(Collection collection : collections){
            List<ProductDTO> productDTOs = new ArrayList<>();
            for(Product product : collection.getProducts()){
                List<VariantImage> images = productService.getImagesProducts(product);
                ProductDTO productDTO = new ProductDTO(product, images);
                productDTOs.add(productDTO);
            }
            CollectionDTO collectionDTO = new CollectionDTO(collection.getId(), collection.getName(), collection.getEnName(), collection.getImage(), collection.getLimitProduct(), productDTOs);
            collectionsResponse.add(collectionDTO);
        }
        return ResponseEntity.ok(collectionsResponse);
    }
}
