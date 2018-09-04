package com.wpt.risk.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.pagehelper.PageInfo;

import java.text.SimpleDateFormat;

public class JDTPageListJsonMapper extends ObjectMapper {

    public JDTPageListJsonMapper() {
        SimpleModule module = new SimpleModule("JDTPageListJSONModule", new Version(1, 0, 0, null, null, null));
        module.addSerializer(PageInfo.class, new JDTPageListSerializer(this));
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        registerModule(module);
    }
}
