package modelo;

import java.util.Calendar;

public class Message {
	private String date;
	private String userName;
	private Integer idSender;
	private String message;
	
	
	public Message(String date, String user, Integer sender, String message) {
		this.date = date;
		this.idSender = sender;
		this.message = message;
		this.userName = user;
		
	}
	public Message() {
	}
	
	public void NewMessage(Integer sender, String senderName, String message) {
		this.date = setDate();
		this.idSender = sender;
		this.message = message;
		this.userName = senderName;
	}
	
	private String setDate() {
		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos, dia, mes, ano;	
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		dia =calendario.get(Calendar.DAY_OF_MONTH);
		mes = calendario.get(Calendar.MONTH);
		ano = calendario.get(Calendar.YEAR);
		return date= ano + "/" + mes + "/" + dia+" "+hora + ":" + minutos + ":" + segundos;
		
	}
	public String getDate() {
		return date;
	}
	public Integer getIdSender() {
		return idSender;
	}
	public String getMessage() {
		return message;
	}
	public String getUsername() {
		return userName;
	}

}
