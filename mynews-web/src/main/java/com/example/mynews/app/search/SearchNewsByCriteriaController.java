package com.example.mynews.app.search;

import com.example.mynews.app.BaseController;
import com.example.mynews.domain.model.News;
import com.example.mynews.domain.repository.newsInfo.NewsInfoSearchCriteria;
import com.example.mynews.domain.service.NewsInfo.NewsInfoService;
import com.github.dozermapper.core.Mapper;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.common.date.jodatime.JodaTimeDateFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("searchByKeyword")
public class SearchNewsByCriteriaController extends BaseController {

    @Inject
    NewsInfoService newsInfoService;

    @Inject
    JodaTimeDateFactory dateFactory;

    @Inject
    Mapper beanMapper;

    @GetMapping
    public String searchByCriteria(
            @Validated SearchNewsForm searchNewsForm,
            BindingResult result, Model model,
            @PageableDefault(value = 5) Pageable pageable,
            HttpServletRequest request){
        if(result.hasErrors()){
            return "welcome/home";
        }

        NewsInfoSearchCriteria criteria = beanMapper.map(searchNewsForm, NewsInfoSearchCriteria.class);
        DateTime dateTime = dateFactory.newDateTime();
        switch(searchNewsForm.getPostDateRange()){
            case "0":
                criteria.setOldestPostDate(null);
                break;
            case "1":
                criteria.setOldestPostDate(dateTime.minusHours(1).toDate());
                break;
            case "2":
                criteria.setOldestPostDate(dateTime.minusHours(24).toDate());
                break;
            case "3":
                criteria.setOldestPostDate(dateTime.minusHours(24 * 7).toDate());
                break;
            case "4":
                criteria.setOldestPostDate(dateTime.minusHours(24 * 30).toDate());
                break;
            case "5":
                criteria.setOldestPostDate(dateTime.minusHours(24 * 365).toDate());
                break;
        }
        Page<News> allNews = newsInfoService.findByCriteria(criteria, pageable);
        model.addAttribute("allNews", allNews);
        model.addAttribute("criteria", criteria);
        String fullUrl = request.getRequestURL() +
                (request.getQueryString()!=null ? ("?"+request.getQueryString()) : "");
        model.addAttribute("fullUrl", fullUrl);
        return "welcome/home";
    }
}
