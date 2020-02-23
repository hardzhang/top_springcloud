/**
 * Copyright © 2017-2018 Beijing Audiotone Technology Co.,Ltd.
 * All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Beijing Audiotone Technology Co.,Ltd.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with Audiotone.
 * AUDIOTONE MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. AUDIOTONE SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.example.oauth.pojo;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatUtils {
    private static final Pattern REX = Pattern
        .compile("\\$([a-zA-Z0-9_]*)\\$");

    
    public static String format(String template, Object obj) {
        if (StringUtils.isEmpty(template) || obj == null) {
            return null;
        }
        
        List<Field> fields = new ArrayList<>() ;
        Class<?> clazz = obj.getClass();
        while (clazz!=null && clazz!=Object.class) {//当父类为null的时候说明到达了最上层的父类(Object类).
        	fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass(); //得到父类,然后赋给自己
        }
        
        Matcher m = REX.matcher(template);
        Object fieldValueObj = null;
        String fieldValue = null;
        while (m.find()) {
            for (Field field : fields) {
                if (field.getName().equalsIgnoreCase(m.group(1))) {
                    try {
                        field.setAccessible(true);
                        fieldValueObj = field.get(obj);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    fieldValue = "";
                    if (fieldValueObj != null) {
                        fieldValue = fieldValueObj.toString();
                    }
                    template = template.replace(m.group(0), fieldValue);
                }
            }
        }
        return template;
    }

    public static String format(String template, Map<String, Object> map) {
        if (StringUtils.isEmpty(template) || map == null) {
            return template;
        }

        Matcher m = REX.matcher(template);
        Object fieldValueObj = null;
        String fieldValue = "";
        while (m.find()) {

            if (map.get(m.group(1))!=null) {
                try {

                    fieldValueObj = map.get(m.group(1));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                if (fieldValueObj != null) {
                    fieldValue = fieldValueObj.toString();
                }
                template = template.replace(m.group(0), fieldValue);
            }
        }

        return template;
    }
    
    public static void main(String[] args) {
        String template = "${nickName}已将你移出群：$groupName$";
        System.out.println("========");

        Map<String, Object> map = new HashMap<>();
        map.put("groupName","test");
        map.put("nickName","hahha");
        System.out.println(format(template, map));
    }
}

