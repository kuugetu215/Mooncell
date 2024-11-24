package karazuki.controller;

import dto.NoblePhantasmDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.NoblePhantasmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;
import vo.NoblePhantasmVO;

@Slf4j
@RestController
@RequestMapping("/servant/np")
@Tag(name = "从者宝具相关接口")
public class NoblePhantasmController {

    @Autowired
    private NoblePhantasmService noblePhantasmService;

    /**
     * 从者宝具信息
     * @param id
     * @return
     */
    @Operation(description = "从者宝具信息")
    @GetMapping("/{id}")
    public Result<NoblePhantasmVO> npData(@PathVariable Integer id){
        log.info("从者宝具信息");
        NoblePhantasmVO noblePhantasmVO = noblePhantasmService.findBySid(id);
        return Result.success(noblePhantasmVO);
    }

    /**
     * 插入从者宝具数据
     * @param noblePhantasmDTO
     * @return
     */
    @Operation(description = "插入从者宝具信息")
    @PostMapping("")
    public Result insertNp(@RequestBody NoblePhantasmDTO noblePhantasmDTO){
        log.info("插入从者宝具数据:{}", noblePhantasmDTO);
        noblePhantasmService.insert(noblePhantasmDTO);
        return Result.success();
    }

}
