package web;

import com.alibaba.fastjson.JSON;
import pojo.FP;
import pojo.Flight;
import service.FPService;
import service.FlightService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectAllFlightServlet")
public class SelectAllFlightServlet extends HttpServlet {
    private FlightService flightService=new FlightService();//实现类
    private FPService fpService=new FPService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询
        List<Flight> flights = flightService.selectAllFlight();
        for(int i=0;i<flights.size();i++){
            Flight flight=flights.get(i);
            float count=fpService.selectCountByFid(flight.getFid());
            flight.setFsr((count/flight.getSeatCount())*100);//设置满足率
        }
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
