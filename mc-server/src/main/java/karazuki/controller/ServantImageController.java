package karazuki.controller;

import dto.ServantImageDTO;
import entity.ServantImage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.ServantImageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servant/image")
@Tag(name = "从者图片相关接口")
public class ServantImageController {

    @Autowired
    private ServantImageService servantImageService;

    /**
     * 添加从者图片
     * @param servantImageDTOS
     * @return
     */
    @Operation(description = "添加从者图片")
    @PostMapping("")
    public Result insert(@RequestBody List<ServantImageDTO> servantImageDTOS){
        log.info("添加从者图片");
        servantImageService.insert(servantImageDTOS);
        return Result.success();
    }

    /**
     * 修改从者图片信息
     * @param servantImageDTO
     * @return
     */
    @Operation(description = "修改从者图片信息")
    @PutMapping
    public Result update(@RequestBody ServantImageDTO servantImageDTO){
        log.info("修改从者图片信息");
        servantImageService.update(servantImageDTO);
        return Result.success();
    }

    /**
     * 删除从者立绘信息
     * @param id
     * @return
     */
    @Operation(description = "删除从者立绘信息")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除从者立绘信息");
        servantImageService.delete(id);
        return Result.success();
    }
}
