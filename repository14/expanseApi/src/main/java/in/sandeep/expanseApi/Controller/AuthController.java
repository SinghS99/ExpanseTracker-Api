package in.sandeep.expanseApi.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sandeep.expanseApi.Entities.User;
import in.sandeep.expanseApi.Entities.UserModel;
import in.sandeep.expanseApi.Services.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> login(){
		return new ResponseEntity<String>("User is logged in",HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<User>save(@Valid  @RequestBody UserModel user){
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
		
	}
}
