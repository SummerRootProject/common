package com.first.common.service;

import com.first.common.model.dto.NotiDTO;
import com.first.common.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface NotiService {

    //공지 목록
    List<NotiDTO> getNotificationList();
    //공지 등록
    int insertNotification(NotiDTO notiDTO);


}
