package karazuki.service;

import dto.ServantDTO;
import dto.ServantPageQueryDTO;
import result.PageResult;
import vo.ServantVO;
import vo.SpecialAttackSearchVO;

import java.util.List;

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

    /**
     * 从者信息插入
     * @param servantDTO
     */
    void insert(ServantDTO servantDTO);

    /**
     * 从者信息更新
     * @param servantDTO
     */
    void update(ServantDTO servantDTO);

    /**
     * 删除所有从者相关信息
     * @param id
     */
    void delete(Integer id);

    /**
     * 查询对该从者特攻的从者
     * @param id
     * @return
     */
    List<SpecialAttackSearchVO> saSearch(Integer id);
}
