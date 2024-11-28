package com.langgomsport.langgomsport.service;

import com.langgomsport.langgomsport.models.Banner;
import com.langgomsport.langgomsport.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    public List<Banner> getAllBanner(){
        return bannerRepository.findAll();
    }
}
