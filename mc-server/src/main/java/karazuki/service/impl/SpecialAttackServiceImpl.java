package karazuki.service.impl;

import dto.SpecialAttackDTO;
import entity.Servant;
import entity.SpecialAttack;
import karazuki.mapper.ServantMapper;
import karazuki.mapper.SpecialAttackMapper;
import karazuki.service.SpecialAttackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.SpecialAttackSearchVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialAttackServiceImpl implements SpecialAttackService {

    @Autowired
    private SpecialAttackMapper specialAttackMapper;

    @Autowired
    private ServantMapper servantMapper;

    @Override
    public List<SpecialAttackSearchVO> list() {
        //查询特攻表是否具有相关信息
        List<SpecialAttack> specialAttackList = specialAttackMapper.list();

        List<SpecialAttackSearchVO> specialAttackSearchVOS = new ArrayList<>();

        for (SpecialAttack specialAttack : specialAttackList){

            Servant s = servantMapper.findById(specialAttack.getSid());
            SpecialAttackSearchVO specialAttackSearchVO = new SpecialAttackSearchVO();
            BeanUtils.copyProperties(specialAttack, specialAttackSearchVO);

            //TODO 当前从者表中信息不足，相关信息暂时不进行封装

//            specialAttackSearchVO.setSclass(s.getSclass());
//            specialAttackSearchVO.setImage(s.getImage());
//            specialAttackSearchVO.setName(s.getCname());

            specialAttackSearchVOS.add(specialAttackSearchVO);
        }

        return specialAttackSearchVOS;
    }

    @Override
    public void insert(SpecialAttackDTO specialAttackDTO) {
        SpecialAttack specialAttack = new SpecialAttack();
        BeanUtils.copyProperties(specialAttackDTO, specialAttack);
        if(specialAttackMapper.find(specialAttack)){
            throw new RuntimeException("该项已存在");
        }
        specialAttackMapper.insert(specialAttack);
    }

    @Override
    public void update(SpecialAttack specialAttack) {

        specialAttackMapper.update(specialAttack);
    }
}
