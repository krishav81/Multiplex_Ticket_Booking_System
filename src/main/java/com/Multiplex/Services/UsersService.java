package com.Multiplex.Services;
import com.Multiplex.Exception.ExceptionMultiplex;
import com.Multiplex.Model.Users;
import java.util.List;
import java.util.Optional;

public interface UsersService {
	public String userRegistration(Users user);
	public List<Users> getAllUsers();
	public Optional<Users> getUser(long userId);
}
