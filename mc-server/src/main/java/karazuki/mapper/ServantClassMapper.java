package karazuki.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ServantClassMapper {

    @Select("select damage_cft from servant_class where ename = #{sclass}")
    Float findCftByEname(String sclass);
}
