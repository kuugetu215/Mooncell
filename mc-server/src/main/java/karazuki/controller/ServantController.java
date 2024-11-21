package karazuki.controller;

import dto.ServantPageQueryDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.ServantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.PageResult;
import result.Result;
import vo.ServantVO;

@Slf4j
@RestController
@RequestMapping("/servant")
public class ServantController {

    @Autowired
    private ServantService servantService;

    /**
     * 从者列表分页查询
     * @param servantPageQueryDTO
     * @return
     */
    @Tag(name = "从者列表分页查询")
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
    @Tag(name = "从者详细信息查询")
    @GetMapping("/{id}")
    public Result<ServantVO> servantData(@PathVariable Integer id){
        log.info("从者详细信息查询:{}", id);
        ServantVO servantVO = servantService.findById(id);
        return Result.success(servantVO);
    }
}
