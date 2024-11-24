package karazuki.mapper;

import entity.NoblePhantasmDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoblePhantasmDetailMapper {

    @Select("select * from noble_phantasm_detail where nid = #{nid}")
    List<NoblePhantasmDetail> findByNId(Integer nid);

    void insertBatch(List<NoblePhantasmDetail> noblePhantasmDetailList);
}
