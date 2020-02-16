package com.cyx.residential_estate_property_management.Bean;

import lombok.Data;

/**
 * @author cyx
 * @data 2020/1/6 10:54
 * 用户
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String telephone;
}
