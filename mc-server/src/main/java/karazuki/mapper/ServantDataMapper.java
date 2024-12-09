package karazuki.mapper;

import entity.ServantData;
import karazuki.annotation.FillTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServantDataMapper {

    @Select("select * from servant_data where sid = #{sid}")
    List<ServantData> findBySid(Integer sid);

    @Select("select * from servant_data where sid = #{sid} and `condition` = #{condition}")
    ServantData findBySidAndCondition(Integer sid, String condition);

    @FillTime
    void insert(ServantData servantData);

    @FillTime
    void update(ServantData servantData);
}
