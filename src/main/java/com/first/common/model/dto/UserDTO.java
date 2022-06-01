package com.first.common.model.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Alias("UserDTO")
public class UserDTO implements UserDetails{

    private int user_no;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_phone;
    private String user_email;
    private String user_create_date;
    private String user_modify_date;

    private String user_phone_1;
    private String user_phone_2;
    private String user_phone_3;
    private String user_email1;
    private String user_email2;
    private String user_address;
    private int user_agree_1;
    private int user_agree_2;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return user_pw;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return user_id;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }



}
