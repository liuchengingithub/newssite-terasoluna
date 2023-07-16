package com.example.mynews.app.newsEdit;

import com.example.mynews.app.BaseController;
import com.example.mynews.domain.model.News;
import com.example.mynews.domain.service.NewsInfo.NewsInfoService;
import com.example.mynews.domain.service.editNews.EditNewsService;
import com.github.dozermapper.core.Mapper;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.terasoluna.gfw.common.date.jodatime.JodaTimeDateFactory;

import javax.inject.Inject;


@Controller
@RequestMapping("editNews")
public class NewsEditController extends BaseController {

    @Inject
    EditNewsService editNewsService;

    @Inject
    NewsInfoService newsInfoService;

    @Inject
    Mapper beanMapper;

    @Inject
    JodaTimeDateFactory dateFactory;

    @ModelAttribute
    public NewsEditForm setUpNewsEditForm(){
        NewsEditForm newsEditForm = new NewsEditForm();
        return newsEditForm;
    }

    @GetMapping("new")
    public String newNews(){
        return "newsEdit/addNews";
    }

    @PostMapping("new")
    public String newNews(
        @Validated NewsEditForm newsEditForm,
        BindingResult result){
        if(result.hasErrors()){
            return "newsEdit/addNews";
        }
        DateTime dateTime = dateFactory.newDateTime();
        newsEditForm.setNewsPostDate(dateTime);
        System.out.printf(dateTime.toString());
        News news = beanMapper.map(newsEditForm, News.class);
        editNewsService.insert(news);
        return "redirect:/";
    }

    @GetMapping("{newsId}")
    public String editNews(
            @PathVariable("newsId") String newsId,
            Model model){
       News news  = newsInfoService.findById(newsId);
       NewsEditForm newsEditForm = beanMapper.map(news, NewsEditForm.class);
       model.addAttribute("newsEditForm", newsEditForm);
       return "newsEdit/editNews";
    }

    @PostMapping("{newsId}")
    public String editNews(
            @Validated NewsEditForm newsEditForm,
            BindingResult result){
        if(result.hasErrors()){
            return "newsEdit/editNews";
        }
        News news = beanMapper.map(newsEditForm, News.class);
        editNewsService.update(news);
        return "redirect:/";
    }

    @GetMapping("delete/{newsId}")
    public String delete(@PathVariable("newsId") String newsId){
        editNewsService.delete(newsId);
        return "redirect:/";
    }
}


