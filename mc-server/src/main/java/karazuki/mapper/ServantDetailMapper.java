package karazuki.mapper;

import entity.ServantDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ServantDetailMapper {

    @Select("select * from servant_detail where sid = #{sid}")
    ServantDetail findBySid(Integer sid);
}
