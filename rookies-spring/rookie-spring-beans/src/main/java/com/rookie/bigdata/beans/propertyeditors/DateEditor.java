package com.rookie.bigdata.beans.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

/**
 * @Class DateEditor
 * @Description
 * @Author rookie
 * @Date 2023/4/1 1:24
 * @Version 1.0
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(new SimpleDateFormat("yyyy-MM-dd").parse(text));
        } catch (Exception e) {
            System.out.println("DateEditor Convert Fail!");
        }
    }
}
