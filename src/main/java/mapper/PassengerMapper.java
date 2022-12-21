package mapper;

import org.apache.ibatis.annotations.Select;

public interface PassengerMapper {
    @Select("select Pname from Passenger where Pid=#{pid}")
    String selectPnameByPid(int pid);
}

