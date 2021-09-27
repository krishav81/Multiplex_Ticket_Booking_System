package com.Multiplex.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Multiplex.Dao.ConfirmationTokenDao;
import com.Multiplex.Dao.UsersDao;
import com.Multiplex.Model.ConfirmationToken;
import com.Multiplex.Model.Users;
@RestController
public class HomeController {
	 @Autowired
	 private UsersDao usersDao;
	@Autowired
	private ConfirmationTokenDao confirmationTokenDao;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@GetMapping("/api/home")
	public String home() {
		return "Welcome to Home Page";
	}
	 @GetMapping("/api/confirm/{confirmationToken}")
	    public String confirmUserAccount(@PathVariable String confirmationToken)
	    {
	       return "Account Activated Successfully";
	    }
}
