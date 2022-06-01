package com.first.common.model.entity;

import lombok.Data;

@Data
public class User {

    private int user_no;
    private String user_id;
    private String user_pw;
    private String user_name;
    private int user_phone;
    private String user_email;
    private String user_create_date;
    private String user_modify_date;
    private int user_agree_1;
    private int user_agree_2;

}
