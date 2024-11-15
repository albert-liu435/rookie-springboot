package com.rookie.bigdata.controller;


import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @ClassName UserControllerTest
 * @Description UserControllerTest
 * @Author rookie
 * @Date 2021/6/17 16:17
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserControllerTest {
    /**
     * 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
     */
    private MockMvc mockMvc;

    /**
     * 注入WebApplicationContext
     */
    @Autowired
    private WebApplicationContext wac;

    /**
     * 类加载前
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * 类加载后
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * 实例创建前
     */
    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 实例创建后
     */
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void getUser2() throws Exception{
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/getuser2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void getUser()  throws Exception{
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/getuser")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
