package com.first.common.mapper;

import com.first.common.model.dto.NotiDTO;
import com.first.common.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotiMapper {

    List<NotiDTO> getNotificationList() throws Exception;
    int insertNotification(NotiDTO notiDTO);

}
