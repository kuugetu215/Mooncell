package karazuki.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.SpecialAttackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
