/**
 * 
 */
package com.user.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserCustomDao;
import com.user.dao.UserDao;
import com.user.entity.UserEntity;
import com.user.service.UserService;

/**
 * @author Sai Krishna K
 *
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserCustomDao userCustomDao;
	
	@Override
	public void saveUser(UserEntity userEntity) {
		userDao.save(userEntity);
	}

	@Override
	public UserEntity getUserById(long id) {
		return userDao.findOne(id);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		return userDao.save(userEntity);
	}

	@Override
	public void deleteUser(long id) {
		UserEntity user = getUserById(id);
		if(user != null) {
			userDao.delete(user);
		}
		
	}
	
	

	@Override
	public UserEntity getCustomUser(long id) {
		return userCustomDao.getCustomUser(id);
	}

}
