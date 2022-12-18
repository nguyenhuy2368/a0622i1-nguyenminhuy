package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = {"/sum","/tinh-tong"})
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int n1= Integer.parseInt(request.getParameter("num1"));
//        int n2= Integer.parseInt(request.getParameter("num2"));
//        int sum = n1+n2;
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<h1>Do post chay</h1>");
//        printWriter.print("<h1>Ket qua tong là :"+sum+"</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n1= Integer.parseInt(request.getParameter("num1"));
        int n2= Integer.parseInt(request.getParameter("num2"));
        int sum = n1+n2;
        // cách củ chuối không dùng nừa
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<h1>Do get chay</h1>");
//        printWriter.print("<h1>Ket qua tong la :"+sum+"</h1>");
        // Cách 2 chuyển về trang jsp để điện thị
        request.setAttribute("n1",n1);
        request.setAttribute("n2",n2);
        request.setAttribute("tong",sum);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request,response);
    }
}
