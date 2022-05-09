package com.first.common.service;

import com.first.common.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {

    UserDTO loadUserByUsername(String user_id) throws UsernameNotFoundException;

}
