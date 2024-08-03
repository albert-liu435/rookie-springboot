package com.rookie.bigdata.beans.propertyeditors;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.util.Date;

/**
 * @Class DateEditorRegistrar
 * @Description
 * @Author rookie
 * @Date 2023/4/1 1:25
 * @Version 1.0
 */
public class DateEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, new DateEditor());
    }
}
