package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Collection;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	public User findByUserUsernameAndUserPassword(String username, String password);

	public User findByUserId(int id);

	public User findByUserUsername(String username);


	@Query(value = "update User u set u.userImg=?2 where u.userUsername=?1")
	@Modifying(clearAutomatically =true)
	public int updateUserImg(String username,String userImg);

	@Transactional
	@Query(value = "update User u set u.userName=?2,u.userSex=?3,u.userAge=?4,u.userEmail=?5,u.userDescription=?6 where u.userUsername=?1")
	@Modifying(clearAutomatically =true)
	public int updateUserInfo(String userUsername,String userName,String userSex,int userAge,String userEmail,String userDescription);

	@Query("UPDATE User u Set u.active=?1 WHERE u.userId=?2")
	@Modifying(clearAutomatically=true)
	public int updateUserActive(boolean active,int id);


}
