package karazuki.service;

import dto.NoblePhantasmDTO;
import vo.NoblePhantasmVO;

public interface NoblePhantasmService {

    /**
     * 根据从者id查询宝具信息
     * @param id
     * @return
     */
    NoblePhantasmVO findBySid(Integer id);

    /**
     * 插入从者宝具信息
     * @param noblePhantasmDTO
     */
    void insert(NoblePhantasmDTO noblePhantasmDTO);
}
