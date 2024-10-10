package com.langgomsport.langgomsport.controller;

import com.langgomsport.langgomsport.models.Product;
import com.langgomsport.langgomsport.models.Size;
import com.langgomsport.langgomsport.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
@CrossOrigin
public class SizesController {
    @Autowired
    private SizeService sizeService;

    @GetMapping
    public List<Size> getAllSizes() {
        return sizeService.getAllSizes();
    }
}
