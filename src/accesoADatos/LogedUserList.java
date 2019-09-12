package accesoADatos;

import java.util.TreeMap;

import modelo.User;

public class LogedUserList {
	private static TreeMap<Integer, User> logedUsers = null;
	private static LogedUserList myLogedUserList = null;
	
	public static LogedUserList getLogedUserList(){
		if(myLogedUserList==null) {
			myLogedUserList = new LogedUserList();
		}
		return myLogedUserList;
	}
	private LogedUserList() {
		if(logedUsers==null) {
			logedUsers = new TreeMap<Integer,User>();
			//para pruebas
			addUser(new User(0,"Bot","Bot"));
		}
		
	}
	public void addUser(User user) {
		System.out.println(user.getName());
		logedUsers.put(user.getId(), user);
	}
	public Iterable<User> getLogedUsers(){
		return logedUsers.values();
	}
	public void deleteUser(Integer id) {
		logedUsers.remove(id);
	}

}
