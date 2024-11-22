package karazuki.controller;

import io.swagger.v3.oas.annotations.Operation;
import karazuki.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import vo.SkillVO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servant/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    /**
     * 查询从者技能信息
     * @param id
     * @return
     */
    @Operation(description = "查询从者技能信息")
    @GetMapping("/{id}")
    public Result<List<SkillVO>> skillData(@PathVariable Integer id){
        log.info("查询从者技能信息");
        List<SkillVO> skillVOList = skillService.getBySid(id);
        return Result.success(skillVOList);
    }
}
