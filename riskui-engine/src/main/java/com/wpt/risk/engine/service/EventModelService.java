package com.wpt.risk.engine.service;

import com.wpt.risk.base.surpport.Behavior;
import com.wpt.risk.base.surpport.CorrectStatus;
import com.wpt.risk.base.surpport.PayStatus;
import com.wpt.risk.base.surpport.ResultStatus;
import com.wpt.risk.dal.phoenixdao.EventModelMapper;
import com.wpt.risk.dal.pojo.EventModel;
import com.wpt.risk.engine.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventModelService {

    @Autowired
    private EventModelMapper eventModelMapper;

    public List<EventVo> findEvents(Long uid, Behavior behavior, Long std, Long etd) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("behavior", behavior);
        map.put("std", std);
        map.put("etd", etd);
        List<EventModel> models = eventModelMapper.selectByMap(map);
        final List<EventVo> eventVos = new ArrayList<>();
        models.forEach(item -> {
            EventVo vo = new EventVo();
            vo.setBehavior(Behavior.getByCode(item.getType()));
            vo.setCorrectStatus(CorrectStatus.getByCode(String.valueOf(item.getIsCorrect())));
            vo.setPayStatus(PayStatus.getByCode(item.getStatus()));
            vo.setResultStatus(ResultStatus.getByCode(String.valueOf(item.getResult())));
            vo.setItemUrl(item.getGoodUri());
            vo.setPercentage(item.getPercent());
            vo.setTime(item.getTime());
            vo.setUserId(item.getUid());
            eventVos.add(vo);
        });

        return eventVos;
    }
}