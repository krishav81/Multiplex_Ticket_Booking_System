package com.Multiplex.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Multiplex.Dao.ConfirmationTokenDao;
import com.Multiplex.Dao.UsersDao;
import com.Multiplex.Exception.ExceptionMultiplex;
import com.Multiplex.Model.ConfirmationToken;
import com.Multiplex.Model.Users;
import com.Multiplex.Services.EmailServiceImpl;
import com.Multiplex.Services.UsersService;


@RestController
@RequestMapping("/api/")
public class UserController {
	 @Autowired
	 private UsersDao usersDao;
	@Autowired
	private UsersService userService;
	@Autowired
	private ConfirmationTokenDao confirmationTokenDao;
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@PostMapping("/users/signup")
	public String userRegistration(@RequestBody Users user)
	{
		user.setUserRole("ROLE_ADMIN");
		user.setEnabled(true);
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		usersDao.save(user);
	usersDao.save(user);
	ConfirmationToken confirmationToken =new ConfirmationToken(user);
	confirmationTokenDao.save(confirmationToken);
	SimpleMailMessage mailMessage=new SimpleMailMessage();
	mailMessage.setTo(user.getUserEmail());
	mailMessage.setSubject("Complete Registration [TMS]");
	mailMessage.setFrom("rishav79031@gmail.com");
	mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8080/api/confirm/"+confirmationToken.getConfirmationToken());
	emailServiceImpl.sendEmail(mailMessage);
	return "Please Confirm Your Mail "+user.getUserEmail()+" For Completing your Registration." ;
	}
	@GetMapping("/admin/users")
	public List<Users> getAllUsers()
	{
		return this.userService.getAllUsers();
	}
	@GetMapping("/admin/users/{userId}")
	public Optional<Users> getUser(@PathVariable String userId)
	{
		return this.userService.getUser(Long.parseLong(userId));
	}
}
