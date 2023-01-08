package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns =  {"", "/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "search":
                searchProductByName(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }
    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        if (name.equals("")) {
            listProduct(request, response);
        } else {
            List<Product> list = productService.getListProductByName(name);
            if (list.size() != 0) {
                request.setAttribute("listProductFindByName", list);
            } else {
                request.setAttribute("searchName", "not found");
            }
            request.setAttribute("findName", name);
            try {
                request.getRequestDispatcher("product/list.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double count = Double.parseDouble(request.getParameter("count"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String described = request.getParameter("described");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Category category = categoryService.getCategoryById(idCategory);
        Product product = new Product(id, name, count, amount, color, described, category);
        productService.update(id, product);
        listProduct(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id;
        while (true) {
            id = (int) (Math.random() * 1000);
            if (productService.getProductById(id).getName() == null) {
                break;
            }
        }
        String name = request.getParameter("name");
        double count = Double.parseDouble(request.getParameter("count"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String described = request.getParameter("described");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Category category = categoryService.getCategoryById(idCategory);
        Product product = new Product(id, name, count, amount, color, described, category);
        productService.save(product);
        listProduct(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProductForm(request, response);
                break;
            case "edit":
                showEditProductForm(request, response);
                break;
            case "delete":
                removeProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }
    private void removeProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        listProduct(request, response);
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("product/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = productService.selectAllProduct();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
