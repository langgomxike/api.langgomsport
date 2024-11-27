package com.langgomsport.langgomsport.controller;

import com.langgomsport.langgomsport.models.Collection;
import com.langgomsport.langgomsport.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
@RequestMapping("/api/collections")
public class CollectionsController {
    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public ResponseEntity<List<Collection>> getAllCollections(){
        List<Collection> collections = collectionService.getAllCollections();
        return ResponseEntity.ok(collections);
    }
}
