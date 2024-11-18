package karazuki.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import dto.ServantPageQueryDTO;
import karazuki.mapper.ServantMapper;
import karazuki.service.ServantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.PageResult;
import vo.ServantPageVO;

@Service
public class ServantServiceImpl implements ServantService {

    @Autowired
    private ServantMapper servantMapper;

    /**
     * 从者列表分页查询
     * @param servantPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(ServantPageQueryDTO servantPageQueryDTO) {
        PageHelper.startPage(servantPageQueryDTO.getPage(), servantPageQueryDTO.getPageSize());
        Page<ServantPageVO> page = servantMapper.page(servantPageQueryDTO);
        return new PageResult(page.getPageSize(), page.getResult());
    }
}
