package com.wind.mybatisdemo.bean.MySelect.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
@ApiModel("批量增加新房收藏")
public class AddNewSelectListParams {

    @ApiModelProperty(value = "用户Id", required = true)
    private long userId;

    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @ApiModelProperty(value = "数据", required = true)
    private List<AddNewSelectDataParams> addSelectList;
}

