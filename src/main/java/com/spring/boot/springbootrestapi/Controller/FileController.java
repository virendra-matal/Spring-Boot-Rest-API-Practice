package com.spring.boot.springbootrestapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.springbootrestapi.Helper.FleUploadHepler;

@RestController
public class FileController {

    @Autowired
    private FleUploadHepler fleUploadHepler;

    @PostMapping("/upload")
    public ResponseEntity<String> FileUpload(@RequestParam("file") MultipartFile file) {

        try {

            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Request bosdy should not Empty...");
            }

            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image should be JPEG type....");
            }

            boolean f = fleUploadHepler.FileUploader(file);
            if (f) {

                // return ResponseEntity.ok("File Uploaded SuccessFully !!!!!");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());

            }
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getContentType());
            System.out.println(file.getSize());
            System.out.println(file.getResource());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Oops! Something went wrong, Please try Again...");
    }
}
