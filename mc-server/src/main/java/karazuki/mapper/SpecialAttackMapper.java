package karazuki.mapper;

import entity.SpecialAttack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface SpecialAttackMapper {

    List<SpecialAttack> findByCharas(List<String> saSearches);

    @Select("select * from special_attack order by sid asc")
    List<SpecialAttack> list();


    void insert(SpecialAttack specialAttack);
}
