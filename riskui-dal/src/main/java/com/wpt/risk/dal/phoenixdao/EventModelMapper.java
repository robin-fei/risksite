package com.wpt.risk.dal.phoenixdao;

import com.wpt.risk.dal.pojo.EventModel;

import java.util.List;
import java.util.Map;

public interface EventModelMapper {

    List<EventModel> selectByMap(Map<String, Object> param);
}