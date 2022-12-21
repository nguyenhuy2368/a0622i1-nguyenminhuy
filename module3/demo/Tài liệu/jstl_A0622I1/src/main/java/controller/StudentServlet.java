package controller;

import model.Clazz;
import model.Student;
import service.ClazzService;
import service.IClazzService;
import service.IStudentService;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClazzService clazzService = new ClazzService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                save(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:


        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = studentService.delete(id);
        String mess = "Xoá thành công";
        if (!check) {
            mess = "Xoá thất bại";
        }
        request.setAttribute("mess", mess);
        showList(request, response);

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        // code thêm mới
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        float point = Float.parseFloat(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Clazz clazz = new Clazz(classId);
        Student student = new Student(name, gender, point, clazz);
        boolean check = studentService.add(student);
        String mess = "Thêm mới thành công";
        if (!check) {
            mess = "Thêm mới không thành công";
        }
        request.setAttribute("mess", mess);
        showFormCreate(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                break;
            default:
                showList(request, response);

        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Clazz> clazzList = clazzService.findByAll();
        request.setAttribute("clazzList",clazzList);
        RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("view/student/create.jsp");
        try {
            requestDispatcher1.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentService.findAll();
        request.setAttribute("studentList", studentList);
//        List<Clazz> clazzList = clazzService.findByAll();
//        request.setAttribute("clazzList",clazzList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
