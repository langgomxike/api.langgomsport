package com.langgomsport.langgomsport.services;

import com.langgomsport.langgomsport.models.Banner;
import com.langgomsport.langgomsport.repositories.BannerRepository;
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
