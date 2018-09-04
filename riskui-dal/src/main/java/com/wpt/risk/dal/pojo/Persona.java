package com.wpt.risk.dal.pojo;

import com.wpt.risk.base.surpport.DelStatus;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {
    private Integer id;

    private String database;

    private String collection;

    private String name;

    private DelStatus isDel;

    private Date addedAt;

    private Date modifyAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database == null ? null : database.trim();
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection == null ? null : collection.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        private Persona obj;

        public Builder() {
            this.obj = new Persona();
        }

        public Builder id(Integer id) {
            obj.id = id;
            return this;
        }

        public Builder database(String database) {
            obj.database = database;
            return this;
        }

        public Builder collection(String collection) {
            obj.collection = collection;
            return this;
        }

        public Builder name(String name) {
            obj.name = name;
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

        public Persona build() {
            return this.obj;
        }
    }
}