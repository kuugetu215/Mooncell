package karazuki.mapper;

import entity.SpecialAttack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecialAttackMapper {

    List<SpecialAttack> findByCharas(List<String> saSearches);
}
