package web;

import com.alibaba.fastjson.JSON;
import pojo.FP;
import service.FPService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/BuyFlightServlet")
public class BuyFlightServlet extends HttpServlet {
    private FPService fpService=new FPService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        //由于是post请求方式，直接获取请求体对象就好
        BufferedReader reader = request.getReader();
        String params = reader.readLine();//获取的数据肯定是一行，读一行即可
        //将JSON字符串转换为JAVA对象
        FP fp = JSON.parseObject(params,FP.class);
        //调用方法添加
        fpService.add(fp);
        //发送响应成功标识符
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
