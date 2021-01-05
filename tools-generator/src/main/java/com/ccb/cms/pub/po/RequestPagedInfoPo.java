package com.ccb.cms.pub.po;

public class RequestPagedInfoPo {
    private int recInPage;
    private int pageJump;
    private int start;

    public int getRecInPage() {
        return recInPage;
    }

    public void setRecInPage(int recInPage) {
        this.recInPage = recInPage;
    }

    public int getPageJump() {
        return pageJump;
    }

    public void setPageJump(int pageJump) {
        this.pageJump = pageJump;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
