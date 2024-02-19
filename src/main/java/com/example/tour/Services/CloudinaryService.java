package com.example.tour.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String uploadImage(MultipartFile file) throws IOException;
    boolean deleteImage(String publicId) throws IOException;
}
