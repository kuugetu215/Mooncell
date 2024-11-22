package karazuki.controller;

import entity.ServantData;
import io.swagger.v3.oas.annotations.Operation;
import karazuki.service.ServantDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servant/data")
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

}
