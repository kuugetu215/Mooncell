package karazuki.mapper;

import entity.SkillDetail;
import karazuki.annotation.FillTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkillDetailMapper {

    @Select("select * from skill_detail where skill_id = #{skillId}")
    List<SkillDetail> findBySkillId(Integer skillId);

    @FillTime
    void insertBatch(List<SkillDetail> skillDetailList);
}
