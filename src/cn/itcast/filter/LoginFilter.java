package cn.itcast.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login.jsp")||requestURI.contains("/css/")||requestURI.contains("/fonts")||requestURI.contains("/js")||requestURI.contains("/login")||requestURI.contains("/checkCode")){
            chain.doFilter(req,resp);
        }else {
            Object user = request.getSession().getAttribute("name");
            if(user!=null){
                chain.doFilter(req,resp);
            }else {
                request.setAttribute("error","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

        // chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
