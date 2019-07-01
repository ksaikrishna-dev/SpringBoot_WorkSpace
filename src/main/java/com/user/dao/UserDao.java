/**
 * 
 */
package com.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserEntity;

/**
 * @author Sai Krishna K
 *
 */

public interface UserDao extends JpaRepository<UserEntity, Long>{

	
}
