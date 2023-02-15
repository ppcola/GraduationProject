package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName(value = "user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    @TableField(value = "avatar_url")
    private String avatar;
    /**创建日期*/
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    @ApiModelProperty(value = "创建日期")
//    @TableField(value = "create_time")
//    private Date createTime;

}
