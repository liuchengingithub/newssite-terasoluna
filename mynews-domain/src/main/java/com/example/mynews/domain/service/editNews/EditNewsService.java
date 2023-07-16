package com.example.mynews.domain.service.editNews;

import com.example.mynews.domain.model.News;
import com.example.mynews.domain.repository.newsInfo.NewsInfoSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EditNewsService {
    void insert(News news);

    void update(News news);

    void delete(String newsId);
}
