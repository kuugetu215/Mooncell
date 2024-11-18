package karazuki.service;

import dto.ServantPageQueryDTO;
import result.PageResult;

public interface ServantService {


    /**
     * 从者列表分页查询
     * @param servantPageQueryDTO
     * @return
     */
    PageResult pageQuery(ServantPageQueryDTO servantPageQueryDTO);
}
