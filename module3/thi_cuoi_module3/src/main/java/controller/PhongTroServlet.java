package controller;

import model.PhongTro;
import repository.IPhongTroRepository;
import service.IPhongTroService;
import service.PhongTroService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongTroServlet",urlPatterns = "/testModule3")
public class PhongTroServlet extends HttpServlet {
    private IPhongTroService phongTroService = new PhongTroService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                creatPhong(request, response);
                break;
            default:
                showListPhong(request, response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showTaoPhong(request, response);
                break;
            case "delete":
                deletePhong(request, response);
                break;
            case "search" :
                searchByName(request,response);
                break;
            default:
                showListPhong(request, response);
        }
    }


    private void showListPhong(HttpServletRequest request, HttpServletResponse response) {
        List<PhongTro> phongTros = phongTroService.findAll();
        request.setAttribute("phongTros", phongTros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phongTro/listPhongTro.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void creatPhong(HttpServletRequest request, HttpServletResponse response) {
        String tenNguoiThue = request.getParameter("tenNguoiThue");
        String sdt = request.getParameter("sdt");
        String ngayBatDau = request.getParameter("ngayBatDau");
        int idThanhToan = Integer.parseInt(request.getParameter("idThanhToan"));
        String ghiChu = request.getParameter("ghiChu");
        PhongTro tro = new  PhongTro(tenNguoiThue,sdt,ngayBatDau,idThanhToan,ghiChu);
        phongTroService.addPhong(tro);
        showListPhong(request,response);
    }
    private void showTaoPhong(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("phongTro/createPhongTro.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deletePhong(HttpServletRequest request, HttpServletResponse response) {
        int maPhongTro = Integer.parseInt(request.getParameter("id"));
        phongTroService.removeById(maPhongTro);
        List<PhongTro> list = phongTroService.findAll();
        request.setAttribute("phongTros", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("phongTro/listPhongTro.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("searchName");
        List <PhongTro> list = phongTroService.findByName(name);
        request.setAttribute("phongTros",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("phongTro/listPhongTro.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
