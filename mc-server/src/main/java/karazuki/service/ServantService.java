package karazuki.service;

import dto.ServantPageQueryDTO;
import result.PageResult;
import vo.ServantVO;

public interface ServantService {


    /**
     * 从者列表分页查询
     * @param servantPageQueryDTO
     * @return
     */
    PageResult pageQuery(ServantPageQueryDTO servantPageQueryDTO);

    /**
     * 从者详细信息查询
     * @param id
     * @return
     */
    ServantVO findById(Integer id);
}
