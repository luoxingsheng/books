package com.example.demo.Entity;


import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static org.apache.coyote.http11.Constants.a;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long authorId;
    private String authorName;
    private int authorAge;
    private String authorEmail;
    private String authorAddress;
    private String authorImg;
    private String authorBook;
    private String authorDescription;

    public Author() {
    }

    public Author(String authorName, int authorAge, String authorEmail, String authorAddress, String authorImg, String authorBook, String authorDescription) {
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.authorEmail = authorEmail;
        this.authorAddress = authorAddress;
        this.authorImg = authorImg;
        this.authorBook = authorBook;
        this.authorDescription = authorDescription;
    }


    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorAge=" + authorAge +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorAddress='" + authorAddress + '\'' +
                ", authorImg='" + authorImg + '\'' +
                ", authorBook='" + authorBook + '\'' +
                ", authorDescription='" + authorDescription + '\'' +
                '}';
    }
}
