package cn.kawhi.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //2.获取资源请求路径
        String uri = request.getRequestURI();
        //3.判断是否包含登陆相关的资源
        if(uri.contains("/index.jsp") || uri.contains("/loginServlet") || uri.contains("/checkCodeServlet") || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/js/")){
            //包含登陆相关的资源，请求想进行登陆操作，放行
            chain.doFilter(request, resp);
        }else{
            //不包含，需要验证用户是否登陆
            //4.从session中获取管理员对象manager
            Object manager = request.getSession().getAttribute("manager");
            if(manager != null){
                //用户已经登陆了，放行
                chain.doFilter(request, resp);
            }else {
                //没有登陆，返回到登陆页面重新登陆
                request.setAttribute("login_msg","您尚未登陆！请登录！");
                request.getRequestDispatcher("/index.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
