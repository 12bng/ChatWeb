package accesoADatos;

import java.util.TreeMap;

import modelo.User;

public class LogedUserList {
	TreeMap<Integer, User> logedUsers;
	private static LogedUserList myLogedUserList = null;
	
	public LogedUserList getLogedUserList(){
		if(myLogedUserList==null) {
			myLogedUserList = new LogedUserList();
		}
		return myLogedUserList;
	}
	private LogedUserList() {
		logedUsers = new TreeMap<Integer,User>();
	}
	public void addUser(User user) {
		logedUsers.put(user.getId(), user);
	}
	public Iterable<User> getLogedUsers(){
		return logedUsers.values();
	}
	public void deleteUser(Integer id) {
		logedUsers.remove(id);
	}

}
