package com.example.mynews.app.fileUpload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class FileUploadForm implements Serializable {
    private MultipartFile file;

    @NotNull
    @Size(min = 0, max = 100)
    private String description;
}
