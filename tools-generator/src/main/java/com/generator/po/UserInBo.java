package com.generator.po;

import com.ccb.cms.pub.po.RequestPagedInfoPo;

public class UserInBo {
    /**
     * 
     */
    private String id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;


    /**
     * 分页信息
     */
    private RequestPagedInfoPo pagination;
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }


    public RequestPagedInfoPo getPagination() {
        return pagination;
    }

    public void setPagination(RequestPagedInfoPo pagination) {
        this.pagination = pagination;
    }
}
