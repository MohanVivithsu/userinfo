package com.project.userinfo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.userinfo.domain.AddressDomain;

public interface AddressRepository  extends JpaRepository<AddressDomain, String>{

}
