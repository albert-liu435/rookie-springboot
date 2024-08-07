package com.rookie.bigdata.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Class FlashManagerController
 * @Description
 * @Author rookie
 * @Date 2024/8/7 17:03
 * @Version 1.0
 */
@Controller
@Slf4j
public class FlashManagerController {

    // 重定向前的方法
    @RequestMapping(value = "/testRedirect",method = RequestMethod.GET)
    public String testRedirect(/*@RequestParam(name = "request") */HttpServletRequest request, HttpServletResponse response, /*@RequestParam(name = "redirectAttributes")*/ RedirectAttributes redirectAttributes) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();



// 普通属性
        redirectAttributes.addAttribute("redirectAttributes", "redirectAttributesValue");
//flash 属性
        redirectAttributes.addFlashAttribute("addFlashAttribute", "redirectAttributes.addFlashAttribute-value");

        redirectAttributes.addFlashAttribute("b", "b");

        FlashMapManager attribute = (FlashMapManager)request.getAttribute(DispatcherServlet.FLASH_MAP_MANAGER_ATTRIBUTE);
        FlashMap flashMap=new FlashMap();
        flashMap.put("a","a");

        attribute.saveOutputFlashMap(flashMap,request,response);

        return "redirect:/testr1";
//        return "redirect:/testr2";
    }

    // 重定向后的
    @RequestMapping("/testr1")
    public String testr(HttpServletRequest request, /*String redirectAttributes, String addFlashAttribute,*/Model model){
// redirectAttributesValue
        System.out.println(request.getParameter("redirectAttributes"));
// null
        System.out.println("hello");
        System.out.println(request.getParameter("addFlashAttribute"));
// {addFlashAttribute=redirectAttributes.addFlashAttribute-value}
        System.out.println(model);
        return "success";
    }

    // 重定向后的
    @RequestMapping("/testr2")
    @ResponseBody
    public String testr(HttpServletRequest request, HttpServletResponse response/*, String redirectAttributes, String addFlashAttribute, Model model*/) {
// redirectAttributesValue
        System.out.println(request.getParameter("redirectAttributes"));
        log.info("redirectAttributes:{}",request.getParameter("redirectAttributes"));
// null
        System.out.println(request.getParameter("addFlashAttribute"));
        log.info("addFlashAttribute:{}",request.getParameter("addFlashAttribute"));

        String addFlashAttribute = (String)request.getAttribute("addFlashAttribute");

        log.info("addFlashAttribute:{}",request.getAttribute("addFlashAttribute"));

        FlashMapManager attribute = (FlashMapManager)request.getAttribute(DispatcherServlet.FLASH_MAP_MANAGER_ATTRIBUTE);
        FlashMap flashMap = attribute.retrieveAndUpdate(request, response);

        log.info("flashMap:{}",flashMap.toString());

        log.info("attribute:{}",attribute.toString());
// {addFlashAttribute=redirectAttributes.addFlashAttribute-value}
//        System.out.println(model);

        return "success";
    }
}
