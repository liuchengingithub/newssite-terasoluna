package com.example.mynews.app.search;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class SearchNewsForm implements Serializable {

    public static final long serialVersionUID = 1L;

    @NotBlank
    private String keyword;

    @NotEmpty
    private String category;

//    @Past
//    private Date postDate;

    private String postDateRange;
}
