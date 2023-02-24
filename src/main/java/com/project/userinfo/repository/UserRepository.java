package com.project.userinfo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.userinfo.domain.UserDomain;

public interface UserRepository extends JpaRepository<UserDomain, String> {
	
	public UserDomain findByUserIdAndStatus(String userId,boolean  status);
	
	public List<UserDomain> findByStatus(boolean status);

	public UserDomain findByUserId(String userId);

}
