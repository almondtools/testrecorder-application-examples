package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TodoServlet", urlPatterns = { "" })
public class TodoServlet extends HttpServlet {

	private TodoList list;

	public TodoServlet() {
		list = new TodoList();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Action action = dispatchAction(req);

		StringBuilder response = new StringBuilder();

		action.execute(response);

		resp.getWriter().write(response.toString());
	}

	private Action dispatchAction(HttpServletRequest req) {
		String action = req.getParameter("action");
		if (action == null) {
			return new Init(list);
		} else if (action.equals("add")) {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			return new Add(list, id, name);
		} else if (action.equals("remove")) {
			String id = req.getParameter("id");
			return new Remove(list, id);
		} else {
			return new Show(list);
		}
	}

}