package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: Pluto
 * Date: 2025/10/27
 * Description:
 */
@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品ids查询对应的所有套餐ids
     * @param ids
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> ids);
}
