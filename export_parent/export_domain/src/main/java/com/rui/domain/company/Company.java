package com.rui.domain.company;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Company implements Serializable {
    private String id;
    private String name;//公司名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;//到期时间
    private String address;//公司地址
    private String licenseId;//营业执照
    private String representative;//法人代表
    private String phone;//公司电话
    private String companySize;//公司规模
    private String industry;//所属行业
    private String remarks;//备注
    private Integer state;//状态
    private Double balance;//当前余额
    private String city;//公司所在城市

}
