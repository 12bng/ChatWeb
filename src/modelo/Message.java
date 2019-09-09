package modelo;

import java.util.Calendar;

public class Message {
	private String date;
	private String sender;
	private String message;
	
	
	public Message(String date, String sender, String message) {
		this.date = date;
		this.sender = sender;
		this.message = message;
	}
	
	public void NewMessage(String sender, String message) {
		this.date = setDate();
		this.sender = sender;
		this.message = message;
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
		return date= dia + "/" + mes + "/" + ano+" - "+hora + ":" + minutos + ":" + segundos;
		
	}

}
