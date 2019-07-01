/**
 * 
 */
package com.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.entity.UserEntity;

/**
 * @author Sai Krishna K
 *
 */
@Repository
@Transactional
public interface UserCustomDao extends JpaRepository<UserEntity, Long>{
	
	@Query(value = "select usr FROM UserEntity usr WHERE usr.id = ?1")
	public UserEntity getCustomUser(@Param("id") long id);
	
}
