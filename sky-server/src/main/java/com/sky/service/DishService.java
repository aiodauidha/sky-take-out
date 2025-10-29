package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

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

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据菜品id查询菜品详细信息
     * @param id
     * @return
     */
    DishVO getByIdWithFlavor(Long id);

    /**
     * 修改菜品信息
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> getByCategoryId(Long categoryId);

    /**
     * 菜品起售、停售
     * @param id
     * @param status
     */
    void startOrStop(Long id, Integer status);
}
