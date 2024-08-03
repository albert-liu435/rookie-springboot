//package com.rookie.bigdata.controller;
//
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.Assert.*;
//
///**
// * @ClassName StudentControllerTest
// * @Description StudentControllerTest
// * @Author rookie
// * @Date 2021/6/17 14:27
// * @Version 1.0
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
////@ActiveProfiles("dev")
//public class StudentControllerTest {
//    /**
//     * 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
//     */
//    private MockMvc mockMvc;
//
//    /**
//     * 注入WebApplicationCon
//     .text
//     */
//    @Autowired
//    private WebApplicationContext wac;
//
//    /**
//     * 类加载前
//     */
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//    }
//
//    /**
//     * 类加载后
//     */
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//    }
//
//    /**
//     * 实例创建前
//     */
//    @Before
//    public void setUp() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//
//    /**
//     * 实例创建后
//     */
//    @After
//    public void tearDown() throws Exception {
//
//    }
//    @Test
//    public void serialization() throws Exception{
//        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/serialization")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println(result.getResponse().getContentAsString());
//    }
//
//    @Test
//    public void deserialization() throws Exception{
//
//        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.put("/deserialization")
//                .contentType(MediaType.APPLICATION_JSON).content("{\"id\":100,\"studentNo\":10,\"name\":\"zhagnsan\",\"age\":23,\"birthDate\":\"Jun 17, 2021 2:30:51 PM\"}\n"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//
//        System.out.println(result.getResponse().getContentAsString());
//    }
//}