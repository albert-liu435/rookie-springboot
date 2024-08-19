package com.rookie.bigdata.controller;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.RateLimiter;
import com.rookie.bigdata.annotation.Limit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Class AreaController
 * @Description
 * @Author rookie
 * @Date 2024/8/19 15:43
 * @Version 1.0
 */
@Controller
@RequestMapping("/area")
@Slf4j
public class AreaController {
//    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private IAreaService areaService;



    @RequestMapping("/testLimitWithAnnotation")
    @ResponseBody
    @Limit(key="/area/testLimitWithAnnotation",permitsPerSecond = 3,timeOut = 500L)
    public ResponseEntity testLimitWithAnnotation(){

        try {
            List<String> schoolIdList = new ArrayList<>();
            schoolIdList.add("1");
            Thread.sleep(1000);
//            return areaService.queryCount(schoolIdList);
            return new ResponseEntity(HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            log.error("查询校区异常", Throwables.getStackTraceAsString(e));
            return new ResponseEntity(HttpStatusCode.valueOf(400));
        }
    }


}
