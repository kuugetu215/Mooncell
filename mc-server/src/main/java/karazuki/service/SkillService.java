package karazuki.service;

import vo.SkillVO;

import java.util.List;

public interface SkillService {

    /**
     * 根据从者id查询从者技能信息
     * @param id
     * @return
     */
    List<SkillVO> getBySid(Integer id);
}
