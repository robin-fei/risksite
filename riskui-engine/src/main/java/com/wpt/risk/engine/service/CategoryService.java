package com.wpt.risk.engine.service;

import com.wpt.risk.base.exception.RecordUsedException;
import com.wpt.risk.base.surpport.DelStatus;
import com.wpt.risk.dal.dao.PersonaCategoryMapper;
import com.wpt.risk.dal.dao.PersonaSecondaryMapper;
import com.wpt.risk.dal.pojo.PersonaCategory;
import com.wpt.risk.dal.pojo.PersonaCategoryExample;
import com.wpt.risk.dal.pojo.PersonaSecondaryExample;
import com.wpt.risk.engine.dto.EditCategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private PersonaCategoryMapper categoryMapper;

    @Autowired
    private PersonaSecondaryMapper secondaryMapper;


    public List<EditCategoryDTO> findAllCategorys(PersonaCategoryExample example) {
        List<PersonaCategory> categories = categoryMapper.selectByExample(example);
        List<EditCategoryDTO> editCategoryDTOs = new ArrayList<>();
        categories.stream().forEach(item -> {
            EditCategoryDTO dto = new EditCategoryDTO();
            dto.setId(item.getId());
            dto.setFieldName(item.getField());
            dto.setCnName(item.getName());
            dto.setNotes(item.getComment());
            dto.setSourceId(item.getPersona());
            dto.setStatus(item.getIsDel());
            editCategoryDTOs.add(dto);
        });

        return editCategoryDTOs;
    }

    public PersonaCategory findCategoryById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public int delCategoryById(Integer id) {
        try {
            PersonaSecondaryExample example = new PersonaSecondaryExample().createCriteria().andCategoryEqualTo(id).example();
            int cnt = secondaryMapper.countByExample(example);
            if (cnt > 0) {
                throw new RecordUsedException();
            }
        } catch (RecordUsedException e) {
            throw e;
        }

        PersonaCategory personaCategory = new PersonaCategory();
        personaCategory.setId(id);
        personaCategory.setIsDel(DelStatus.DEL);
        int cnt = categoryMapper.updateByPrimaryKeySelective(personaCategory);
        logger.debug("logic delete item, updated, " + cnt);
        return cnt;
    }

    public int addCategory(PersonaCategory personaCategory) {
        int cnt = categoryMapper.insertSelective(personaCategory);
        logger.debug("add item, " + personaCategory + ",updated, " + cnt);
        return cnt;
    }

    public int editCategory(PersonaCategory personaCategory) {
        int cnt = categoryMapper.updateByPrimaryKeySelective(personaCategory);
        logger.debug("edit item, " + personaCategory + ",updated, " + cnt);
        return cnt;
    }
}