package com.palekov.service;

import com.palekov.dto.StoreDto;
import com.palekov.mapper.StoreMapper;
import com.palekov.repository.StoreRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    protected final StoreMapper mapper = Mappers.getMapper(StoreMapper.class);

    public StoreDto getStoreById(Long storeId) {
        return mapper.toStoreDto(storeRepository.findStoreById(storeId));
    }

    public List<StoreDto> getAllStores() {
        return mapper.toListOfStoreDto(storeRepository.findAll());
    }

    public StoreDto createStore(StoreDto storeDto) {
        storeRepository.save(mapper.toStoreEntity(storeDto));
        return storeDto;
    }
}
