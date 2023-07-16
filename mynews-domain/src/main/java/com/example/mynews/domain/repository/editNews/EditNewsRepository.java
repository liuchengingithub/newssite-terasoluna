package com.example.mynews.domain.repository.editNews;

import com.example.mynews.domain.model.News;

public interface EditNewsRepository {
    void insert(News news);
    void update(News news);

    void delete(String newsId);
}
