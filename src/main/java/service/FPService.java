package service;

import mapper.FPMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.FP;
import util.SqlSessionFactoryUtils;

/**
 * FPMapper中方法的实现类
 */
public class FPService {
    //创建工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 实现购买，即将乘客信息和飞机信息插入
     */
    public void add(FP fp){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FPMapper
        FPMapper mapper = sqlSession.getMapper(FPMapper.class);
        //调用方法
        mapper.add(fp);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 查询一个航班被购买的次数
     * @param fid
     * @return
     */
    public int selectCountByFid(String fid){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FPMapper
        FPMapper mapper = sqlSession.getMapper(FPMapper.class);
        //调用方法
        int count = mapper.selectCountByFid(fid);
        //释放资源
        sqlSession.close();
        return count;
    }

    /**
     * 退订，根据航班号和身份证号
     * @param fp
     */
    public void deleteOrder(FP fp){
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取FPMapper
        FPMapper mapper = sqlSession.getMapper(FPMapper.class);
        //调用方法
        mapper.deleteOrder(fp);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
