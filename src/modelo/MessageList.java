package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import accesoADatos.PeticionesDB;

public class MessageList {
	private MessageList myMessageList = null;
	private ArrayList<Message> messageList = null;
	
	public ArrayList<Message> getMessageList() {
		if(myMessageList==null) {
			myMessageList = new MessageList();
			messageList= new ArrayList<Message>();
		}
		return messageList;
	}
	public void addMessage(User user, String message) {
		//TODO
	}
	public Message getLastMessage() {
		return messageList.get(messageList.size());
	}
	public void loadMessageList() {
		ResultSet rs=PeticionesDB.getPublicMessages();
		try {
			while(rs.next()) {
				messageList.add(new Message(rs.getString("fecha"), rs.getString("usuario"), rs.getString("mensaje")));
			}
		}
		catch(Exception e) {
			
		}
	}
}
