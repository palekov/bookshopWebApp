package com.palekov.mapper;

import com.palekov.dto.StoreDto;
import com.palekov.model.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    Store toStoreEntity(StoreDto source);

    StoreDto toStoreDto(Store source);

    List<StoreDto> toListOfStoreDto(Iterable<Store> source);
}
