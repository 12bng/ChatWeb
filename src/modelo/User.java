package modelo;

public class User {
	private Integer id;
	private String name;
	private String password;
	
	public User(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	public boolean setNewPassword(String password, String newPassword) {
		if(this.password==password) {
			this.password=newPassword;
			return true;
		}
		return false;
	}
	
	
}
