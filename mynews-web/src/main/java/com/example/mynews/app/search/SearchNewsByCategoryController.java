package com.example.mynews.app.search;

import com.example.mynews.app.BaseController;
import com.example.mynews.domain.model.News;
import com.example.mynews.domain.service.NewsInfo.NewsInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("category")
public class SearchNewsByCategoryController extends BaseController {
    @Inject
    NewsInfoService newsInfoService;

    @GetMapping("{category}")
    public String searchByCategory(
            @PathVariable String category,
            @PageableDefault(value = 5) Pageable pageable,
            Model model, HttpServletRequest request){
        Page<News> allNews = newsInfoService.findByCategory(category, pageable);
        model.addAttribute("allNews", allNews);
        String fullUrl = request.getRequestURL() +
                (request.getQueryString()!=null ? ("?"+request.getQueryString()) : "");
        model.addAttribute("fullUrl", fullUrl);
        return "welcome/home";
    }
}
