package com.wpt.risk.base.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ValueAssignedEnumTypeHandler<T, E extends ValueAsignEnumeration<T, E>> extends BaseTypeHandler<E> {

    private final E[] enums;
    private Class<E> type;

    public ValueAssignedEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        T codeVal = parameter.codeVal();
        if (codeVal instanceof String) {
            ps.setString(i, (String) codeVal);
        } else {
            ps.setInt(i, (Integer) codeVal);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String i = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        }
        return getInstance(i);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String i = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        }
        return getInstance(i);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String i = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        }
        return getInstance(i);
    }


    private E getInstance(String i) {
        for (E e : enums) {
            T codeVal = e.codeVal();
            if (codeVal instanceof String) {
                if (codeVal.equals(i)) {
                    return e;
                }
            } else {
                if (codeVal == Integer.valueOf(i)) {
                    return e;
                }
            }
        }
        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by code value.");
    }

}
