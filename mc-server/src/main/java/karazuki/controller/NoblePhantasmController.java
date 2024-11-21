package karazuki.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.NoblePhantasmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import vo.NoblePhantasmVO;

@Slf4j
@RestController
@RequestMapping("/servant/np")
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
}
