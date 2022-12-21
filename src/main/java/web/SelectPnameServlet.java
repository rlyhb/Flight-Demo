package web;

import com.alibaba.fastjson.JSON;
import pojo.Flight;
import service.PassengerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/SelectPnameServlet")
public class SelectPnameServlet extends HttpServlet {
    private PassengerService passengerService=new PassengerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受pid
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //将JSON字符串转换为JAVA对象
        int pid = JSON.parseObject(params, Integer.class);
        //调用方法查询
        String pname = passengerService.selectPnameByPid(pid);
        response.setContentType("text/json;charset=utf-8");//数据存在中文，修改字符集
        //返回姓名
        response.getWriter().write(pname);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
