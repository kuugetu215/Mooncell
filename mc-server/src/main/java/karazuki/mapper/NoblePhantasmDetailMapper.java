package karazuki.mapper;

import entity.NoblePhantasmDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NoblePhantasmDetailMapper {

    @Select("select * from noble_phantasm_detail where nid = #{nid}")
    List<NoblePhantasmDetail> findByNId(Integer nid);

    void insertBatch(List<NoblePhantasmDetail> noblePhantasmDetailList);

    @Select("select * from noble_phantasm_detail where nid = #{nid} and effect = #{effect}")
    NoblePhantasmDetail findByNIdAndEffect(Integer nid, String effect);

    @Update("update noble_phantasm_detail set effect_value = #{effectValue} where nid = #{nid} and effect = #{effect}")
    void update(NoblePhantasmDetail noblePhantasmDetail);
}
