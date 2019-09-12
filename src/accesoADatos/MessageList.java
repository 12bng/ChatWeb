package accesoADatos;

import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Message;

public class MessageList {
	private static MessageList myMessageList = null;
	private static ArrayList<Message> messageList = null;
	
	private MessageList() {
		
	}
	
	public static MessageList getMessageList() {
		if(myMessageList==null) {
			myMessageList = new MessageList();
			messageList= new ArrayList<Message>();
		}
		return myMessageList;
	}
	public void addMessage(Message message) {
		PeticionesDB.addPublicMessage(message);
		messageList.add(message);
	}
	
	public Message getLastMessage() {
		return messageList.get(messageList.size());
	}
	
	public void loadMessageList() {
		ResultSet rs=PeticionesDB.getPublicMessages();
		messageList = new ArrayList<Message>();
		try {
			while(rs.next()) {
				messageList.add(new Message(rs.getString("fecha"),rs.getString("usuario"), rs.getInt("idUsuario"), rs.getString("mensaje")));
			}
		}
		catch(Exception e) {
			
		}
	}
	public static ArrayList<Message> getList(){
		return messageList;
	}
}
