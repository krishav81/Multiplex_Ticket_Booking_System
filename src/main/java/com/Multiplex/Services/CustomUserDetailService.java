package com.Multiplex.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Multiplex.Dao.UsersDao;
import com.Multiplex.Model.CustomUserDetail;
import com.Multiplex.Model.Users;
@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UsersDao usersDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=this.usersDao.findByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("NO USER");
		}
		
		return new CustomUserDetail(user);
	}

}
