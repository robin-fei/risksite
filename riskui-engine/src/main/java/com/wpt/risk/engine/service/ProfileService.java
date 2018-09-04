package com.wpt.risk.engine.service;

import com.wpt.risk.base.exception.RecordUsedException;
import com.wpt.risk.base.surpport.DelStatus;
import com.wpt.risk.dal.dao.CustomMapper;
import com.wpt.risk.dal.dao.PersonaProfileMapper;
import com.wpt.risk.dal.pojo.CustomExample;
import com.wpt.risk.dal.pojo.PersonaProfile;
import com.wpt.risk.dal.pojo.PersonaProfileExample;
import com.wpt.risk.engine.dto.EditProfileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    private PersonaProfileMapper proflieMapper;

    @Autowired
    private CustomMapper customMapper;

    public List<EditProfileDTO> findAllProfiles(PersonaProfileExample example) {
        List<PersonaProfile> profiles = proflieMapper.selectByExample(example);
        List<EditProfileDTO> editProfileDTOs = new ArrayList<>();
        profiles.forEach(p -> {
            EditProfileDTO o = new EditProfileDTO();
            o.setId(p.getId());
            o.setSecondFamilyId(p.getSecondary());
            o.setFamilyId(p.getCategory());
            o.setNotes(p.getComment());
            o.setSourceId(p.getPersona());
            o.setCnName(p.getName());
            o.setFieldName(p.getField());
            o.setFieldType(p.getType());
            o.setStatus(p.getIsDel());
            editProfileDTOs.add(o);
        });
        return editProfileDTOs;
    }

    public PersonaProfile findProfileById(Integer id) {
        return proflieMapper.selectByPrimaryKey(id);
    }

    public int delProfileById(Integer id) {
        PersonaProfile dbProfile = proflieMapper.selectByPrimaryKey(id);
        String profileField = dbProfile.getField();
        try {
            CustomExample example = new CustomExample().createCriteria().andContentLike("%" + profileField + "%").example();
            int cnt = customMapper.countByExample(example);
            if (cnt > 0) {
                throw new RecordUsedException();
            }
        } catch (RecordUsedException e) {
            throw e;
        }

        PersonaProfile proflie = new PersonaProfile();
        proflie.setId(id);
        proflie.setIsDel(DelStatus.DEL);
        int cnt = proflieMapper.updateByPrimaryKeySelective(proflie);
        logger.debug("logic delete item, updated, " + cnt);
        return cnt;
    }

    public int addProflie(PersonaProfile proflie) {
        int cnt = proflieMapper.insertSelective(proflie);
        logger.debug("add item, " + proflie + ",inserted, " + cnt);
        return cnt;
    }

    public int editProflie(PersonaProfile proflie) {
        int cnt = proflieMapper.updateByPrimaryKeySelective(proflie);
        logger.debug("edit item, " + proflie + ",updated, " + cnt);
        return cnt;
    }
}