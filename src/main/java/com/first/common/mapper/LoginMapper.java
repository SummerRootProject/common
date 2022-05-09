package com.first.common.mapper;

import com.first.common.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    //유저 로그인
    UserDTO loadUserByUsername(@Param("user_id") String user_id);

}
