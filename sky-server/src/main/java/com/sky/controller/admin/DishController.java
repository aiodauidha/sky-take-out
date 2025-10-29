package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Pluto
 * Date: 2025/10/23
 * Description:
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 新增菜品
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增菜品")
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品{}", dishDTO.toString());
        dishService.saveWithFlavor(dishDTO);

        return Result.success();
    }

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("菜品分页查询{}", dishPageQueryDTO.toString());
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 菜品批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("菜品批量删除")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("菜品批量删除{}", ids.toString());
        dishService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据菜品id查询菜品详细信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据菜品id查询菜品详细信息")
    public Result<DishVO> getById(@PathVariable Long id) {
        log.info("根据菜品id查询菜品详细信息{}", id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    /**
     * 修改菜品信息
     * @param dishDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改菜品信息")
    public Result update(@RequestBody DishDTO dishDTO) {
        log.info("修改菜品信息{}", dishDTO.toString());
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<Dish>> getByCategoryId(@RequestParam Long categoryId) {
        log.info("根据分类id查询菜品{}", categoryId);
        List<Dish> dishList = dishService.getByCategoryId(categoryId);
        return Result.success(dishList);
    }

    /**
     * 菜品起售、停售
     * @param id
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("菜品起售、停售")
    public Result startOrStop(@RequestParam Long id, @PathVariable Integer status) {
        log.info("菜品起售、停售, dishId{}, status{}", id, status);
        dishService.startOrStop(id, status);
        return Result.success();
    }

}
