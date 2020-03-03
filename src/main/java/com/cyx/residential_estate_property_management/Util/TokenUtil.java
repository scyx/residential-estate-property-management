package com.cyx.residential_estate_property_management.Util;

import java.util.UUID;

/**
 * @author cyx
 * 生成token的工具
 * @data 2020/1/6 13:02
 */
public class TokenUtil {
    public static String generateToken() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
