package karazuki.mapper;

import entity.NoblePhantasm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoblePhantasmMapper {

    @Select("select * from noble_phantasm where sid = #{sid}")
    NoblePhantasm findBySid(Integer sid);

    void insert(NoblePhantasm noblePhantasm);
}
