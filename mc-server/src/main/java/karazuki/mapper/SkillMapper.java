package karazuki.mapper;

import entity.Skill;
import karazuki.annotation.FillTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkillMapper {

    @Select("select * from skill where sid = #{sid} order by skill_type, number asc, rankup_num desc")
    List<Skill> findBySid(Integer sid);

    @Select("select * from skill where sid = #{sid} and skill_type = #{skillType} and number = #{number} and rankup_num = #{rankupNum}")
    Skill findBySidAndTypeAndNumber(Integer sid, Integer skillType, Integer number, Integer rankupNum);

    @FillTime
    void insert(Skill skill);
}
