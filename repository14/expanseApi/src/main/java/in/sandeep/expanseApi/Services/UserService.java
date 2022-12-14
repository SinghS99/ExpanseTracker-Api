package in.sandeep.expanseApi.Services;

import in.sandeep.expanseApi.Entities.User;
import in.sandeep.expanseApi.Entities.UserModel;


public interface UserService {
	
	User createUser(UserModel user);
	User read(Long id);
	User update(UserModel user,Long id);
	void delete(Long id);

}
