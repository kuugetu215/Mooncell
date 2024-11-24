package karazuki.service;

import dto.SkillDTO;
import vo.SkillVO;

import java.util.List;

public interface SkillService {

    /**
     * 根据从者id查询从者技能信息
     * @param id
     * @return
     */
    List<SkillVO> getBySid(Integer id);

    /**
     * 插入技能信息
     * @param skillDTOList
     */
    void insert(List<SkillDTO> skillDTOList);
}
