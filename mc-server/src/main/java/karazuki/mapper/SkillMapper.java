package karazuki.mapper;

import entity.Skill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkillMapper {

    @Select("select * from skill where sid = #{sid} order by skill_type, number, rankup_num asc")
    List<Skill> findBySid(Integer sid);
}
