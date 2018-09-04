package com.wpt.risk.dal.pojo;

import com.wpt.risk.base.surpport.DelStatus;

import java.util.Date;

public class Custom {
    private Integer id;

    private Integer personaId;

    private String persona;

    private Integer customCategoryId;

    private String customCategory;

    private String customName;

    private String customField;

    private String content;

    private String values;

    private String comment;

    private DelStatus isDel;

    private Date addedAt;

    private Date modifyAt;

    private String expressionJson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona == null ? null : persona.trim();
    }

    public Integer getCustomCategoryId() {
        return customCategoryId;
    }

    public void setCustomCategoryId(Integer customCategoryId) {
        this.customCategoryId = customCategoryId;
    }

    public String getCustomCategory() {
        return customCategory;
    }

    public void setCustomCategory(String customCategory) {
        this.customCategory = customCategory == null ? null : customCategory.trim();
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField == null ? null : customField.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values == null ? null : values.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public DelStatus getIsDel() {
        return isDel;
    }

    public void setIsDel(DelStatus isDel) {
        this.isDel = isDel;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public String getExpressionJson() {
        return expressionJson;
    }

    public void setExpressionJson(String expressionJson) {
        this.expressionJson = expressionJson == null ? null : expressionJson.trim();
    }

    @Override
    public String toString() {
        return "Custom{" +
                "id=" + id +
                ", personaId=" + personaId +
                ", persona='" + persona + '\'' +
                ", customCategoryId=" + customCategoryId +
                ", customCategory='" + customCategory + '\'' +
                ", customName='" + customName + '\'' +
                ", customField='" + customField + '\'' +
                ", content='" + content + '\'' +
                ", values='" + values + '\'' +
                ", comment='" + comment + '\'' +
                ", isDel=" + isDel +
                ", addedAt=" + addedAt +
                ", modifyAt=" + modifyAt +
                ", expressionJson='" + expressionJson + '\'' +
                '}';
    }

    public static class Builder {
        private Custom obj;

        public Builder() {
            this.obj = new Custom();
        }

        public Builder id(Integer id) {
            obj.id = id;
            return this;
        }

        public Builder personaId(Integer personaId) {
            obj.personaId = personaId;
            return this;
        }

        public Builder persona(String persona) {
            obj.persona = persona;
            return this;
        }

        public Builder customCategoryId(Integer customCategoryId) {
            obj.customCategoryId = customCategoryId;
            return this;
        }

        public Builder customCategory(String customCategory) {
            obj.customCategory = customCategory;
            return this;
        }

        public Builder customName(String customName) {
            obj.customName = customName;
            return this;
        }

        public Builder customField(String customField) {
            obj.customField = customField;
            return this;
        }

        public Builder content(String content) {
            obj.content = content;
            return this;
        }

        public Builder values(String values) {
            obj.values = values;
            return this;
        }

        public Builder comment(String comment) {
            obj.comment = comment;
            return this;
        }

        public Builder isDel(DelStatus isDel) {
            obj.isDel = isDel;
            return this;
        }

        public Builder addedAt(Date addedAt) {
            obj.addedAt = addedAt;
            return this;
        }

        public Builder modifyAt(Date modifyAt) {
            obj.modifyAt = modifyAt;
            return this;
        }

        public Builder expressionJson(String expressionJson) {
            obj.expressionJson = expressionJson;
            return this;
        }

        public Custom build() {
            return this.obj;
        }
    }
}