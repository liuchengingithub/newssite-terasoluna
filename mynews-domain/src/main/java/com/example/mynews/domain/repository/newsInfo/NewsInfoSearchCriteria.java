package com.example.mynews.domain.repository.newsInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NewsInfoSearchCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private String keyword;

    private String category;

    private Date oldestPostDate;
}
