package userproject;

import java.util.ArrayList;
import java.util.List;

public class userService implements UserServiceInterface{

	List<User> users=new ArrayList<User>();
	
	@Override
	public void insertUSer() {
	
	for(int i=0;i<5;i++) {
			users.add(new User(i,"User "+i,"Age "+i));
		
	}
	
	}
	
	
	@Override
	public List<User> getUsers() {
		
		return users;
		
		
		
	}


	@Override
	public void printUsers() {
		System.err.println("ODayyameen");
		if(users.size()<=0)
			System.out.println("Call insertUser");
		else users.forEach(System.out::println);
		
	}
	
	
}
