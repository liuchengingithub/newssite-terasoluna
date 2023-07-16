package com.example.mynews.domain.service.NewsInfo;

import com.example.mynews.domain.model.News;
import com.example.mynews.domain.repository.newsInfo.NewsInfoSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface NewsInfoService {
    Page<News> findAllNews(Pageable pageable);
    News findById(String newsId);
    Page<News> findByCategory(String category, Pageable pageable);
    Page<News> findByCriteria(NewsInfoSearchCriteria criteria, Pageable pageable);
    List<String> findAllCategories();
}
