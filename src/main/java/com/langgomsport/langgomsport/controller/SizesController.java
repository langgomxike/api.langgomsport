package com.langgomsport.langgomsport.controller;

import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.models.Size;
import com.langgomsport.langgomsport.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
@CrossOrigin
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
