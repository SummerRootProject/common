package com.first.common.service.impl;

import com.first.common.mapper.LoginMapper;
import com.first.common.model.dto.UserDTO;
import com.first.common.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO loadUserByUsername(String user_id) throws UsernameNotFoundException
    {
        UserDTO user = new UserDTO();
        try
        {
            user = mapper.loadUserByUsername(user_id);

            if (user == null)
            {
                System.out.println("유저 ID : " + user_id);

                throw new UsernameNotFoundException("ID와 일치하는 유저 없음");
            }

        }
        catch (Exception e)
        {
            System.out.println("로그인 실패" + e.getMessage());
        }

        return user;
    }

    //유저 로그인 업데이트
    public int updateLoginTime(int user_no)
    {
        return mapper.updateLoginTime(user_no);
    }

    @Override
    public int signUp(UserDTO user) {

            UserDTO userDTO = new UserDTO();
            userDTO.setUser_pw(passwordEncoder.encode(user.getPassword()));
            userDTO.setUser_phone(user.getUser_phone_1() + "-" + user.getUser_phone_2() + "-" + user.getUser_phone_3());
            userDTO.setUser_email(user.getUser_email1() + "@" + user.getUser_email2());

            return mapper.signUp(userDTO);
    }


}
