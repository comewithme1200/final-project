package com.example.finalproject.api;

import com.example.finalproject.application.files.FileEntity;
import com.example.finalproject.application.files.FileService;
import com.example.finalproject.core.file.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileApi {

    @Autowired
    FileRepository fileRepository;

    @PostMapping()
    public FileEntity saveFile(@RequestPart("file") MultipartFile file) throws IOException {
        FileEntity newFile = new FileEntity(UUID.randomUUID().toString(), StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())), file.getContentType(), file.getSize(), file.getBytes());
        return fileRepository.save(newFile);
    }
}
