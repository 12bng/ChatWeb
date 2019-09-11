package accesoADatos;

import java.util.ArrayList;

import modelo.Message;
import modelo.User;

public class PrivateChat {
	User user1, user2;
	ArrayList<Message> menssages;
	
	public PrivateChat() {
		menssages = new ArrayList<Message>();
		
	}
	
	public boolean isSameChat(User user1, User user2) {
		if((user1.getId()==this.user1.getId()||user2.getId()==this.user1.getId())&&(user1.getId()==this.user2.getId()||user2.getId()==this.user2.getId())) {
			return true;
		}
		return false;
	}
}
