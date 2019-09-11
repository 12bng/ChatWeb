package accesoADatos;

import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Message;
import modelo.User;

public class MessageList {
	private MessageList myMessageList = null;
	private ArrayList<Message> messageList = null;
	
	private MessageList() {
		
	}
	
	public MessageList getMessageList() {
		if(myMessageList==null) {
			myMessageList = new MessageList();
			messageList= new ArrayList<Message>();
		}
		return myMessageList;
	}
	public void addMessage(Message message) {
		messageList.add(message);
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
