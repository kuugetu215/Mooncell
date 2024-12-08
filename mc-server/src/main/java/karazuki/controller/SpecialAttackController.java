package karazuki.controller;

import dto.SpecialAttackDTO;
import entity.SpecialAttack;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.SpecialAttackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;
import vo.SpecialAttackSearchVO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servant/sa")
@Tag(name = "特攻相关接口")
public class SpecialAttackController {

    @Autowired
    private SpecialAttackService specialAttackService;

    /**
     * 全部特攻展示
     * @return
     */
    @GetMapping
    @Operation(description = "全部特攻展示")
    public Result<List<SpecialAttackSearchVO>> saSearch(){
        log.info("全部特攻展示");
        List<SpecialAttackSearchVO> specialAttackSearchVOS = specialAttackService.list();
        return Result.success(specialAttackSearchVOS);
    }

    /**
     * 手动插入特攻信息
     * @return
     */
    @PostMapping
    @Operation(description = "手动插入特攻信息")
    public Result saInsert(@RequestBody SpecialAttackDTO specialAttackDTO){
        log.info("手动插入特攻信息：{}", specialAttackDTO);
        specialAttackService.insert(specialAttackDTO);
        return Result.success();
    }

    /**
     * 手动更新特攻信息
     * @return
     */
    @PostMapping
    @Operation(description = "手动更新特攻信息")
    public Result saUpdate(@RequestBody SpecialAttack specialAttack){
        log.info("手动更新特攻信息：{}", specialAttack);
        specialAttackService.update(specialAttack);
        return Result.success();
    }

    /**
     * 手动删除特攻信息
     * @return
     */
    @Operation(description = "手动删除特攻信息")
    @DeleteMapping("/{id}")
    public Result saDelete(@PathVariable Integer id){
        log.info("手动删除特攻信息");
        specialAttackService.delete(id);
        return Result.success();
    }
}
