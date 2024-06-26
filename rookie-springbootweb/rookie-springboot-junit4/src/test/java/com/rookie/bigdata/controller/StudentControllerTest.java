//package com.rookie.bigdata.controller;
//
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
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
// * @Date 2021/6/18 17:40
// * @Version 1.0
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@ActiveProfiles("dev")
//public class StudentControllerTest {
//    /**
//     * 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
//     */
//    private MockMvc mockMvc;
//
//    /**
//     * 注入WebApplicationContext
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
//
//    /**
//     * get请求
//     *
//     * @throws Exception
//     */
//    @Test
//    public void getStudent() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getstudent")
//                // 这个“Accept” 头属性能被浏览器用来指定响应的media 类型，表示自己可以接受的类型。
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println(result.getResponse().getContentAsString());
//    }
//
//    @Test
//    public void postStudent() throws Exception{
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/post")
//                // 这个“Accept” 头属性能被浏览器用来指定响应的media 类型，表示自己可以接受的类型。
//                .contentType(MediaType.APPLICATION_JSON).content("{ \"studentNo\": 3,\"name\": \"tom\"}"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println(result.getResponse().getContentAsString());
//    }
//
//    /**
//          * 删除一个用户 /users/ DELETE
//          * */
//    @Test
//    public void deleteUser() throws  Exception{
//        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.delete("/delete/3")
//                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println(result.getResponse().getContentAsString());
//    }
//
//
//}