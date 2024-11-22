package karazuki.service;

import entity.ServantData;

import java.util.List;

public interface ServantDataService {

    /**
     * 根据从者id查询从者资料
     * @param sid
     * @return
     */
    List<ServantData> findBySid(Integer sid);
}
