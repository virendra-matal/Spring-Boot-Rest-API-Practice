package com.spring.boot.springbootrestapi.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FleUploadHepler {

    // public final String DIRECTORY_PATH = "C:\\Users\\viren\\Documents\\spring\\springbootrestapi\\src\\main\\resources\\static\\images";
    public final String DIRECTORY_PATH = new ClassPathResource("static/images").getFile().getAbsolutePath();
    

    public FleUploadHepler()throws IOException{}

    public boolean FileUploader(MultipartFile mfile) {
        boolean f = false;
        try {
            Files.copy(mfile.getInputStream(), Paths.get(DIRECTORY_PATH+File.separator+mfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
