/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;
import dao.BookDAO;
import model.Books;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author huyph
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "view":
                viewBook(request, response);
                break;
            case "search":
                searchBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            default: 
                listBooks(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "insert":
                insertBook(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
//            case "delete":
//                deleteBook(request, response);
//                break;
            default:
                response.sendRedirect("BookServlet?action=list");
                break;
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Books> list = bookDAO.getAllBook();
        request.setAttribute("listBooks", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Book/book_list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Book/book_form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Books book = null;
        for (Books b : bookDAO.getAllBook()) {
            if (b.getId() == id) {
                book = b;
                break;
            }
        }
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Book/book_form.jsp");
        dispatcher.forward(request, response);
    }

    private void viewBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Books book = null;
        for (Books b : bookDAO.getAllBook()) {
            if (b.getId() == id) {
                book = b;
                break;
            }
        }
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Book/book_view.jsp");
        dispatcher.forward(request, response);
    }

    private void searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        ArrayList<Books> result = bookDAO.searchBook(keyword);
        request.setAttribute("listBooks", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Book/book_list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stockQuantity"));

        Books book = new Books(title, author, publisher, price, stock);
        bookDAO.createBook(book);
        response.sendRedirect("BookServlet?action=list");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stockQuantity"));

        Books book = new Books(id, title, author, publisher, price, stock);
        bookDAO.updateBook(book);
        response.sendRedirect("BookServlet?action=list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Books book = new Books();
        book.setId(id);
        bookDAO.deleteBook(book);
        response.sendRedirect("BookServlet?action=list");
    }
}