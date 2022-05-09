package com.first.common.service.impl;

import com.first.common.mapper.LoginMapper;
import com.first.common.model.dto.UserDTO;
import com.first.common.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper mapper;

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

}
