package com.example.mynews.app;

import com.example.mynews.app.newsEdit.NewsEditForm;
import com.example.mynews.app.search.SearchNewsForm;
import com.example.mynews.domain.service.NewsInfo.NewsInfoService;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.inject.Inject;
import java.util.List;

public class BaseController {
    @Inject
    NewsInfoService newsInfoService;

    @ModelAttribute
    public SearchNewsForm setUpSearchNewsForm(){
        SearchNewsForm searchNewsForm = new SearchNewsForm();
        return searchNewsForm;
    }

    @ModelAttribute(value = "categories")
    public List<String> setUpCategories(){
        List<String> categories = newsInfoService.findAllCategories();
        return categories;
    }
}
