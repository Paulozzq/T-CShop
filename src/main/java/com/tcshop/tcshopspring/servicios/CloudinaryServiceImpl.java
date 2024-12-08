package com.tcshop.tcshopspring.servicios;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dijr92ntz");  // Reemplaza con tu cloud_name
        config.put("api_key", "357767884489355");    // Reemplaza con tu api_key
        config.put("api_secret", "AGA1sLP9K3euxSVF1eeV89uVJ1c");  // Reemplaza con tu api_secret

        this.cloudinary = new Cloudinary(config);
    }

    @PostConstruct
    public void init() {
        System.out.println("Cloudinary Service initialized successfully: " + cloudinary.config.cloudName);
    }


    @Override
    public Map<String, String> upload(MultipartFile multipartFile) throws IOException {
        File file = convertToFile(multipartFile); // Convertir MultipartFile a File
        try {
            // Subir el archivo a Cloudinary y obtener el resultado
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return Map.of(
                    "url", uploadResult.get("url").toString(),
                    "public_id", uploadResult.get("public_id").toString()
            );
        } finally {
            // Eliminar archivo temporal
            if (file.exists()) {
                file.delete();
            }
        }
    }


    @Override
    public Map<String, String> delete(String publicId) throws IOException {
        Map<String, Object> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        return Map.of(
                "result", result.get("result").toString()
        );
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
        }
        return file;
    }
}
