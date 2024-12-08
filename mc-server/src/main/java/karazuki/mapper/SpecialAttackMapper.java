package karazuki.mapper;

import entity.SpecialAttack;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface SpecialAttackMapper {

    List<SpecialAttack> findByCharas(List<String> saSearches);

    @Select("select * from special_attack order by sid asc")
    List<SpecialAttack> list();


    void insert(SpecialAttack specialAttack);

    void update(SpecialAttack specialAttack);

    @Select("select * from special_attack where id = #{id} and sid = #{sid} and type = #{type} and obj = #{obj}")
    boolean find(SpecialAttack specialAttack);

    @Delete("delete from special_attack where id = #{id}")
    void delete(Integer id);
}
