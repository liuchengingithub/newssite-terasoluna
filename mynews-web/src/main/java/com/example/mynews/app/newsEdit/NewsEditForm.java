package com.example.mynews.app.newsEdit;

import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class NewsEditForm implements Serializable {
    public static final long serialVersionUID = 1L;

    //@NotBlank
    private String NewsId;

    @NotBlank
    @Size(max = 30)
    private String newsTitle;

    @NotBlank
    private String newsContent;

    @NotBlank
    private String newsAuthor;

    @Past
    private DateTime newsPostDate;

    @NotBlank
    private String newsCategory;
}
