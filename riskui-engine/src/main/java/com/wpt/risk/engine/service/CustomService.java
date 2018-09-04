package com.wpt.risk.engine.service;

import com.wpt.risk.base.surpport.DelStatus;
import com.wpt.risk.dal.dao.CustomMapper;
import com.wpt.risk.dal.pojo.Custom;
import com.wpt.risk.dal.pojo.CustomExample;
import com.wpt.risk.engine.dto.EditCustomDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomService {

    private static final Logger logger = LoggerFactory.getLogger(CustomService.class);

    @Autowired
    private CustomMapper customMapper;

    public List<EditCustomDTO> findAllCustoms(CustomExample example) {
        List<Custom> customs = customMapper.selectByExample(example);
        List<EditCustomDTO> editCustomDTOs = new ArrayList<>();
        customs.stream().forEach(item -> {
            EditCustomDTO dto = new EditCustomDTO();
            dto.setId(item.getId());
            dto.setSourceId(item.getPersonaId());
            dto.setSource(item.getPersona());
            dto.setCustomCategoryId(item.getCustomCategoryId());
            dto.setCustomCategoryName(item.getCustomCategory());
            dto.setLabelName(item.getCustomName());
            dto.setValues(item.getValues());
            dto.setLabelField(item.getCustomField());
            dto.setCaseClause(item.getContent());
            dto.setStatus(item.getIsDel());
            dto.setExpJson(item.getExpressionJson());
            editCustomDTOs.add(dto);
        });
        return editCustomDTOs;
    }

    public Custom findCustomById(Integer id) {
        return customMapper.selectByPrimaryKey(id);
    }

    public int delCustomById(Integer id) {
        Custom custom = new Custom();
        custom.setId(id);
        custom.setIsDel(DelStatus.DEL);
        int cnt = customMapper.updateByPrimaryKeySelective(custom);
        logger.debug("logic delete item, updated, " + cnt);
        return cnt;
    }

    public int addCustom(Custom custom) {
        int cnt = customMapper.insertSelective(custom);
        logger.debug("add item, " + custom + ",inserted, " + cnt);
        return cnt;
    }

    public int editCustom(Custom custom) {
        int cnt = customMapper.updateByPrimaryKeySelective(custom);
        logger.debug("edit item, " + custom + ",updated, " + cnt);
        return cnt;
    }
}