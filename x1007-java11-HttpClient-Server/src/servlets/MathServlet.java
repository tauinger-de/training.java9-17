package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/*")
public class MathServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MathServlet.doGet()");
		try {
			int x = Integer.parseInt(request.getParameter("x"));
			int y = Integer.parseInt(request.getParameter("y"));
			int sum = x + y;
			response.getWriter().write(String.valueOf(sum));
			Thread.sleep(2000);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MathServlet.doPost()");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			int x = Integer.parseInt(reader.readLine());
			int y = Integer.parseInt(reader.readLine());
			int sum = x + y;
			response.getWriter().write(String.valueOf(sum));
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
