package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: Pluto
 * Date: 2025/10/24
 * Description:
 */
@Mapper
public interface DishFlavorsMapper {

    /**
     * 插入口味
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
}
