package service;

import mapper.FlightMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Flight;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * 对FlightMapper中方法的实现类
 */
public class FlightService {
    //创建工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有航班
     * @return
     */
    public List<Flight> selectAllFlight(){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FlightMapper
        FlightMapper mapper = sqlSession.getMapper(FlightMapper.class);
        //调用方法
        List<Flight> flights = mapper.selectAllFlight();
        //释放资源
        sqlSession.close();
        return flights;
    }

    /**
     * 主查询
     * @param flight
     * @return
     */
    public List<Flight> mainSelect(Flight flight){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FlightMapper
        FlightMapper mapper = sqlSession.getMapper(FlightMapper.class);
        //调用方法
        List<Flight> flights = mapper.mainSelect(flight);
        //释放资源
        return flights;
    }

    /**
     * 添加航班数据
     * @param flight
     */
    public void addFlight(Flight flight){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FlightMapper
        FlightMapper mapper = sqlSession.getMapper(FlightMapper.class);
        //调用方法
        mapper.addFlight(flight);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public void deleteByFid(String fid){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FlightMapper
        FlightMapper mapper = sqlSession.getMapper(FlightMapper.class);
        //调用方法
        mapper.deleteByFid(fid);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 在我的订单中查询
     * @param pid
     * @return
     */
    public List<Flight> mySelect(int pid){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FlightMapper
        FlightMapper mapper = sqlSession.getMapper(FlightMapper.class);
        //调用方法
        List<Flight> flights = mapper.mySelect(pid);
        //释放资源
        sqlSession.close();
        return flights;
    }
}
