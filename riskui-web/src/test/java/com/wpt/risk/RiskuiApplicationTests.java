package com.wpt.risk;

import com.wpt.risk.base.surpport.LogicSymbol;
import com.wpt.risk.base.utils.SeqNoUtil;
import com.wpt.risk.dal.dao.WUserMapper;
import com.wpt.risk.dal.phoenixdao.EventModelMapper;
import com.wpt.risk.dal.pojo.Custom;
import com.wpt.risk.dal.pojo.EventModel;
import com.wpt.risk.engine.dto.ExpressionDTO;
import com.wpt.risk.engine.dto.NewCustomDTO;
import com.wpt.risk.engine.dto.WhenDTO;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.exec.RiskuiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RiskuiApplication.class)
public class RiskuiApplicationTests {

    @Autowired
    private EventModelMapper eventModelMapper;

    @Autowired
    private WUserMapper userMapper;

    @Autowired
    private RequestManager requestManager;

    @Test
    public void testaop() {
        System.out.println(userMapper.selectByUserId("feihm"));
    }

    @Test
    public void testPhoenix() {
        EventModel model = new EventModel();
        model.setUid(35L);
        model.setType("bid");
    }

//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testCategory() {
//        NewCustomDTO dto = mock(NewCustomDTO.class);
        NewCustomDTO dto = new NewCustomDTO();
        dto.setSourceId(1);
        dto.setSource("persona");
        dto.setCustomCategoryId(5);
        dto.setCustomCategoryName("基础信息");
        dto.setLabelName("所在地");
        dto.setValues("杭州、湖州、嘉兴");
        dto.setNotes("所在地");

        List<WhenDTO> whenDTOs = new ArrayList<>();
        List<ExpressionDTO> expressionDTOs = new ArrayList<>();
        WhenDTO whenDTO = new WhenDTO();
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setFirstFieldId(5);
        expressionDTO.setSecondFieldId(1);
        expressionDTO.setProfileFieldId(3);
        expressionDTO.setSymbolId(3);
        expressionDTO.setValues(Arrays.asList("嘉兴"));
        expressionDTOs.add(expressionDTO);

        expressionDTO = new ExpressionDTO();
        expressionDTO.setFirstFieldId(5);
        expressionDTO.setSecondFieldId(1);
        expressionDTO.setProfileFieldId(2);
        expressionDTO.setSymbolId(3);
        expressionDTO.setValues(Arrays.asList("浙江"));
        expressionDTOs.add(expressionDTO);

        whenDTO.setExpressionDTOs(expressionDTOs);
        whenDTO.setResult("杭嘉湖地区");
        whenDTO.setSymbol(LogicSymbol.AND);
        whenDTOs.add(whenDTO);

        dto.setWhenDTOs(whenDTOs);
//        Custom custom = mock(Custom.class);
        Custom custom = new Custom();
        custom.setCustomField(SeqNoUtil.genFiledName("custom", 16));
        requestManager.processCustom(custom, dto);

        System.out.println(custom);
    }
}
