package web;

import com.alibaba.fastjson.JSON;
import pojo.Flight;
import service.FlightService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/MyOrderSelectServlet")
public class MyOrderSelectServlet extends HttpServlet {
    private FlightService flightService=new FlightService();//实现类
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受pid
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //将JSON字符串转换为JAVA对象
        int pid = JSON.parseObject(params, Integer.class);
        //调用方法查询
        List<Flight> flights = flightService.mySelect(pid);
        //转为JSON
        String s = JSON.toJSONString(flights);
        //写数据
        response.setContentType("text/json;charset=utf-8");//数据存在中文，修改字符集
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
