package com.palekov.controller;

import com.palekov.dto.StoreDto;
import com.palekov.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController extends AbstractController {
    @Autowired
    StoreService storeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StoreDto> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoreDto getStore(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoreDto createStore(@RequestBody StoreDto storeDto) {
        storeService.createStore(storeDto);
        return storeDto;
    }
}
