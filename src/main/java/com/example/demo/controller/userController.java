package com.example.demo.controller;


import ch.qos.logback.core.util.FileUtil;
import com.example.demo.Entity.User;
import com.example.demo.Service.FileService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Controller
public class userController {
    @Autowired
    UserService userService;

    @Autowired
    FileService fileService;

    @RequestMapping("/user")
    public String user(ModelMap model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=userDetails.getUsername();
        User u=userService.findByUsername(username);
        String path="/img/userImg/"+u.getUserImg();
        System.out.println(path);
        model.addAttribute("img",path);
        model.addAttribute("name",u.getUserName());
        model.addAttribute("age",u.getUserAge());
        model.addAttribute("sex",u.getUserSex());
        model.addAttribute("email",u.getUserEmail());
        model.addAttribute("des",u.getUserDescription());
        return "user";
    }
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(){
        return "updateUserInfo";
    }

    @RequestMapping("/updateUserImg")
    public String updateUserImg(){
        return "updateUserImg";
    }


    //    更新用户头像
    @RequestMapping("/user/updateImg")
    public String updateUserImg(@RequestParam MultipartFile file,HttpServletRequest request)throws FileNotFoundException,IOException{
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=userDetails.getUsername();
        System.out.println(username);
        User u=userService.findByUsername(username);
        System.out.println(u);
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("文件名"+fileName);
        String filePath = request.getSession().getServletContext().getRealPath("/static/img/userImg/"+fileName);
        System.out.println("实际路径"+filePath);
        try {
            file.transferTo(new File(filePath));
//            fileService.fileupload(file.getBytes(),filePath,fileName);
            System.out.println("为什么");
            userService.updateUserImg(username,fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "user";
}



//    更新用户信息
    @RequestMapping("/user/updateInfo")
    public String updateUserinfo(
//            @RequestParam String username,
            @RequestParam String name,
            @RequestParam String sex,
            @RequestParam int age,
            @RequestParam String email,
            @RequestParam String description){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=userDetails.getUsername();
        System.out.println("登录信息"+userDetails);
        System.out.println("fdfd"+username);
        User u=userService.findByUsername(username);
        System.out.println(u);
        u.setUserName(name);
        u.setUserSex(sex);
        u.setUserAge(age);
        u.setUserEmail(email);
        u.setUserDescription(description);
        userService.updateUserInfo(u);
        return "user";
    }

//    修改密码
    @RequestMapping("/matchpassword")
    public String updatepassword(@RequestParam String username,@RequestParam String password){
        if(userService.findByUserUsernameAndUserPassword(username,password)!=null){
            return "updatepassword";
        }else
            return "matchpassword";
    }
}
