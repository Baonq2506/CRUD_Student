package com.example.test.Controller;


import com.example.test.Model.Image;
import com.example.test.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity.BodyBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("image")
public class FileImageUploadController {
    @Autowired
    private  ImageService imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        imageService.store(file);
        return "Upload the image successfully ";
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Image imageDB = imageService.getImage(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageDB.getName() + "\"")
                .body(imageDB.getData());
    }

    @GetMapping("/files")
    public ResponseEntity<List<Image>> getListFiles() {
        List<Image> images = imageService.getAllImages().map(dbFile -> {
            return new Image(
                    dbFile.getName(),
                    dbFile.getType(),
                    dbFile.getData());
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(images);
    }

}
