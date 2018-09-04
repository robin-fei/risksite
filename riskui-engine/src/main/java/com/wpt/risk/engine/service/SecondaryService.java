package com.wpt.risk.engine.service;

import com.wpt.risk.base.exception.RecordUsedException;
import com.wpt.risk.base.surpport.DelStatus;
import com.wpt.risk.dal.dao.PersonaProfileMapper;
import com.wpt.risk.dal.dao.PersonaSecondaryMapper;
import com.wpt.risk.dal.pojo.PersonaProfileExample;
import com.wpt.risk.dal.pojo.PersonaSecondary;
import com.wpt.risk.dal.pojo.PersonaSecondaryExample;
import com.wpt.risk.engine.dto.EditSecondaryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecondaryService {

    private static final Logger logger = LoggerFactory.getLogger(SecondaryService.class);

    @Autowired
    private PersonaSecondaryMapper personaSecondaryMapper;

    @Autowired
    private PersonaProfileMapper profileMapper;


    public List<EditSecondaryDTO> findAllSecondarys(PersonaSecondaryExample example) {
        List<PersonaSecondary> secondaries = personaSecondaryMapper.selectByExample(example);
        List<EditSecondaryDTO> editSecondaryDTOs = new ArrayList<>();
        secondaries.stream().forEach(item -> {
            EditSecondaryDTO dto = new EditSecondaryDTO();
            dto.setId(item.getId());
            dto.setSourceId(item.getPersona());
            dto.setFamilyId(item.getCategory());
            dto.setNotes(item.getComment());
            dto.setCnName(item.getName());
            dto.setFieldName(item.getField());
            dto.setStatus(item.getIsDel());
            editSecondaryDTOs.add(dto);
        });

        return editSecondaryDTOs;
    }

    public PersonaSecondary findSecondaryById(Integer id) {
        return personaSecondaryMapper.selectByPrimaryKey(id);
    }

    public int delSecondaryById(Integer id) {
        try {
            PersonaProfileExample example = new PersonaProfileExample().createCriteria().andSecondaryEqualTo(id).example();
            int cnt = profileMapper.countByExample(example);
            if (cnt > 0) {
                throw new RecordUsedException();
            }
        } catch (RecordUsedException e) {
            throw e;
        }

        PersonaSecondary personaSecondary = new PersonaSecondary();
        personaSecondary.setId(id);
        personaSecondary.setIsDel(DelStatus.DEL);
        int cnt = personaSecondaryMapper.updateByPrimaryKeySelective(personaSecondary);
        logger.debug("logic delete item, updated, " + cnt);
        return cnt;
    }

    public int addSecondary(PersonaSecondary personaSecondary) {
        int cnt = personaSecondaryMapper.insertSelective(personaSecondary);
        logger.debug("add item, " + personaSecondary + ",updated, " + cnt);
        return cnt;
    }

    public int editSecondary(PersonaSecondary personaSecondary) {
        int cnt = personaSecondaryMapper.updateByPrimaryKeySelective(personaSecondary);
        logger.debug("edit item, " + personaSecondary + ",updated, " + cnt);
        return cnt;
    }
}