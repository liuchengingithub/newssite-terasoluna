package com.example.mynews.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    private String newsId;

    private String newsTitle;

    private String newsContent;

    private String newsAuthor;

    private DateTime newsPostDate;

    private String newsCategory;

}
