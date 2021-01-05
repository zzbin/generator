package com.generator.po;

import com.ccb.cms.pub.po.RequestPagedInfoPo;

public class OrdersInBo {
    /**
     * 
     */
    private String id;

    /**
     * 下单用户id
     */
    private String userId;

    /**
     * 订单号
     */
    private String number;

    /**
     * 创建订单时间
     */
    private String createtime;

    /**
     * 备注
     */
    private String note;


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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }


    public RequestPagedInfoPo getPagination() {
        return pagination;
    }

    public void setPagination(RequestPagedInfoPo pagination) {
        this.pagination = pagination;
    }
}
