package com.example.demo.Service;

import com.example.demo.Entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.rowset.Predicate;
import javax.transaction.Transactional;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;

@Service
@Transactional
public class AuthorService implements AuthorPage {

    @Resource
    AuthorRepository authorRepository;

    public Author findByAuthorId(int authorId){
        return authorRepository.findByAuthorId(authorId);
    }

    public Page<Author> findAllPage(Pageable pageable){
        return authorRepository.findAll(pageable);
    }

    @Override
    public Page<Author> findAuthorNoCriteria(Integer page, Integer size) {
        Pageable pageable=new PageRequest(page,size, Sort.Direction.ASC,"authorId");
        return authorRepository.findAll(pageable);
    }
}
