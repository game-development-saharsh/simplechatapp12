package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.Server;


/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Server server = null;
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub

		// create a server object and start it
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(server == null) {
			InetAddress inetAddress = InetAddress.getLocalHost();
			PrintWriter out = response.getWriter().append("IP Address:- " + inetAddress.getHostAddress()+" & Host Name:- " + inetAddress.getHostName());
			out.flush();
	        int portNumber = 7090;
	        System.out.println("server started");
//			server = new Server(portNumber);
//			server.start();
		}
//		String path = request.getServletPath();
//		if (path.equals("/")){
//			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//		}
//		
//		else {
//			response.getWriter().append("Served at: ").append(path);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
