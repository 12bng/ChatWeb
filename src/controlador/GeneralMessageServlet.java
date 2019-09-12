package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import accesoADatos.MessageList;
import modelo.Message;
import modelo.User;

@WebServlet("/chatGeneral")
public class GeneralMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/vistas/chatGeneral.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String message = request.getParameter("message");
		Message completeMessage = new Message();
		User user = (User) request.getSession().getAttribute("user");
		if(message!=null) {
		completeMessage.NewMessage(user.getId(), user.getName(), message);
		MessageList.getMessageList().addMessage(completeMessage);
		System.out.println("Mensaje enviado");
		}
		request.getRequestDispatcher("/WEB-INF/vistas/chatGeneral.jsp").forward(request, response);
		
	}

}
