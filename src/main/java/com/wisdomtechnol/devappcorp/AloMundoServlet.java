package com.wisdomtechnol.devappcorp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AloMundoServlet", value = "/AloMundoServlet")
public class AloMundoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        String msg = "";
        String nome = request.getParameter("nome");
        Object sessionName = session.getAttribute("nome");

        if (nome != null) {
            msg = String.format("Alô, %s!", nome);
            session.setAttribute("nome", nome);
        } else {
            if (sessionName != null) {
                msg = String.format("Alô, %s!", sessionName);
            } else msg = "Alô, mundo!";
        }
        session.setAttribute("msg", msg);
        dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alô Mundo Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<P>"+msg+"</P>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}