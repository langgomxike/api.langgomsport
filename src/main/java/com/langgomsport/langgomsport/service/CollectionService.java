package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.models.Collection;
import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAllCollections(){
        List<Collection> collections = collectionRepository.findAll();
        collections.forEach(collection -> {
            if (collection.getProducts() != null) {
                List<Product> filteredProducts = collection.getProducts().stream()
                        .filter(Objects::nonNull) // Loại bỏ phần tử null
                        .collect(Collectors.toList());
                collection.setProducts(filteredProducts); // Cập nhật lại danh sách products
            }
        });
        return collections;
    }
}
