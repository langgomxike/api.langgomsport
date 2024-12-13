package com.langgomsport.langgomsport.controllers;

import com.langgomsport.langgomsport.models.Size;
import com.langgomsport.langgomsport.services.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
@CrossOrigin (origins = {"http://localhost:3000", "http://fe-langgomsport-bucket.s3-website-ap-southeast-1.amazonaws.com"})
public class SizesController {
    @Autowired
    private SizeService sizeService;

//    @GetMapping
//    public List<Size> getAllSizes() {
//        return sizeService.getAllSizes();
//    }

    @GetMapping
    public List<Size> getAllSizes(
            @RequestParam(required = false) Integer categoryId
    ){
        return sizeService.getSizebyCategories(categoryId);
    }
}
