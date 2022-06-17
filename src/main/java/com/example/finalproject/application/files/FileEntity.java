package com.example.finalproject.application.files;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "files")
@Entity(name = "files")
public class FileEntity implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private String name;
    private String content_type;
    private Long size;
    @Column(name = "data")
    @Lob
    private byte[] data;
}
