//package com.example.demo.config;
//
//
//import com.example.demo.Entity.User;
//import com.example.demo.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service("MyUserDetailsImpl")
//public class MyUserDetailsService implements UserDetailsService{
//
//    @Autowired
//    UserService us;
//
////    @Autowired
////    UserRoleService urs;
//
//    @Override
//    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user;
//        try{
//            user=us.findByUsername(username);
//            System.out.println("我的用户"+user);
//        }catch (Exception e){
//            throw new UsernameNotFoundException("Find user failed!");
//        }
//        if(user==null){
//            System.out.println(user);
//            throw new UsernameNotFoundException("No user find!");
//        }else{
//            try {
//                System.out.println("wuyule");
//                //为用户赋予权限
//                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//                for (Role role:user.getRoles()) {
//                    authorities.add(new SimpleGrantedAuthority(role.getName()));
//                }
//                System.out.println("你好,授权成功              ");
//                return new org.springframework.security.core.userdetails.User(user.getUserUsername(),user.getUserPassword(),authorities);
//            }catch (Exception  e){
//                throw new UsernameNotFoundException("UserRole find failed!");
//            }
//        }
//    }
//}
