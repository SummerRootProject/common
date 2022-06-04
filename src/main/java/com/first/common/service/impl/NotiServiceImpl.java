package com.first.common.service.impl;

import com.first.common.mapper.NotiMapper;
import com.first.common.model.dto.NotiDTO;
import com.first.common.model.dto.UserDTO;
import com.first.common.service.NotiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class NotiServiceImpl implements NotiService {

    private final NotiMapper notiMapper;

    @Override
    public List<NotiDTO> getNotificationList()
    {

        Map<String,Object> dataMap = new HashMap<>();
        try {
            List<NotiDTO> notiList = notiMapper.getNotificationList();
            dataMap.put("notiList", notiList);
        } catch (Exception e) {
            System.out.println("목록 가져오기 실패 : " + e.toString());
        }
        return (List<NotiDTO>) dataMap;

    }

    @Override
    public int insertNotification(NotiDTO notiDTO)
    {

        return notiMapper.insertNotification(notiDTO);

    }
}
