package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据菜品id查询对应口味
     * @param id
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{id}")
    List<DishFlavor> getById(Long id);

    /**
     * 根据菜品id删除对应口味数据
     * @param id
     */
    @Delete("delete from dish_flavor where dish_id = #{id}")
    void deleteByDishId(Long id);

    /**
     * 根据菜品ids批量删除对应口味数据
     * @param ids
     */
    void deleteByDishIds(List<Long> ids);
}
