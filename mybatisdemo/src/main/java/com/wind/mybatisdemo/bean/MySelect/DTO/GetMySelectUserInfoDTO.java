package com.wind.mybatisdemo.bean.MySelect.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetMySelectUserInfoDTO {

    @ApiModelProperty("用户Id")
    private long userId;

    @ApiModelProperty("用户名")
    private String userName;
}