package com.example.mynews.domain.service.editNews;

import com.example.mynews.domain.model.News;
import com.example.mynews.domain.repository.editNews.EditNewsRepository;
import com.example.mynews.domain.repository.newsInfo.NewsInfoRepository;
import com.example.mynews.domain.repository.newsInfo.NewsInfoSearchCriteria;
import com.example.mynews.domain.service.NewsInfo.NewsInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class EditNewsServiceImpl implements EditNewsService {
    @Inject
    EditNewsRepository editNewsRepository;

    @Override
    public void insert(News news) {
        editNewsRepository.insert(news);
    }

    @Override
    public void update(News news){
        editNewsRepository.update(news);
    }

    @Override
    public void delete(String newsId){
        editNewsRepository.delete(newsId);
    }
}
