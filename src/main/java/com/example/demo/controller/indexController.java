package com.example.demo.controller;



        import javax.servlet.http.HttpServletRequest;

        import com.example.demo.Service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.RequestMapping;

        import com.example.demo.Entity.User;
        import com.example.demo.Service.UserRepository;
        import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController  {

    @Autowired
    User user;

    @Autowired
    UserService userService;

    @RequestMapping(value="/")
    public String hehe(){
        return "index";
    }

    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/register")
    public String error(){
        return "register";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/addRegister")
    public String register(@RequestParam String type,@RequestParam String username,@RequestParam String password1,@RequestParam String password2,Model model) {
        if(password2.equals(password1)) {
//            user.setUserType(type);
            user.setUserUsername(username);
            user.setUserPassword(password1);
            System.out.println(user);
            userService.saveUser(user);
            System.out.println("注册成功");
            return "login";
        }else
        {
            System.out.println("注册失败");
            return "register";
        }
    }
//
//    @RequestMapping(value="/loginIn")
//    public String login(@RequestParam String username,@RequestParam String password,ModelMap model) {
//        if(userService.findByUserUsernameAndUserPassword(username, password)!=null) {
//            model.addAttribute("name",username);
//            return "index";
//        }
//        else{
//            return "login";
//        }
//    }
}