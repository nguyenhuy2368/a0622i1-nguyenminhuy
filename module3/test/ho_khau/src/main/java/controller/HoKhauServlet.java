package controller;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import model.HoKhau;
import model.ThanhVien;
import service.HoKhauService;
import service.IHoKhauService;
import service.IThanhVienService;
import service.ThanhVienService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HoKhauServlet", urlPatterns = "/hokhaus")
public class HoKhauServlet extends HttpServlet {
    private IThanhVienService thanhVienService = new ThanhVienService();
    private IHoKhauService hoKhauService = new HoKhauService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createHoKhau(request, response);
                break;
            case "edit":
                editHoKhau(request, response);
                break;
            case "delete":
                deleteHoKhau(request, response);
                break;
            default:
                listHoKhau(request, response);
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "Search":
                showFindForm(request, response);
                break;
            default:
                listHoKhau(request, response);
                break;
        }
    }


    private void editHoKhau(HttpServletRequest request, HttpServletResponse response) {
        String maHoKhau = request.getParameter("maHoKhau");
        String tenChuHo = request.getParameter("tenChuHo");
        int soThanhVien = Integer.parseInt(request.getParameter("soThanhVien"));
        String ngayLapHoKhau = request.getParameter("ngayLapHoKhau");
        String diaChi = request.getParameter("diaChi");
        HoKhau hoKhaus = new HoKhau(maHoKhau, tenChuHo, soThanhVien, ngayLapHoKhau, diaChi);
        hoKhauService.editHoKhau(hoKhaus);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hokhau/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String maHoKhau = request.getParameter("maHoKhau");
        HoKhau hoKhaus = hoKhauService.findByMaHoKhau(maHoKhau);
        List<ThanhVien> thanhViens = thanhVienService.listThanhVien();
        request.setAttribute("hoKhaus", hoKhaus);
        request.setAttribute("thanViens", thanhViens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hokhau/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createHoKhau(HttpServletRequest request, HttpServletResponse response) {
        List<HoKhau> hoKhaus = hoKhauService.listHoKhau();
        String maHoKhau = request.getParameter("maHoKhau");
        String tenChuHo = request.getParameter("tenChuHo");
        int soThanhVien = Integer.parseInt(request.getParameter("soThanhVien"));
        String ngayLapHoKhau = request.getParameter("ngayLapHoKhau");
        String diaChi = request.getParameter("diaChi");
        HoKhau hoKhau = new HoKhau(maHoKhau, tenChuHo, soThanhVien, ngayLapHoKhau, diaChi);
        hoKhauService.createHoKhau(hoKhau);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hokhau/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<ThanhVien> thanhViens = thanhVienService.listThanhVien();
        request.setAttribute("thanhViens", thanhViens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hokhau/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listHoKhau(HttpServletRequest request, HttpServletResponse response) {
        List<HoKhau> hoKhaus = hoKhauService.listHoKhau();
        request.setAttribute("hoKhaus", hoKhaus);

        List<ThanhVien> thanhViens = thanhVienService.listThanhVien();
        request.setAttribute("thanhViens", thanhViens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hokhau/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteHoKhau(HttpServletRequest request, HttpServletResponse response) {
        String maHoKhau = request.getParameter("maHoKhau");
        hoKhauService.deleteHoKhau(maHoKhau);
        List<HoKhau> hoKhaus = hoKhauService.listHoKhau();
        request.setAttribute("hoKhaus", hoKhaus);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hokhau/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFindForm(HttpServletRequest request, HttpServletResponse response) {
    }

}
