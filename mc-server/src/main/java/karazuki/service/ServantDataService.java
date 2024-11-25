package karazuki.service;

import dto.ServantDataDTO;
import entity.ServantData;

import java.util.List;

public interface ServantDataService {

    /**
     * 根据从者id查询从者资料
     * @param sid
     * @return
     */
    List<ServantData> findBySid(Integer sid);

    /**
     * 批量插入从者资料
     * @param servantDataDTOList
     */
    void insertBatch(List<ServantDataDTO> servantDataDTOList);
}
