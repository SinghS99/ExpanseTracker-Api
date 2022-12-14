package in.sandeep.expanseApi.Services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.sandeep.expanseApi.Entities.User;
import in.sandeep.expanseApi.Entities.UserModel;
import in.sandeep.expanseApi.Exceptions.ItemAlreadyExistsException;
import in.sandeep.expanseApi.Exceptions.ResourceNotFoundException;
import in.sandeep.expanseApi.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User is already registered with email :"+user.getEmail());
		}
		User newUser=new User();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
		return userRepository.save(newUser);
	}

	@Override
	public User read(Long id) throws ResourceNotFoundException {
		
		return userRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User not found with :" +id));
	}

	@Override
	public User update(UserModel user, Long id) {
		User oUser=read(id);
		oUser.setName(user.getName() !=null ? user.getName() : oUser.getName());
		oUser.setEmail(user.getEmail() !=null ? user.getEmail() : oUser.getEmail());
		oUser.setPassword(user.getPassword() !=null ? bcryptEncoder.encode(user.getPassword()) : oUser.getPassword());
		oUser.setAge(user.getAge() !=null ? user.getAge() : oUser.getAge());
		return userRepository.save(oUser);
	}

	@Override
	public void delete(Long id) {
		User user=read(id);
		userRepository.delete(user);
	}

}
