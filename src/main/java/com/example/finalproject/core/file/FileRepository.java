package com.example.finalproject.core.file;

import com.example.finalproject.application.files.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, String> {
//    void save(FileEntity file);
}
