package controller;

import model.service.Service;
import service.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService serviceService = new ServiceService();
    IServiceTypeService serviceTypeService = new ServiceTypeService();
    IRentTypeService rentTypeService = new RentTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                updateService(request, response);
                break;
            case "search":
                searchServiceByName(request, response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void searchServiceByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        if (name.equals("")) {
            showListService(request, response);
        } else {
            List<Service> list = serviceService.getListServiceByName(name);
            if (list.size() != 0) {
                request.setAttribute("listServiceFindByName", list);
            } else {
                request.setAttribute("searchName", "not found");
            }
            request.setAttribute("findName",name);
            try {
                request.getRequestDispatcher("service/list.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standard = request.getParameter("standard");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int floors = Integer.parseInt(request.getParameter("floors"));
        Service service = new Service(id, name, area, cost, maxPeople, rentTypeService.getRenTypeById(rentTypeId),
                serviceTypeService.getServiceTypeById(serviceTypeId), standard, description, poolArea, floors);
        if (!serviceService.isFullName(name)) request.setAttribute("error", "name");
        else if (!serviceService.isNumberPositive(area)) request.setAttribute("error", "area");
        else if (!serviceService.isNumberPositive(maxPeople)) request.setAttribute("error", "max people");
        else if (!serviceService.isNumberPositive(floors)) request.setAttribute("error", "floors");
        else if (!serviceService.isDoublePositive(cost)) request.setAttribute("error", "cost");
        else if (!serviceService.isDoublePositive(poolArea)) request.setAttribute("error", "poolArea");
        else if (!serviceService.isNullPointerException(standard)) request.setAttribute("error", "Standard");
        else if (!serviceService.isNullPointerException(description)) request.setAttribute("error", "Description");
        else {
            serviceService.update(id, service);
            showListService(request, response);
            return;
        }
        request.setAttribute("service", service);
        try {
            request.getRequestDispatcher("service/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> list = serviceService.selectAllService();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("service/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        if (!request.getParameter("area").equals("") && !request.getParameter("cost").equals("") &&
                !request.getParameter("maxPeople").equals("") && !request.getParameter("poolArea").equals("") &&
                !request.getParameter("floors").equals("") && !request.getParameter("name").equals("") &&
                !request.getParameter("rentTypeId").equals("") && !request.getParameter("serviceTypeId").equals("") &&
                !request.getParameter("standard").equals("") && !request.getParameter("description").equals("")) {
            int id = (int) (Math.random() * 1000);
            String name = request.getParameter("name");
            int area = Integer.parseInt(request.getParameter("area"));
            double cost = Double.parseDouble(request.getParameter("cost"));
            int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
            int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
            int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
            String standard = request.getParameter("standard");
            String description = request.getParameter("description");
            double poolArea = Double.parseDouble(request.getParameter("poolArea"));
            int floors = Integer.parseInt(request.getParameter("floors"));
            Service service = new Service(id, name, area, cost, maxPeople, rentTypeService.getRenTypeById(rentTypeId),
                    serviceTypeService.getServiceTypeById(serviceTypeId), standard, description, poolArea, floors);
            if (!serviceService.isFullName(name)) request.setAttribute("error", "name");
            else if (!serviceService.isNumberPositive(area)) request.setAttribute("error", "area");
            else if (!serviceService.isNumberPositive(maxPeople)) request.setAttribute("error", "max people");
            else if (!serviceService.isNumberPositive(floors)) request.setAttribute("error", "floors");
            else if (!serviceService.isDoublePositive(cost)) request.setAttribute("error", "cost");
            else if (!serviceService.isDoublePositive(poolArea)) request.setAttribute("error", "poolArea");
            else if (!serviceService.isNullPointerException(standard)) request.setAttribute("error", "Standard");
            else if (!serviceService.isNullPointerException(description)) request.setAttribute("error", "Description");
            else {
                serviceService.save(service);
                showListService(request, response);
                return;
            }
            request.setAttribute("service", service);
        } else {
            request.setAttribute("errorNull", "Please fill in the blanks!!!");
        }
        try {
            request.getRequestDispatcher("service/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateServiceForm(request, response);
                break;
            case "edit":
                showEditServiceForm(request, response);
                break;
            case "delete":
                removeService(request, response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void removeService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceService.remove(id);
        showListService(request, response);
    }

    private void showEditServiceForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceService.getServiceById(id);
        request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateServiceForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("service/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
