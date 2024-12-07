package karazuki.controller;

import dto.SkillDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;
import vo.SkillVO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servant/skill")
@Tag(name = "技能相关接口")
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


    /**
     * 插入技能信息
     * @return
     */
    @Operation(description = "插入技能信息")
    @PostMapping("")
    public Result insertSkill(@RequestBody List<SkillDTO> skillDTOList){
        log.info("插入技能信息:{}", skillDTOList);
        skillService.insert(skillDTOList);
        return Result.success();
    }

    /**
     * 修改技能信息
     * @return
     */
    @Operation(description = "修改技能信息")
    @PutMapping("")
    public Result updateSkill(@RequestBody List<SkillDTO> skillDTOList) {
        log.info("修改技能信息:{}", skillDTOList);
        skillService.update(skillDTOList);
        return Result.success();
    }
}