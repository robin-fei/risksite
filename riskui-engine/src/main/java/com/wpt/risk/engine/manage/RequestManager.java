package com.wpt.risk.engine.manage;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpt.risk.base.surpport.DelStatus;
import com.wpt.risk.base.utils.SeqNoUtil;
import com.wpt.risk.dal.pojo.*;
import com.wpt.risk.engine.dto.*;
import com.wpt.risk.engine.service.*;
import com.wpt.risk.engine.vo.CustomCategoryVo;
import com.wpt.risk.engine.vo.EventVo;
import com.wpt.risk.engine.vo.ExpressionVo;
import com.wpt.risk.engine.vo.PersonaVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class RequestManager {

    public static final Logger logger = LoggerFactory.getLogger(RequestManager.class);

    @Autowired
    private EventModelService eventModelService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CustomService customService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SecondaryService secondaryService;

    @Autowired
    private ExpressionService expressionService;

    @Autowired
    private CustomCategoryService customCategoryService;

    public PageInfo queryEVents(EventDTO dto) {

        Page page = buildPageBounds(dto);

        Date beginDate = dto.getBeginDate();
        Date endDate = dto.getEndDate();
        Long std = null;
        Long etd = null;
        if (beginDate != null) {
            std = beginDate.getTime() / 1000;
        }
        if (endDate != null) {
            etd = endDate.getTime() / 1000;
        }

        List<EventVo> eventModels = eventModelService.findEvents(dto.getUid(), dto.getBehavior(), std, etd);
        page.clear();
        page.addAll(eventModels);
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    private <T extends BaseDTO> Page buildPageBounds(T dto) {
        Integer curPage = dto.getCurPage() == null ? 1 : dto.getCurPage();
        Integer pageSize = dto.getPageSize() == null ? 10 : dto.getPageSize();
        return PageHelper.startPage(curPage, pageSize, true);
    }


    public PageInfo getAllProfiles(SearchDTO dto) {
        PersonaProfileExample example = new PersonaProfileExample();
        example.setOrderByClause("modify_at desc");
        PersonaProfileExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(dto.getFieldName())) {
            criteria.andFieldEqualTo(dto.getFieldName());
        }
        Page page = buildPageBounds(dto);
        List<EditProfileDTO> dtos = profileService.findAllProfiles(criteria.example());
        page.clear();
        page.addAll(dtos);
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }


    public PersonaProfile getProfileById(Integer id) {
        return profileService.findProfileById(id);
    }

    public int logicDelProfile(Integer id) {
        return profileService.delProfileById(id);
    }

    public int addProfile(NewProfileDTO dto) {
        PersonaProfile profile = new PersonaProfile();
        processProfile(profile, dto);

        return profileService.addProflie(profile);
    }


    public int editProfile(EditProfileDTO dto) {
        PersonaProfile profile = new PersonaProfile();
        profile.setId(dto.getId());
        profile.setIsDel(dto.getStatus());
        processProfile(profile, dto);

        return profileService.editProflie(profile);
    }


    private <T extends NewProfileDTO> void processProfile(PersonaProfile profile, T dto) {
        profile.setPersona(dto.getSourceId());
        profile.setCategory(dto.getFamilyId());
        profile.setSecondary(dto.getSecondFamilyId());
        profile.setField(dto.getFieldName());
        profile.setName(dto.getCnName());
        profile.setType(dto.getFieldType());
        profile.setComment(dto.getNotes());
    }


    public PageInfo getAllCustoms(SearchDTO dto) {
        CustomExample example = new CustomExample();
        example.setOrderByClause("modify_at desc");
        CustomExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(dto.getFieldName())) {
            criteria.andCustomFieldEqualTo(dto.getFieldName());
        }

        Page page = buildPageBounds(dto);
        List<EditCustomDTO> customs = customService.findAllCustoms(criteria.example());
        page.clear();
        page.addAll(customs);
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    public Custom getCustomById(Integer id) {
        return customService.findCustomById(id);
    }


    public int logicDelCustom(Integer id) {
        return customService.delCustomById(id);
    }

    public List<PersonaVo> getAllPersonas() {
        PersonaExample example = new PersonaExample().createCriteria().andIsDelEqualTo(DelStatus.UN_DEL).example();
        example.setOrderByClause("modify_at desc");
        List<PersonaVo> personas = personaService.findAllPersonas(example);
        return personas;
    }

    public List<ExpressionVo> getAllExpressions() {
        ExpressionExample example = new ExpressionExample().createCriteria().andIsDelEqualTo(DelStatus.UN_DEL).example();
        example.setOrderByClause("modify_at desc");
        List<ExpressionVo> expressions = expressionService.findAllExpressions(example);
        return expressions;
    }

    public List<CustomCategoryVo> getAllCustomCategorys() {
        CustomCategoryExample example = new CustomCategoryExample().createCriteria().andIsDelEqualTo(DelStatus.UN_DEL).example();
        example.setOrderByClause("modify_at desc");
        List<CustomCategoryVo> customCategorys = customCategoryService.findAllCustomCategorys(example);
        return customCategorys;
    }

    public int addCustomCategory(String name) {
        CustomCategory customCategory = new CustomCategory();
        customCategory.setName(name);
        int cnt = customCategoryService.addCustomCategory(customCategory);
        return customCategory.getId();
    }

    public int addCustom(NewCustomDTO dto) {
        Custom custom = new Custom();
        custom.setCustomField(SeqNoUtil.genFiledName("custom", 16));
        processCustom(custom, dto);
        return customService.addCustom(custom);
    }


    public int editCustom(EditCustomDTO dto) {
        Custom custom = new Custom();
        custom.setId(dto.getId());
        custom.setIsDel(dto.getStatus());
        processCustom(custom, dto);
        return customService.editCustom(custom);
    }

    public <T extends NewCustomDTO> void processCustom(Custom custom, T dto) {
        custom.setPersonaId(dto.getSourceId());
        custom.setPersona(dto.getSource());
        custom.setComment(dto.getNotes());
        custom.setCustomCategoryId(dto.getCustomCategoryId());
        custom.setCustomCategory(dto.getCustomCategoryName());
        custom.setCustomName(dto.getLabelName());
        custom.setValues(dto.getValues());
        List<WhenDTO> whenDTOs = dto.getWhenDTOs();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            custom.setExpressionJson(objectMapper.writeValueAsString(whenDTOs));
        } catch (JsonProcessingException e) {
            logger.error("json2String failed", e);
        }

        String begin = "case";
        String content = " when {0} then {1}";
        String end = " end as ";
        StringBuilder whenBuilder = new StringBuilder();
        for (WhenDTO whenDTO : whenDTOs) {
            List<ExpressionDTO> expressionDTOs = whenDTO.getExpressionDTOs();
            String logicOperator = whenDTO.getSymbol().codeVal();
            String result = "'" + whenDTO.getResult() + "'";
            StringBuilder logicClause = new StringBuilder();
            Iterator<ExpressionDTO> expressionDTOIterator = expressionDTOs.iterator();
            while (expressionDTOIterator.hasNext()) {
                ExpressionDTO expressionDTO = expressionDTOIterator.next();
                Expression expression = expressionService.findExpressionById(expressionDTO.getSymbolId());
                PersonaCategory category = categoryService.findCategoryById(expressionDTO.getFirstFieldId());
                PersonaSecondary secondary = secondaryService.findSecondaryById(expressionDTO.getSecondFieldId());
                PersonaProfile profile = profileService.findProfileById(expressionDTO.getProfileFieldId());
                String str = category.getField() + "." + secondary.getField() + "." + profile.getField();
                if ("直接展示".equals(expression.getValue())) {
                    logicClause.append("1=1");
                    result = str;
                    break;
                } else {
                    List<String> params = new ArrayList<>();
                    params.add(str);
                    params.addAll(expressionDTO.getValues());
                    str = String.format(expression.getExpression(), params.toArray(new String[0]));
                    logicClause.append(str);
                    if (expressionDTOIterator.hasNext()) {
                        logicClause.append(" ").append(logicOperator).append(" ");
                    }
                }
            }

            whenBuilder.append(MessageFormat.format(content, logicClause.toString(), result));
        }

        custom.setContent(begin + whenBuilder.toString() + end);
    }


    public int logicDelSecondary(Integer id) {
        return secondaryService.delSecondaryById(id);
    }


    public PersonaSecondary getSecondaryById(Integer id) {
        return secondaryService.findSecondaryById(id);
    }

    public PageInfo getAllSecondarys(SearchDTO dto) {
        PersonaSecondaryExample example = new PersonaSecondaryExample();
        example.setOrderByClause("modify_at desc");
        PersonaSecondaryExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(dto.getFieldName())) {
            criteria.andFieldEqualTo(dto.getFieldName());
        }
        Page page = buildPageBounds(dto);
        List<EditSecondaryDTO> dtos = secondaryService.findAllSecondarys(criteria.example());
        page.clear();
        page.addAll(dtos);
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }


    public int addSecondary(NewSecondaryDTO dto) {
        PersonaSecondary secondary = new PersonaSecondary();
        processSecondary(secondary, dto);

        return secondaryService.addSecondary(secondary);
    }


    public int editSecondary(EditSecondaryDTO dto) {
        PersonaSecondary secondary = new PersonaSecondary();
        secondary.setId(dto.getId());
        secondary.setIsDel(dto.getStatus());
        processSecondary(secondary, dto);

        return secondaryService.editSecondary(secondary);
    }


    private <T extends NewSecondaryDTO> void processSecondary(PersonaSecondary secondary, T dto) {
        secondary.setPersona(dto.getSourceId());
        secondary.setCategory(dto.getFamilyId());
        secondary.setName(dto.getCnName());
        secondary.setField(dto.getFieldName());
        secondary.setComment(dto.getNotes());
    }

    public int logicDelCategory(Integer id) {
        return categoryService.delCategoryById(id);
    }

    public PersonaCategory getCategoryById(Integer id) {
        return categoryService.findCategoryById(id);
    }

    public PageInfo getAllCategorys(SearchDTO dto) {
        PersonaCategoryExample example = new PersonaCategoryExample();
        example.setOrderByClause("modify_at desc");
        PersonaCategoryExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(dto.getFieldName())) {
            criteria.andFieldEqualTo(dto.getFieldName());
        }
        Page page = buildPageBounds(dto);
        List<EditCategoryDTO> dtos = categoryService.findAllCategorys(criteria.example());
        page.clear();
        page.addAll(dtos);
        PageInfo pageInfo = new PageInfo(page);
        return pageInfo;
    }

    public int addCategory(NewCategoryDTO dto) {
        PersonaCategory category = new PersonaCategory();
        processCategory(category, dto);

        return categoryService.addCategory(category);
    }


    public int editCategory(EditCategoryDTO dto) {
        PersonaCategory category = new PersonaCategory();
        category.setId(dto.getId());
        category.setIsDel(dto.getStatus());
        processCategory(category, dto);

        return categoryService.editCategory(category);
    }


    private <T extends NewCategoryDTO> void processCategory(PersonaCategory category, T dto) {
        category.setPersona(dto.getSourceId());
        category.setName(dto.getCnName());
        category.setField(dto.getFieldName());
        category.setComment(dto.getNotes());
    }
}