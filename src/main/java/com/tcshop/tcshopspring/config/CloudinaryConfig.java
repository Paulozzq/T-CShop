package com.tcshop.tcshopspring.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dijr92ntz",
                "api_key", "357767884489355",
                "api_secret", "AGA1sLP9K3euxSVF1eeV89uVJ1c"));
        return cloudinary;
    }
}
