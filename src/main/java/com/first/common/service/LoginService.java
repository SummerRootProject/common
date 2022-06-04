package com.first.common.service;

import com.first.common.model.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {

    //유저 로그인
    UserDTO loadUserByUsername(String user_id) throws UsernameNotFoundException;

    //유저 로그인 업데이트
    int updateLoginTime(int user_no);

    //회원가입
    int signUp(UserDTO user);


}
