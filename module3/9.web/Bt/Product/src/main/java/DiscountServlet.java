import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description= request.getParameter("description");
        String price= request.getParameter("price");
        String percent= request.getParameter("percent");

        Double amount=Double.parseDouble(price)* Double.parseDouble(percent)*0.01;

        request.setAttribute("description",description);
        request.setAttribute("price",price);
        request.setAttribute("amount",amount);
        request.setAttribute("discountPrice",Double.parseDouble(price)-amount);

        RequestDispatcher dispatcher=request.getRequestDispatcher("/display.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
