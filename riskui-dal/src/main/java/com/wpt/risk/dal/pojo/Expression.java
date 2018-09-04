package com.wpt.risk.dal.pojo;

import com.wpt.risk.base.surpport.DelStatus;

import java.util.Date;

public class Expression {
    private Integer id;

    private String type;

    private String value;

    private String expression;

    private DelStatus isDel;

    private Date addedAt;

    private Date modifyAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression == null ? null : expression.trim();
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
        private Expression obj;

        public Builder() {
            this.obj = new Expression();
        }

        public Builder id(Integer id) {
            obj.id = id;
            return this;
        }

        public Builder type(String type) {
            obj.type = type;
            return this;
        }

        public Builder value(String value) {
            obj.value = value;
            return this;
        }

        public Builder expression(String expression) {
            obj.expression = expression;
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

        public Expression build() {
            return this.obj;
        }
    }
}