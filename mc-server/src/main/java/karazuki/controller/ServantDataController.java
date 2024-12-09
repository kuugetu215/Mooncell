package karazuki.controller;

import dto.ServantDataDTO;
import entity.ServantData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.ServantDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servant/data")
@Tag(name = "从者资料相关接口")
public class ServantDataController {

    @Autowired
    private ServantDataService servantDataService;

    /**
     * 查询从者资料
     * @param id
     * @return
     */
    @Operation(description = "查询从者资料")
    @GetMapping("/{id}")
    public Result<List<ServantData>> servantData(@PathVariable Integer id){
        log.info("查询从者资料");
        List<ServantData> servantData = servantDataService.findBySid(id);
        return Result.success(servantData);
    }

    /**
     * 批量插入从者资料
     * @param servantDataDTOList
     * @return
     */
    @Operation(description = "批量插入从者资料")
    @PostMapping()
    public Result inertData(@RequestBody List<ServantDataDTO> servantDataDTOList){
        log.info("批量插入从者资料:{}", servantDataDTOList);
        servantDataService.insertBatch(servantDataDTOList);
        return Result.success();
    }

    /**
     * 修改从者资料
     * @return
     */
    @Operation(description = "修改从者资料")
    @PutMapping
    public Result updateData(@RequestBody ServantDataDTO servantDataDTO){
        log.info("修改从者资料");
        servantDataService.update(servantDataDTO);
        return Result.success();
    }

}
