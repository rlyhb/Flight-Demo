package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import pojo.FP;

/**
 * 乘客航班信息类
 */
public interface FPMapper {
    /**
     * 购买机票即添加身份证号和航班号
     * @param fp
     */
    @Insert("insert into FP values(#{fid},#{pid})")
    void add(FP fp);

    /**
     * 查询航班被购买数
     * @param fid
     * @return
     */
    @Select("select count(*) from FP where fid=#{fid}")
    int selectCountByFid(String fid);

    /**
     * 退订，根据航班号和身份证号删除
     * @param fp
     */
    @Delete("delete from FP where Fid=#{fid} and Pid=#{pid}")
    void deleteOrder(FP fp);
}
