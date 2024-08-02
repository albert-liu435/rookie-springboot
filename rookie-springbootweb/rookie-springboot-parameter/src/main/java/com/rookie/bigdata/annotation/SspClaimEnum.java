package com.rookie.bigdata.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Classname SspClaimEnum
 * @Description
 * @Author rookie
 * @Date 2021/8/18 10:02
 * @Version 1.0
 */
public interface SspClaimEnum {

    @Getter
    @AllArgsConstructor
    enum Nation {
        AAAA("a", "国家A"),
        BBBB("b", "国家B");
        private String code;
        private String desc;
        @Override
        public String toString() {
            return getCode();
        }
    }
}
