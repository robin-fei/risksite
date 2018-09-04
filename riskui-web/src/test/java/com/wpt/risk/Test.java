package com.wpt.risk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wpt.persona.meta.api.QueryPersona;
import com.wpt.risk.base.surpport.Behavior;
import com.wpt.risk.base.surpport.DelStatus;
import com.wpt.risk.base.surpport.LogicSymbol;
import com.wpt.risk.base.utils.JacksonValueAssignEnumerationSerializer;
import com.wpt.risk.base.utils.ValueAsignEnumeration;
import com.wpt.risk.dal.pojo.PersonaCategory;
import com.wpt.risk.dal.pojo.PersonaSecondary;
import com.wpt.risk.engine.dto.*;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.Mockito.*;

public class Test {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
        String pass = passwordEncoder.encode("root");
        System.out.println(pass);
        System.out.println(pass.length());
        boolean matches = passwordEncoder.matches("root", pass);
        System.out.println(matches);
    }

    @org.junit.Test
    public void testHttp() {
        String requestUrl = "http://localhost:8080/admin/login.jsp";
        String servletPath = "/admin/login.jsp";
        String path = StringUtils.substringBefore(requestUrl, servletPath);
        System.out.println(path);
    }

    @org.junit.Test
    public void testTimestamps() {
        Long i = 1533026453 * 1000L;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(i));
        System.out.println(format);
    }

    @org.junit.Test
    public void testSerializer() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        String json = "{\"uid\":123, \"beginDate\":\"2018-08-07 14:00:00\", \"endDate\":\"2018-08-07 14:00:00\"}";
        EventDTO eventDTO = objectMapper.readValue(json, EventDTO.class);
        System.out.println(eventDTO);

        SimpleModule module = new SimpleModule("JDTPageListJSONModule", new Version(1, 0, 0, null, null, null));
        module.addSerializer(ValueAsignEnumeration.class, new JacksonValueAssignEnumerationSerializer(objectMapper));
        eventDTO.setBeginDate(new Date());
        json = objectMapper.writeValueAsString(eventDTO);
        System.out.println(json);

        Map<String, String> map = new HashMap<>();
        map.put("code", Behavior.BID.codeVal());
        map.put("value", Behavior.BID.strVal());
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        jsonGenerator.writeObject(map);
        System.out.println();

        NewProfileDTO dto = new NewProfileDTO();
        dto.setCnName("xxx");
        dto.setSourceId(1);
        dto.setFamilyId(1);
        dto.setFieldName("xxx");
        dto.setFieldType("xxx");
        dto.setNotes("xxx");
        dto.setSecondFamilyId(1);
        System.out.println(objectMapper.writeValueAsString(dto));

        PersonaCategory category = new PersonaCategory();
        category.setId(5);
        category.setPersona(1);
        category.setComment("society");
        category.setName("基础信息");
        category.setField("xxx");
        category.setIsDel(DelStatus.UN_DEL);
        System.out.println(objectMapper.writeValueAsString(category));

        NewCategoryDTO dto1 = new NewCategoryDTO();
        dto1.setSourceId(1);
        dto1.setNotes("xxx");
        dto1.setCnName("xxx");
        dto1.setFieldName("xxx");
        System.out.println(objectMapper.writeValueAsString(dto1));

        PersonaSecondary secondary = new PersonaSecondary();
        secondary.setId(1);
        secondary.setComment("xxx");
        secondary.setCategory(1);
        secondary.setField("xxx");
        secondary.setIsDel(DelStatus.UN_DEL);
        secondary.setName("xxx");
        secondary.setPersona(1);
        System.out.println(objectMapper.writeValueAsString(secondary));

        NewSecondaryDTO secondaryDTO = new NewSecondaryDTO();
        secondaryDTO.setCnName("xxx");
        secondaryDTO.setFamilyId(1);
        secondaryDTO.setFieldName("xxx");
        secondaryDTO.setNotes("xxx");
        secondaryDTO.setSourceId(1);
        System.out.println(objectMapper.writeValueAsString(secondaryDTO));

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

        System.out.println(objectMapper.writeValueAsString(whenDTOs));
    }


    @org.junit.Test
    public void testMongodb() throws Exception {
//        System.out.println(new Date().getTime() % (1 << 20));
//        System.out.println((1 << 20));
//        String str = "234";
//        System.out.println((Integer)str);
        System.out.println(QueryPersona.getPersonaJson("persona", 1, 1).toString());
    }

    @org.junit.Test
    public void testLocal() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostName());
    }


    @org.junit.Test
    public void testMock() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

        mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);


        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains(argThat(new Matcher() {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            public boolean matches(Object o) {
                return o.equals("element");
            }

            @Override
            public void describeMismatch(Object o, Description description) {

            }

            @Override
            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

            }
        }))).thenReturn(true);

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
//        verify(mockedList).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
//        verify(mockedList).add(argThat(new Matcher() {
//            @Override
//            public void describeTo(Description description) {
//            }
//
//            @Override
//            public boolean matches(Object o) {
//                return true;
//            }
//
//            @Override
//            public void describeMismatch(Object o, Description description) {
//
//            }
//
//            @Override
//            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
//
//            }
//        }));

        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");

        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);
        //using mocks - only mockOne is interacted
        mockOne.add("one");

        //ordinary verification
        verify(mockOne).add("one");

        //verify that method was never called on a mock
        verify(mockOne, never()).add("two");

        //verify that other mocks were not interacted
        verifyZeroInteractions(mockTwo, mockThree);
    }
}