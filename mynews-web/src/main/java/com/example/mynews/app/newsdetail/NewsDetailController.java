package com.example.mynews.app.newsdetail;

import com.example.mynews.app.BaseController;
import com.example.mynews.domain.model.News;
import com.example.mynews.domain.service.NewsInfo.NewsInfoService;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("newsDetail/{id}")
public class NewsDetailController extends BaseController {
    @Inject
    NewsInfoService newsInfoService;

    @GetMapping
    public String getNewsDetail(@PathVariable("id") String id, Model model){
        News news = newsInfoService.findById(id);
//        news.setNewsPostDate(news.getNewsPostDate().withZone(DateTimeZone.forID("Asia/Tokyo")));
        model.addAttribute(news);
        return "newsdetail/newsDetail";
    }
}
