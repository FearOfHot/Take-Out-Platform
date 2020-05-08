package com.clc.springboot.demo1.service.impl;

import com.clc.springboot.demo1.facade.entities.Dish;
import com.clc.springboot.demo1.facade.so.DishSo;
import com.clc.springboot.demo1.facade.vo.DishVo;
import com.clc.springboot.demo1.mapper.DishMapper;
import com.clc.springboot.demo1.service.DishService;
import com.clc.springboot.demo1.support.utilities.ParamUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Resource
    private DishMapper dishMapper;

    @Override
    @Transactional
    public List<DishVo> findAllDish() {
        return dishMapper.findAllDish();
    }

    @Override
    @Transactional
    public Boolean saveDish(DishSo dishSo) {
        //创建一个新的菜品
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishSo, dish);
        if (ParamUtil.isNotEmpty(dishSo.getId())) {
            //表示编辑菜品
            dishMapper.updateByPrimaryKeySelective(dish);
        } else {
            //表示新建菜品
            dishMapper.insertSelective(dish);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteDish(DishSo dishSo) {
        dishMapper.deleteByPrimaryKey(dishSo.getId());
        return true;
    }
}
