package com.Multiplex.Dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.Users;
@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {

	//public Optional<Users> findByEmailId(String email);
	public Users findByUserName(String username);

	public Users findByUserEmail(String userEmail);

}