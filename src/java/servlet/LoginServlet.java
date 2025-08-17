/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;
import dao.AccountDAO;
import model.Accounts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author huyph
 */
@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Accounts acc = new Accounts();
        acc.setUsername(username);
        acc.setPassword(password);

        AccountDAO dao = new AccountDAO();
        boolean ok = dao.checkLogin(acc);

        if (ok) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/View/home.jsp");
        } else {
            request.setAttribute("errorMessage", "Wrong username or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
