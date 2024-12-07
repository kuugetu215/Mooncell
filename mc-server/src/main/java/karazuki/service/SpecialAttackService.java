package karazuki.service;

import dto.SpecialAttackDTO;
import entity.SpecialAttack;
import vo.SpecialAttackSearchVO;

import java.util.List;

public interface SpecialAttackService {
    List<SpecialAttackSearchVO> list();

    void insert(SpecialAttackDTO specialAttackDTO);

    void update(SpecialAttack specialAttack);
}
