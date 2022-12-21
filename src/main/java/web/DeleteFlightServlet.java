package web;

import com.alibaba.fastjson.JSON;
import pojo.Flight;
import service.FlightService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet {
    private FlightService flightService=new FlightService();//实现类
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受fid
        BufferedReader reader = request.getReader();
        String fid = reader.readLine();//由于fid是String类型不需要转换
        //调用方法删除
        flightService.deleteByFid(fid);
        //发送响应成功标识符
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
