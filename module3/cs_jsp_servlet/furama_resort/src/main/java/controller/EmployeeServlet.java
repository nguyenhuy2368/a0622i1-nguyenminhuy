package controller;

import model.employee.Divition;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import model.user.User;
import service.employee.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    IDivitionService divitionService = new DivitionService();
    IPositionService positionService = new PositionService();
    IEducationDegreeService educationDegreeService = new EducationDegreeService();
    IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            case "findEmployeeById":
                findEmployeeById(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divitionId = Integer.parseInt(request.getParameter("divitionId"));
        String username = request.getParameter("username");
        Position position = positionService.getPositionById(positionId);
        EducationDegree educationDegree = educationDegreeService.getEducationDegreeById(educationDegreeId);
        Divition divition = divitionService.getDivitionById(divitionId);
        User user = userService.getUserByName(username);
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, divition, user);
        employeeService.update(id, employee);
        showListEmployee(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divitionId = Integer.parseInt(request.getParameter("divitionId"));
        String username = request.getParameter("username");
        Position position = positionService.getPositionById(positionId);
        EducationDegree educationDegree = educationDegreeService.getEducationDegreeById(educationDegreeId);
        Divition divition = divitionService.getDivitionById(divitionId);
        User user = userService.getUserByName(username);
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, divition, user);
        employeeService.save(employee);
        showListEmployee(request, response);
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> list = employeeService.selectAllEmployee();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void findEmployeeById(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        if (name.equals("")) {
            showListEmployee(request, response);
        } else {
            List<Employee> list = employeeService.getEmployeeByName(name);
            if (list.size() != 0) {
                request.setAttribute("listEmployeeFindByName", list);
            } else {
                request.setAttribute("searchName", "not found");
            }
            request.setAttribute("findName", name);
            try {
                request.getRequestDispatcher("employee/list.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateEmployeeForm(request, response);
                break;
            case "edit":
                showEditEmployeeForm(request, response);
                break;
            case "delete":
                removeEmployee(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    private void removeEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        showListEmployee(request,response);
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            request.setAttribute("employee", employee);
            try {
                request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else showListEmployee(request, response);
    }

    private void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("employee/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
