package karazuki;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import dto.ServantPageQueryDTO;
import karazuki.mapper.ServantMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vo.ServantPageVO;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class McServerApplicationTests {

    @Autowired
    private ServantMapper servantMapper;

    @Test

    void contextLoads() {
        ServantPageQueryDTO servantPageQueryDTO = new ServantPageQueryDTO();
        servantPageQueryDTO.setPage(1);
        servantPageQueryDTO.setPageSize(10);
        List<String> stringList = new ArrayList<>();
        stringList.add("saber");
        stringList.add("lancer");
        servantPageQueryDTO.setSclass(stringList);
        servantPageQueryDTO.setSort(0);
        PageHelper.startPage(servantPageQueryDTO.getPage(), servantPageQueryDTO.getPageSize());
        Page<ServantPageVO> page = servantMapper.page(servantPageQueryDTO);
        log.info("{}", page);
    }

}
