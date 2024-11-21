package karazuki.service;

import vo.NoblePhantasmVO;

public interface NoblePhantasmService {

    /**
     * 根据从者id查询宝具信息
     * @param id
     * @return
     */
    NoblePhantasmVO findBySid(Integer id);
}
