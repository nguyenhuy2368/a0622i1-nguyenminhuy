package controller;


import model.Product;
import repository.IProductDAO;
import repository.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",  urlPatterns = "/testModule3")
public class ProductServlet extends HttpServlet {
    private IProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormCreate(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search" :
                searchByName(request,response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productDAO.findAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product handler = productDAO.findById(id);
        request.setAttribute("product", handler);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteById(productId);
        List<Product> list = productDAO.findAll();
        request.setAttribute("products", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/createProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                creatProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;

            default:
                showListProduct(request, response);
        }
    }
    private void updateProduct(HttpServletRequest request,HttpServletResponse response){
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int productQuantity =Integer.parseInt(request.getParameter("productQuantity"));
        String productColor = request.getParameter("productColor");
        String productDescription = request.getParameter("productDescription");
        int productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product handler = new Product(productId,productName,productPrice,productQuantity,productColor,productDescription,productCategoryId);
        productDAO.updateById(productId,handler);
        showListProduct(request,response);
    }
    private void creatProduct(HttpServletRequest request,HttpServletResponse response){
        String productName = request.getParameter("productName");
        float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        int productQuantity =Integer.parseInt(request.getParameter("productQuantity"));
        String productColor = request.getParameter("productColor");
        String productDescription = request.getParameter("productDescription");
        int productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));
        Product handler = new Product(productName,productPrice,productQuantity,productColor,productDescription,productCategoryId);
        productDAO.add(handler);
        showListProduct(request,response);
    }
    private void searchByName(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("searchName");
        List <Product> list = productDAO.findByName(name);
        request.setAttribute("products",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
