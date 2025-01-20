package karazuki.service;

import dto.ServantImageDTO;

import java.util.List;

public interface ServantImageService {
    void insert(List<ServantImageDTO> servantImageDTOS);

    void update(ServantImageDTO servantImageDTO);

    void delete(Integer id);
}
