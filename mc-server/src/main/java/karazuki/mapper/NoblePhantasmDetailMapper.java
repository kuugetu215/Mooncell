package karazuki.mapper;

import entity.NoblePhantasmDetail;
import karazuki.annotation.FillTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NoblePhantasmDetailMapper {

    @Select("select * from noble_phantasm_detail where nid = #{nid}")
    List<NoblePhantasmDetail> findByNId(Integer nid);

    @FillTime
    void insertBatch(List<NoblePhantasmDetail> noblePhantasmDetailList);

    @Select("select * from noble_phantasm_detail where nid = #{nid} and effect = #{effect}")
    NoblePhantasmDetail findByNIdAndEffect(Integer nid, String effect);

    @FillTime
    void update(NoblePhantasmDetail noblePhantasmDetail);
}
