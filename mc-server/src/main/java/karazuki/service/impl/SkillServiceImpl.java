package karazuki.service.impl;

import entity.Skill;
import entity.SkillDetail;
import karazuki.mapper.SkillDetailMapper;
import karazuki.mapper.SkillMapper;
import karazuki.service.SkillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        //遍历skillList，查询并插入技能详情表
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
}
