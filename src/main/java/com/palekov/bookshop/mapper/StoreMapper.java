package com.palekov.bookshop.mapper;

import com.palekov.bookshop.dto.StoreDto;
import com.palekov.bookshop.model.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    Store toStoreEntity(StoreDto source);

    StoreDto toStoreDto(Store source);

    List<StoreDto> toListOfStoreDto(Iterable<Store> source);
}
