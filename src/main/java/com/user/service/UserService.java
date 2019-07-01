/**
 * 
 */
package com.user.service;

import java.util.List;

import com.user.entity.UserEntity;

/**
 * @author Sai Krishna K
 *
 */
public interface UserService {

	public void saveUser(UserEntity userEntity);
	public UserEntity getUserById(long id);
	public List<UserEntity> getAllUsers();
	public UserEntity updateUser(UserEntity userEntity);
	public void deleteUser(long id);
	
	
	public UserEntity getCustomUser(long id);
}
