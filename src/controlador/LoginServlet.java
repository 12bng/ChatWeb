package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesoADatos.LogedUserList;
import accesoADatos.MessageList;
import accesoADatos.PeticionesDB;
import modelo.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
		PeticionesDB peticiones = new PeticionesDB();
		User user = peticiones.login(name, password);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			LogedUserList.getLogedUserList().addUser(user);
			MessageList.getMessageList().loadMessageList();
			request.getRequestDispatcher("/chatGeneral").forward(request, response);
		} else {
			request.setAttribute("login", user);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

}
