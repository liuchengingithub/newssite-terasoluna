package com.example.mynews.domain.service.NewsInfo;

import com.example.mynews.domain.model.News;
import com.example.mynews.domain.repository.newsInfo.NewsInfoRepository;
import com.example.mynews.domain.repository.newsInfo.NewsInfoSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class NewsInfoServiceImpl implements NewsInfoService{
    @Inject
    NewsInfoRepository newsInfoRepository;

    @Override
    public Page<News> findAllNews(Pageable pageable) {
        List<News> content = newsInfoRepository.findAllNews(pageable);
        long total = newsInfoRepository.countAllNews();
        Page<News> page = new PageImpl(content, pageable, total);
        return page;
    }

    @Override
    public News findById(String newsId) {
        System.out.printf("newsInfoServiceImpl"+newsInfoRepository.findById(newsId));
        return newsInfoRepository.findById(newsId);
    }

    @Override
    public Page<News> findByCategory(String category, Pageable pageable){
        List<News> content = newsInfoRepository.findByCategory(category);
        long total = newsInfoRepository.countByCategory(category);
        Page<News> page = new PageImpl(content, pageable, total);
        return page;
    }

    @Override
    public Page<News> findByCriteria(NewsInfoSearchCriteria criteria, Pageable pageable) {
        List<News> content = newsInfoRepository.findByCriteria(criteria, pageable);
        long total = newsInfoRepository.countBySearchCriteria(criteria);
        Page<News> page = new PageImpl(content, pageable, total);
        return page;
    }

    @Override
    public List<String> findAllCategories(){
        return newsInfoRepository.findAllCategories();
    }

}
