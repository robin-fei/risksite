package com.wpt.risk.engine.service;

import com.wpt.risk.dal.dao.ExpressionMapper;
import com.wpt.risk.dal.pojo.Expression;
import com.wpt.risk.dal.pojo.ExpressionExample;
import com.wpt.risk.engine.vo.ExpressionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpressionService {

    @Autowired
    private ExpressionMapper expressionMapper;

    public Expression findExpressionById(Integer id) {
        return expressionMapper.selectByPrimaryKey(id);
    }

    public List<ExpressionVo> findAllExpressions(ExpressionExample example) {
        List<Expression> expressions = expressionMapper.selectByExample(example);
        List<ExpressionVo> vos = new ArrayList<>();
        expressions.stream().forEach(item -> {
            ExpressionVo vo = new ExpressionVo();
            vo.setExpressionId(item.getId());
            vo.setExpression(item.getValue());
            vos.add(vo);
        });
        return vos;
    }
}