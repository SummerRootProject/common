package com.first.common.controller;

import com.first.common.model.dto.NotiDTO;
import com.first.common.model.dto.UserDTO;
import com.first.common.service.NotiService;
import com.first.common.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class NotiController {

    private final NotiService notiService;

    @GetMapping("/notification")
    public String getNotiList()
    {
        notiService.getNotificationList();
        return "/notifications";
    }

    @PostMapping("/insertNoti")
    @ResponseBody
    public int insertNoti(@ModelAttribute NotiDTO notiDTO)
    {

        int result = notiService.insertNotification(notiDTO);

        if (result == 0) {
            return Status.ZERO;
        }
        return Status.FIRST;

    }




}
