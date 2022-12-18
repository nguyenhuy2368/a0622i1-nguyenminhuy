package servlet;

import models.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    public static List<Customer> customerList =new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer.jsp");
        request.setAttribute("customerList",customerList);
        dispatcher.forward(request,response);

    }

    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("A","11-11-2022","Đà Nẵng"));
        customerList.add(new Customer("B","11-11-2022","Đà Nẵng"));
        customerList.add(new Customer("C","11-11-2022","Đà Nẵng"));
        customerList.add(new Customer("D","11-11-2022","Đà Nẵng"));
    }
}
