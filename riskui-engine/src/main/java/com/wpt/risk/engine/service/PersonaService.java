package com.wpt.risk.engine.service;

import com.wpt.risk.base.surpport.DelStatus;
import com.wpt.risk.dal.dao.PersonaMapper;
import com.wpt.risk.dal.pojo.Persona;
import com.wpt.risk.dal.pojo.PersonaExample;
import com.wpt.risk.engine.vo.PersonaVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    private static final Logger logger = LoggerFactory.getLogger(PersonaService.class);

    @Autowired
    private PersonaMapper personaMapper;


    public List<PersonaVo> findAllPersonas(PersonaExample example) {
        List<Persona> personas = personaMapper.selectByExample(example);
        List<PersonaVo> vos = new ArrayList<>();
        personas.stream().forEach(item -> {
            PersonaVo vo = new PersonaVo();
            vo.setSourceId(item.getId());
            vo.setSource(item.getCollection());
            vo.setCnSource(item.getName());
            vos.add(vo);
        });
        return vos;
    }

    public Persona findProfileById(Integer id) {
        return personaMapper.selectByPrimaryKey(id);
    }

    public int delPersonaById(Integer id) {
        Persona persona = new Persona();
        persona.setId(id);
        persona.setIsDel(DelStatus.DEL);
        int cnt = personaMapper.updateByPrimaryKeySelective(persona);
        logger.debug("logic delete item, updated, " + cnt);
        return cnt;
    }

    public int addPersona(Persona persona) {
        int cnt = personaMapper.insertSelective(persona);
        logger.debug("add item, " + persona + ",updated, " + cnt);
        return cnt;
    }

    public int editPersona(Persona persona) {
        int cnt = personaMapper.updateByPrimaryKeySelective(persona);
        logger.debug("edit item, " + persona + ",updated, " + cnt);
        return cnt;
    }
}