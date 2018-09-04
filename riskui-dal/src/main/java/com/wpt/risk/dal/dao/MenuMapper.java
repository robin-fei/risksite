package com.wpt.risk.dal.dao;

import com.wpt.risk.dal.pojo.Menu;

import java.util.List;


public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
