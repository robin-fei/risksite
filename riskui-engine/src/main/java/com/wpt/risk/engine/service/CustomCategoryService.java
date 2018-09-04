package com.wpt.risk.engine.service;

import com.wpt.risk.dal.dao.CustomCategoryMapper;
import com.wpt.risk.dal.pojo.CustomCategory;
import com.wpt.risk.dal.pojo.CustomCategoryExample;
import com.wpt.risk.engine.vo.CustomCategoryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CustomCategoryService.class);

    @Autowired
    private CustomCategoryMapper customCategoryMapper;

    public CustomCategory findCustomCategoryById(Integer id) {
        return customCategoryMapper.selectByPrimaryKey(id);
    }

    public List<CustomCategoryVo> findAllCustomCategorys(CustomCategoryExample example) {
        List<CustomCategory> categories = customCategoryMapper.selectByExample(example);
        List<CustomCategoryVo> vos = new ArrayList<>();
        categories.stream().forEach(item -> {
            CustomCategoryVo vo = new CustomCategoryVo();
            vo.setCustomCategoryId(item.getId());
            vo.setCustomCategory(item.getName());
            vos.add(vo);
        });
        return vos;
    }

    public int addCustomCategory(CustomCategory customCategory) {
        int cnt = customCategoryMapper.insertSelective(customCategory);
        logger.debug("add item, " + customCategory + ",updated, " + cnt);
        return cnt;
    }
}