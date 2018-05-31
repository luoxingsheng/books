package com.example.demo.Service;


import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Resource
    UserRepository userRepository;


    public User findByUserUsernameAndUserPassword(String username, String password){
        return userRepository.findByUserUsernameAndUserPassword(username,password);
    }

    public User findByUserId(int id){
        return userRepository.findByUserId(id);
    }

    public User findByUsername(String username){return userRepository.findByUserUsername(username);}

    public boolean saveUser(User user){
        return  userRepository.save(user)!=null;
    }

    public int updateUserImg(String  username,String userImg){
        return userRepository.updateUserImg(username,userImg);
    }

    public int updateUserInfo(User u){
        return userRepository.updateUserInfo(u.getUserUsername(),u.getUserName(),u.getUserSex(),u.getUserAge(),u.getUserEmail(),u.getUserDescription());
    }
    public int updateUserActive(boolean active,int id){
        return userRepository.updateUserActive(active, id);
    }


}
