package com.example.mynews.app.home;

import com.example.mynews.app.BaseController;
import com.example.mynews.domain.model.News;
import com.example.mynews.domain.service.NewsInfo.NewsInfoService;
import org.joda.time.DateTimeZone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class HomeController extends BaseController {
    @Inject
    NewsInfoService newsInfoService;

    @GetMapping
    public String getHomepage(Model model, @PageableDefault(value = 5) Pageable pageable, HttpServletRequest request) {
        Page<News> allNews = newsInfoService.findAllNews(pageable);
//        for(News news: allNews){
//            news.setNewsPostDate(news.getNewsPostDate().withZone(DateTimeZone.forID("Asia/Shanghai")));
//        }
        model.addAttribute("allNews", allNews);
        String fullUrl = request.getRequestURL() +
                (request.getQueryString()!=null ? ("?"+request.getQueryString()) : "");
        model.addAttribute("fullUrl", fullUrl);
        return "welcome/home";
    }
}
