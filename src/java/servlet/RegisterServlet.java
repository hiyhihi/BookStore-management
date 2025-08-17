/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;
import dao.AccountDAO;
import dao.CustomerDAO;
import model.Accounts;
import model.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *
 * @author huyph
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        AccountDAO accountDAO = new AccountDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        Accounts account = new Accounts(username, password, "customer");
        int accountId = accountDAO.register(account);

        if (accountId > 0) {
            account.setId(accountId);
            Customers customer = new Customers(fullName, phone, email, account);
            boolean success = customerDAO.addCustomer(customer);

            if (success) {
                request.setAttribute("message", "Register Successfully!");
            } else {
                request.setAttribute("errorMessage", "Fail saving customer information.");
            }
        } else {
            request.setAttribute("errorMessage", "Fail saving customer information.");
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
