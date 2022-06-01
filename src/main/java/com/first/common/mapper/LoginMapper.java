package com.first.common.mapper;

import com.first.common.model.dto.UserDTO;
import com.first.common.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    //유저 로그인
    UserDTO loadUserByUsername(@Param("user_id") String user_id);

    //유저 로그인 타임
    int updateLoginTime(@Param("user_no") int user_no);

    //회원가입
    int signUp(@Param("user") UserDTO userDTO);
}
