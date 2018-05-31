package com.example.demo.Service;

import com.example.demo.Entity.Author;
import org.springframework.data.domain.Page;

public interface AuthorPage {
    public Page<Author> findAuthorNoCriteria(Integer page, Integer size);
}
