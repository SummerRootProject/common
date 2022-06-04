package com.first.common.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Alias("NotiDTO")
public class NotiDTO {

    private int noti_id;
    private int user_id;
    private int noti_cat_id;// 1. 일반, 2. 공지, 3. 커뮤니티, 4.
    private String noti_title;
    private String noti_content;
    private String noti_reg_date;
    private String noti_mod_date;
    private int noti_count; //조회
    private int noti_bookmark; //북마크

    //이벤트
    private String event_start_date;
    private String event_end_date;

}
