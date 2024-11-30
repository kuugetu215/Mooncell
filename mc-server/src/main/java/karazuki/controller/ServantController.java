package karazuki.controller;

import dto.ServantDTO;
import dto.ServantPageQueryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.ServantService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.PageResult;
import result.Result;
import vo.ServantVO;
import vo.SpecialAttackSearchVO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servant")
@Tag(name = "从者相关接口")
public class ServantController {

    @Autowired
    private ServantService servantService;

    /**
     * 从者列表分页查询
     * @param servantPageQueryDTO
     * @return
     */
    @Operation(description = "从者列表分页查询")
    @GetMapping()
    public Result<PageResult> ServantPage(@RequestBody ServantPageQueryDTO servantPageQueryDTO){
        log.info("从者列表分页查询");
        PageResult page = servantService.pageQuery(servantPageQueryDTO);
        return Result.success(page);
    }

    /**
     * 从者详细信息查询
     * @param id
     * @return
     */
    @Operation(description = "从者详细信息查询")
    @GetMapping("/{id}")
    public Result<ServantVO> servantData(@PathVariable Integer id){
        log.info("从者详细信息查询:{}", id);
        ServantVO servantVO = servantService.findById(id);
        return Result.success(servantVO);
    }

    /**
     * 查询对该从者特攻的从者
     * @param id
     * @return
     */
    @Operation(description = "查询对该从者特攻的从者")
    @GetMapping("/{id}/saSearch")
    public Result specialAttackData(@PathVariable Integer id){
        log.info("查询对该从者特攻的从者");
        List<SpecialAttackSearchVO> specialAttackSearchVOS = servantService.saSearch(id);
        return Result.success(specialAttackSearchVOS);
    }

    /**
     * 从者信息插入
     * @param servantDTO
     * @return
     */
    @Operation(description = "从者信息插入")
    @PostMapping("")
    public Result insertServant(@RequestBody ServantDTO servantDTO){
        log.info("从者信息插入:{}", servantDTO);
        servantService.insert(servantDTO);
        return Result.success();
    }

    /**
     * 从者信息更新
     * @param servantDTO
     * @return
     */
    @Operation(description = "从者信息更新")
    @PutMapping("")
    public Result updateServant(@RequestBody ServantDTO servantDTO){
        log.info("从者信息更新:{}", servantDTO);
        servantService.update(servantDTO);
        return Result.success();
    }

    /**
     * 删除所有从者相关信息
     * @param id
     * @return
     */
    @Operation(description = "删除所有从者相关信息")
    @DeleteMapping("/{id}")
    public Result deleteServant(@PathVariable Integer id){
        log.info("删除所有从者相关信息");
        servantService.delete(id);
        return Result.success();
    }
}
