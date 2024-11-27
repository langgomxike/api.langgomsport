package com.langgomsport.langgomsport.controller;

import com.langgomsport.langgomsport.models.HomeBrand;
import com.langgomsport.langgomsport.service.HomeBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
@RequestMapping("/api/home-brands")
public class HomeBrandsController {
    @Autowired
    private HomeBrandService homeBrandService;

    @GetMapping
    public ResponseEntity<List<HomeBrand>> getHomeBrands() {
        List<HomeBrand> homeBrands = homeBrandService.getAllHomeBrand();
        return ResponseEntity.ok(homeBrands);
    }
}
