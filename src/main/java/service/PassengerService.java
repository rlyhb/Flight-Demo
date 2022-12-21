package service;

import mapper.PassengerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.SqlSessionFactoryUtils;

public class PassengerService {
    //创建工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 根据身份证号获取姓名
     * @param pid
     * @return
     */
    public String selectPnameByPid(int pid){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        PassengerMapper passengerMapper = sqlSession.getMapper(PassengerMapper.class);
        //调用方法
        String pname = passengerMapper.selectPnameByPid(pid);
        return pname;
    }
}
