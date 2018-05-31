//package com.example.demo.config;
//
//import com.example.demo.Entity.User;
//import com.example.demo.Service.UserRoleService;
//import com.example.demo.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class MyAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private UserService us;
//
//    @Autowired
//    UserRoleService urs;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username=authentication.getName();
//        System.out.println("我的用户名"+username);
//        String password= (String) authentication.getCredentials();
//        System.out.println("我的密码"+password);
//        User user=us.findByUsername(username);
//        if(password.equals(user.getUserPassword())){
//        String roles=urs.findUserRoleByUser(user);
//        List<GrantedAuthority> list=null;
//        for (String role:roles.split(",")) {
//            System.out.println("我的权限"+role);
//            list.add(new SimpleGrantedAuthority("ROLE_" + role));
//        }
//            Collection<? extends GrantedAuthority> authorities = list;
//            return UsernamePasswordAuthenticationToken(username,password,authorities);
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//}
