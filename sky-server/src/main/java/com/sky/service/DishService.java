package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * Author: Pluto
 * Date: 2025/10/23
 * Description:
 */
public interface DishService {

    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);
}
