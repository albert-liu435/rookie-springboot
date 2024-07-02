package com.rookie.bigdata.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * @ClassName UserControllerTest
 * @Description UserControllerTest
 * @Author rookie
 * @Date 2021/6/17 16:17
 * @Version 1.0
 */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"dev"})
public class UserControllerTest {
    /**
     * 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
     */
//    private MockMvc mockMvc;

    @Autowired
    private MockMvc mockMvc;

    /**
     * 注入WebApplicationContext
     */
//    @Autowired
//    private WebApplicationContext wac;

    /**
     * 类加载前
     */
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//    }

    /**
     * 类加载后
     */
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//    }

    /**
     * 实例创建前
     */
//    @Before
//    public void setUp() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }

    /**
     * 实例创建后
     */
//    @After
//    public void tearDown() throws Exception {
//
//    }

    @Test
    public void getUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getuser")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


    @Test
    public void getUser2() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getuser2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


    /**
     * 1、get方法测试首尾去空格
     */
//    @GetMapping(value = "/getTrim")
    @Test
    public void getTrim(/*@RequestParam String username, @RequestParam String phone*/) throws Exception {
//        return username + "&" + phone;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getTrim")
                                .param("username", "zhangsan ").param("phone", "123456789 ")
                        /*.accept(MediaType.APPLICATION_JSON)*/)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


    @Test
    void exampleTest(@Autowired WebTestClient webClient) throws Exception {
        webClient
                .get().uri("/getTrim?username=abc &phone=123456 ")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);
    }

    /**
     * 2、post方法测试首尾去空格
     */
//    @PostMapping(value = "/postTrim")
    @Test
    public void postTrim(/*@RequestParam String username, @RequestParam String phone*/) {
//        return username + "&" + phone;
    }

    /**
     * 3、post方法 Content-Type为application/json 测试首尾去空格
     */
//    @PostMapping(value = "/postJsonTrim")
    @Test
    public void helloUser(/*@RequestBody User user*/) {
//        return JSONObject.toJSONString(user);
    }


}
