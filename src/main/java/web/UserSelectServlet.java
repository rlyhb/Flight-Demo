package web;

import com.alibaba.fastjson.JSON;
import pojo.Flight;
import service.FPService;
import service.FlightService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserSelectServlet")
public class UserSelectServlet extends HttpServlet {
    private FlightService flightService=new FlightService();//实现类
    private FPService fpService=new FPService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//防止中文乱码
        //1.接收数据
        //由于是post请求方式，直接获取请求体对象就好
        BufferedReader reader = request.getReader();
        String params = reader.readLine();//获取的数据肯定是一行，读一行即可
        //将JSON字符串转换为JAVA对象
        Flight flight = JSON.parseObject(params, Flight.class);
        //调用方法查询
        List<Flight> flights = flightService.mainSelect(flight);
        for(int i=0;i<flights.size();i++){
            Flight f=flights.get(i);
            float count=fpService.selectCountByFid(f.getFid());
            f.setFsr((count/f.getSeatCount())*100);//设置满足率
        }
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
