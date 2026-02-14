package com.example.demo;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    private Cloudinary cloudinary;

    public CloudinaryService() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name", System.getenv("CLOUDINARY_CLOUD_NAME"));
        valuesMap.put("api_key", System.getenv("CLOUDINARY_API_KEY"));
        valuesMap.put("api_secret", System.getenv("CLOUDINARY_API_SECRET"));
        cloudinary = new Cloudinary(valuesMap);
    }

    public String subirImagen(MultipartFile file) {
        try {
            // Sube la imagen y devuelve un Map con los resultados
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            // Extraemos la URL directa de la imagen
            return (String) uploadResult.get("url");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
