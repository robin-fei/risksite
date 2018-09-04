package com.wpt.risk.dal.pojo;

import com.wpt.risk.base.surpport.DelStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPersonaIdIsNull() {
            addCriterion("persona_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonaIdIsNotNull() {
            addCriterion("persona_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonaIdEqualTo(Integer value) {
            addCriterion("persona_id =", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdNotEqualTo(Integer value) {
            addCriterion("persona_id <>", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdGreaterThan(Integer value) {
            addCriterion("persona_id >", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("persona_id >=", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdLessThan(Integer value) {
            addCriterion("persona_id <", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdLessThanOrEqualTo(Integer value) {
            addCriterion("persona_id <=", value, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdIn(List<Integer> values) {
            addCriterion("persona_id in", values, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdNotIn(List<Integer> values) {
            addCriterion("persona_id not in", values, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdBetween(Integer value1, Integer value2) {
            addCriterion("persona_id between", value1, value2, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("persona_id not between", value1, value2, "personaId");
            return (Criteria) this;
        }

        public Criteria andPersonaIsNull() {
            addCriterion("persona is null");
            return (Criteria) this;
        }

        public Criteria andPersonaIsNotNull() {
            addCriterion("persona is not null");
            return (Criteria) this;
        }

        public Criteria andPersonaEqualTo(String value) {
            addCriterion("persona =", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaNotEqualTo(String value) {
            addCriterion("persona <>", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaGreaterThan(String value) {
            addCriterion("persona >", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaGreaterThanOrEqualTo(String value) {
            addCriterion("persona >=", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaLessThan(String value) {
            addCriterion("persona <", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaLessThanOrEqualTo(String value) {
            addCriterion("persona <=", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaLike(String value) {
            addCriterion("persona like", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaNotLike(String value) {
            addCriterion("persona not like", value, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaIn(List<String> values) {
            addCriterion("persona in", values, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaNotIn(List<String> values) {
            addCriterion("persona not in", values, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaBetween(String value1, String value2) {
            addCriterion("persona between", value1, value2, "persona");
            return (Criteria) this;
        }

        public Criteria andPersonaNotBetween(String value1, String value2) {
            addCriterion("persona not between", value1, value2, "persona");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdIsNull() {
            addCriterion("custom_category_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdIsNotNull() {
            addCriterion("custom_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdEqualTo(Integer value) {
            addCriterion("custom_category_id =", value, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdNotEqualTo(Integer value) {
            addCriterion("custom_category_id <>", value, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdGreaterThan(Integer value) {
            addCriterion("custom_category_id >", value, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("custom_category_id >=", value, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdLessThan(Integer value) {
            addCriterion("custom_category_id <", value, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("custom_category_id <=", value, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdIn(List<Integer> values) {
            addCriterion("custom_category_id in", values, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdNotIn(List<Integer> values) {
            addCriterion("custom_category_id not in", values, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("custom_category_id between", value1, value2, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("custom_category_id not between", value1, value2, "customCategoryId");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIsNull() {
            addCriterion("custom_category is null");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIsNotNull() {
            addCriterion("custom_category is not null");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryEqualTo(String value) {
            addCriterion("custom_category =", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotEqualTo(String value) {
            addCriterion("custom_category <>", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryGreaterThan(String value) {
            addCriterion("custom_category >", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("custom_category >=", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryLessThan(String value) {
            addCriterion("custom_category <", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryLessThanOrEqualTo(String value) {
            addCriterion("custom_category <=", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryLike(String value) {
            addCriterion("custom_category like", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotLike(String value) {
            addCriterion("custom_category not like", value, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryIn(List<String> values) {
            addCriterion("custom_category in", values, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotIn(List<String> values) {
            addCriterion("custom_category not in", values, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryBetween(String value1, String value2) {
            addCriterion("custom_category between", value1, value2, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomCategoryNotBetween(String value1, String value2) {
            addCriterion("custom_category not between", value1, value2, "customCategory");
            return (Criteria) this;
        }

        public Criteria andCustomNameIsNull() {
            addCriterion("custom_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomNameIsNotNull() {
            addCriterion("custom_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomNameEqualTo(String value) {
            addCriterion("custom_name =", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotEqualTo(String value) {
            addCriterion("custom_name <>", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameGreaterThan(String value) {
            addCriterion("custom_name >", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameGreaterThanOrEqualTo(String value) {
            addCriterion("custom_name >=", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLessThan(String value) {
            addCriterion("custom_name <", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLessThanOrEqualTo(String value) {
            addCriterion("custom_name <=", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameLike(String value) {
            addCriterion("custom_name like", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotLike(String value) {
            addCriterion("custom_name not like", value, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameIn(List<String> values) {
            addCriterion("custom_name in", values, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotIn(List<String> values) {
            addCriterion("custom_name not in", values, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameBetween(String value1, String value2) {
            addCriterion("custom_name between", value1, value2, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomNameNotBetween(String value1, String value2) {
            addCriterion("custom_name not between", value1, value2, "customName");
            return (Criteria) this;
        }

        public Criteria andCustomFieldIsNull() {
            addCriterion("custom_field is null");
            return (Criteria) this;
        }

        public Criteria andCustomFieldIsNotNull() {
            addCriterion("custom_field is not null");
            return (Criteria) this;
        }

        public Criteria andCustomFieldEqualTo(String value) {
            addCriterion("custom_field =", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldNotEqualTo(String value) {
            addCriterion("custom_field <>", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldGreaterThan(String value) {
            addCriterion("custom_field >", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldGreaterThanOrEqualTo(String value) {
            addCriterion("custom_field >=", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldLessThan(String value) {
            addCriterion("custom_field <", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldLessThanOrEqualTo(String value) {
            addCriterion("custom_field <=", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldLike(String value) {
            addCriterion("custom_field like", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldNotLike(String value) {
            addCriterion("custom_field not like", value, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldIn(List<String> values) {
            addCriterion("custom_field in", values, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldNotIn(List<String> values) {
            addCriterion("custom_field not in", values, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldBetween(String value1, String value2) {
            addCriterion("custom_field between", value1, value2, "customField");
            return (Criteria) this;
        }

        public Criteria andCustomFieldNotBetween(String value1, String value2) {
            addCriterion("custom_field not between", value1, value2, "customField");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andValuesIsNull() {
            addCriterion("values is null");
            return (Criteria) this;
        }

        public Criteria andValuesIsNotNull() {
            addCriterion("values is not null");
            return (Criteria) this;
        }

        public Criteria andValuesEqualTo(String value) {
            addCriterion("values =", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesNotEqualTo(String value) {
            addCriterion("values <>", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesGreaterThan(String value) {
            addCriterion("values >", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesGreaterThanOrEqualTo(String value) {
            addCriterion("values >=", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesLessThan(String value) {
            addCriterion("values <", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesLessThanOrEqualTo(String value) {
            addCriterion("values <=", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesLike(String value) {
            addCriterion("values like", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesNotLike(String value) {
            addCriterion("values not like", value, "values");
            return (Criteria) this;
        }

        public Criteria andValuesIn(List<String> values) {
            addCriterion("values in", values, "values");
            return (Criteria) this;
        }

        public Criteria andValuesNotIn(List<String> values) {
            addCriterion("values not in", values, "values");
            return (Criteria) this;
        }

        public Criteria andValuesBetween(String value1, String value2) {
            addCriterion("values between", value1, value2, "values");
            return (Criteria) this;
        }

        public Criteria andValuesNotBetween(String value1, String value2) {
            addCriterion("values not between", value1, value2, "values");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(DelStatus value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(DelStatus value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(DelStatus value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(DelStatus value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(DelStatus value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(DelStatus value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<DelStatus> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<DelStatus> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(DelStatus value1, DelStatus value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(DelStatus value1, DelStatus value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andAddedAtIsNull() {
            addCriterion("added_at is null");
            return (Criteria) this;
        }

        public Criteria andAddedAtIsNotNull() {
            addCriterion("added_at is not null");
            return (Criteria) this;
        }

        public Criteria andAddedAtEqualTo(Date value) {
            addCriterion("added_at =", value, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtNotEqualTo(Date value) {
            addCriterion("added_at <>", value, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtGreaterThan(Date value) {
            addCriterion("added_at >", value, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("added_at >=", value, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtLessThan(Date value) {
            addCriterion("added_at <", value, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtLessThanOrEqualTo(Date value) {
            addCriterion("added_at <=", value, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtIn(List<Date> values) {
            addCriterion("added_at in", values, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtNotIn(List<Date> values) {
            addCriterion("added_at not in", values, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtBetween(Date value1, Date value2) {
            addCriterion("added_at between", value1, value2, "addedAt");
            return (Criteria) this;
        }

        public Criteria andAddedAtNotBetween(Date value1, Date value2) {
            addCriterion("added_at not between", value1, value2, "addedAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtIsNull() {
            addCriterion("modify_at is null");
            return (Criteria) this;
        }

        public Criteria andModifyAtIsNotNull() {
            addCriterion("modify_at is not null");
            return (Criteria) this;
        }

        public Criteria andModifyAtEqualTo(Date value) {
            addCriterion("modify_at =", value, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtNotEqualTo(Date value) {
            addCriterion("modify_at <>", value, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtGreaterThan(Date value) {
            addCriterion("modify_at >", value, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_at >=", value, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtLessThan(Date value) {
            addCriterion("modify_at <", value, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtLessThanOrEqualTo(Date value) {
            addCriterion("modify_at <=", value, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtIn(List<Date> values) {
            addCriterion("modify_at in", values, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtNotIn(List<Date> values) {
            addCriterion("modify_at not in", values, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtBetween(Date value1, Date value2) {
            addCriterion("modify_at between", value1, value2, "modifyAt");
            return (Criteria) this;
        }

        public Criteria andModifyAtNotBetween(Date value1, Date value2) {
            addCriterion("modify_at not between", value1, value2, "modifyAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private CustomExample example;

        protected Criteria(CustomExample example) {
            super();
            this.example = example;
        }

        public CustomExample example() {
            return this.example;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}