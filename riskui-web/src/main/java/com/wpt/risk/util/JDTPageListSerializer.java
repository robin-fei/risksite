package com.wpt.risk.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JDTPageListSerializer extends JsonSerializer<PageInfo> {

    ObjectMapper mapper;

    public JDTPageListSerializer() {
        this.mapper = new ObjectMapper();
    }

    public JDTPageListSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void serialize(PageInfo value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        HashMap map = new HashMap();
        map.put("totalCount", Long.valueOf(value.getTotal()));
        map.put("totalPages", Integer.valueOf(value.getPages()));
        map.put("page", Integer.valueOf(value.getPageNum()));
        map.put("limit", Integer.valueOf(value.getSize()));
        map.put("items", new ArrayList(value.getList()));
        map.put("startRow", Integer.valueOf(value.getStartRow()));
        map.put("endRow", Integer.valueOf(value.getEndRow()));
        map.put("prePage", Integer.valueOf(value.getPrePage()));
        map.put("nextPage", Integer.valueOf(value.getNextPage()));
        map.put("firstPage", Integer.valueOf(value.getFirstPage()));
        map.put("lastPage", Integer.valueOf(value.getLastPage()));
        map.put("isFirstPage", Boolean.valueOf(value.isIsFirstPage()));
        map.put("hasNextPage", Boolean.valueOf(value.isHasNextPage()));
        map.put("hasPrePage", Boolean.valueOf(value.isHasNextPage()));
        map.put("isLastPage", Boolean.valueOf(value.isIsLastPage()));
        map.put("navigatePages", Integer.valueOf(value.getNavigatePages()));
        map.put("navigatepageNums", value.getNavigatepageNums());
        this.mapper.writeValue(jgen, map);
    }
}