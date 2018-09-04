//package com.wpt.risk.engine.service;
//
//import com.wpt.risk.dal.dao.MenuMapper;
//import com.wpt.risk.dal.pojo.Menu;
//import com.wpt.risk.dal.utils.HrUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by sang on 2017/12/28.
// */
//@Service
//@Transactional
//public class MenuService {
//    @Autowired
//    MenuMapper menuMapper;
//
//    public List<Menu> getAllMenu(){
//        return menuMapper.getAllMenu();
//    }
//
//    public List<Menu> getMenusByHrId() {
//        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
//    }
//
//    public List<Menu> menuTree() {
//        return menuMapper.menuTree();
//    }
//
//    public List<Long> getMenusByRid(Long rid) {
//        return menuMapper.getMenusByRid(rid);
//    }
//}
