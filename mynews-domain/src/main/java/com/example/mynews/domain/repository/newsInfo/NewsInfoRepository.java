package com.example.mynews.domain.repository.newsInfo;

import com.example.mynews.domain.model.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsInfoRepository {
    List<News> findAllNews(Pageable pageable);
    News findById(String newsId);
    List<News> findByCategory(String category);
    List<News> findByCriteria(
            @Param("criteria") NewsInfoSearchCriteria criteria,
            @Param("pageable") Pageable pageable);
    List<String> findAllCategories();
    long countAllNews();
    long countBySearchCriteria(@Param("criteria") NewsInfoSearchCriteria criteria);
    long countByCategory(String categoty);
}
