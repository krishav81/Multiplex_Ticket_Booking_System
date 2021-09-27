package com.Multiplex.Services;
import com.Multiplex.Services.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Dao.UsersDao;
import com.Multiplex.Exception.ExceptionMultiplex;
import com.Multiplex.Model.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserServiceImpl implements UsersService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UsersDao usersDao;
	@Override
	public String userRegistration(Users user){
		
		/*
		if(user==null)
		{
			throw new ExceptionMultiplex("No Parameters Passed");
		}
		else
		{
			Optional<Users> user1=usersDao.findByEmailId(user.getUserEmail());
			if(user1.equals(null) && user1.getUserEmail().equals(user.getUserEmail()))
			{
				throw new ExceptionMultiplex("Email Id Already Exists");
			}
			else
			{
				usersDao.save(user);
				return "User with "+user.getUserEmail()+" Registered Successfully";
			}
		}
	}*/
		return null;
}
	@Override
	public List<Users> getAllUsers() {
		return usersDao.findAll();
	}
	@Override
	public Optional<Users> getUser(long userId) {
		Optional<Users> user=usersDao.findById((int)userId);
		return user;
	}
}
