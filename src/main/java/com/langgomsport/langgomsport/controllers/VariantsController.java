package com.langgomsport.langgomsport.controllers;

import com.langgomsport.langgomsport.models.Variant;
import com.langgomsport.langgomsport.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http:/localhost:3000", "http://fe-langgomsport-bucket.s3-website-ap-southeast-1.amazonaws.com"})
@RequestMapping("api/variants")
public class VariantsController {
    @Autowired
    private VariantService variantService ;

    @GetMapping
    public ResponseEntity<List<Variant>> getAlVariantByIds(
            @RequestParam List<Integer> ids
    ){
        List<Variant> variants = variantService.getAllVariantsByIds(ids);
        return ResponseEntity.ok().body(variants);
    }

}
