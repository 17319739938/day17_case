package cn.itcast.web;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过方法获取所有用户集合
        UserService userService = new UserServiceImpl();
        List<User> users = userService.findAll();
        request.getSession().setAttribute("users",users);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}