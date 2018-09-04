package com.wpt.risk.dal.pojo;

import com.wpt.risk.base.surpport.DelStatus;

import java.io.Serializable;
import java.util.Date;

public class PersonaSecondary implements Serializable {
    private Integer id;

    private Integer persona;

    private Integer category;

    private String field;

    private String name;

    private String comment;

    private DelStatus isDel;

    private Date addedAt;

    private Date modifyAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public static class Builder {
        private PersonaSecondary obj;

        public Builder() {
            this.obj = new PersonaSecondary();
        }

        public Builder id(Integer id) {
            obj.id = id;
            return this;
        }

        public Builder persona(Integer persona) {
            obj.persona = persona;
            return this;
        }

        public Builder category(Integer category) {
            obj.category = category;
            return this;
        }

        public Builder field(String field) {
            obj.field = field;
            return this;
        }

        public Builder name(String name) {
            obj.name = name;
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

        public PersonaSecondary build() {
            return this.obj;
        }
    }
}