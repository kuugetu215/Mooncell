package karazuki.mapper;

import entity.ServantData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServantDataMapper {

    @Select("select * from servant_data where sid = #{sid}")
    List<ServantData> findBySid(Integer sid);
}