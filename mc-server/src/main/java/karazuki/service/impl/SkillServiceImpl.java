package karazuki.service.impl;

import dto.SkillDTO;
import entity.Skill;
import entity.SkillDetail;
import karazuki.mapper.SkillDetailMapper;
import karazuki.mapper.SkillMapper;
import karazuki.service.SkillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vo.SkillVO;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillMapper skillMapper;

    @Autowired
    private SkillDetailMapper skillDetailMapper;

    /**
     * 根据从者id查询技能信息
     * @param id
     * @return
     */
    @Override
    public List<SkillVO> getBySid(Integer id) {
        List<SkillVO> skillVOList = new ArrayList<>();

        //根据从者id查询技能基本表
        List<Skill> skillList = skillMapper.findBySid(id);

        //遍历skillList，查询并查询技能详情表
        for (int i = 0; i < skillList.size(); i++){
            Skill skill = skillList.get(i);
            SkillVO skillVO = new SkillVO();
            BeanUtils.copyProperties(skill, skillVO);

            List<SkillDetail> skillDetailList = skillDetailMapper.findBySkillId(skill.getId());
            skillVO.setSkillDetails(skillDetailList);

            skillVOList.add(skillVO);
        }

        return skillVOList;
    }

    /**
     * 插入技能信息
     * @param skillDTOList
     */
    @Override
    @Transactional
    public void insert(List<SkillDTO> skillDTOList) {
        //循环并逐条插入
        for(SkillDTO skillDTO: skillDTOList){
            //查询是否存在该技能信息，如果存在，抛出异常
            Skill s = skillMapper.findBySidAndTypeAndNumber(skillDTO.getSid(), skillDTO.getSkillType(), skillDTO.getNumber(), skillDTO.getRankupNum());
            if (s != null){
                throw new RuntimeException("技能已存在");
            }
            //如果不存在，插入信息
            //插入技能基本信息
            Skill skill = new Skill();
            BeanUtils.copyProperties(skillDTO, skill);
            skillMapper.insert(skill);

            //插入技能详情信息
            List<SkillDetail> skillDetailList = skillDTO.getSkillDetailList();
            if (skillDetailList != null && skillDetailList.size() > 0){
                skillDetailList.forEach(skillDetail -> {
                    skillDetail.setSkillId(skill.getId());
                });
                skillDetailMapper.insertBatch(skillDetailList);
            }
        }
    }
}
