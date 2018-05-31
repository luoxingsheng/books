package com.example.demo.controller;


import com.example.demo.Entity.Author;
import com.example.demo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class authorController {

    @Autowired
    AuthorService as;

    @RequestMapping("/authorlist")
    public String authorlist(ModelMap model,
                             @RequestParam(value = "page", defaultValue = "1") int page){
        System.out.println(page);
        int size=10;
        Page<Author> datas=as.findAuthorNoCriteria(page-1,size);
        System.out.println(datas.getTotalElements());
        int totalElements=(int)datas.getTotalElements();
        model.addAttribute("datas",datas);
        Integer []pages=new Integer[3];
        pages[0]=totalElements;
        pages[1]=page;
        pages[2]=size;
        model.addAttribute("pages",pages);
        return "HotAuthor";
    }

}
