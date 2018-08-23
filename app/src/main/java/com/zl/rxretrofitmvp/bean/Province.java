package com.zl.rxretrofitmvp.bean;

/**
 * @author xiaolong
 * @ClassName Province
 * @Date 2018/8/23
 **/
public class Province {

    /**
     * areaId : 0
     * areaName : 浙江省
     * areaCode : 330000
     * isLast : 2
     */

    private int areaId;
    private String areaName;
    private String areaCode;
    private int isLast;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public int getIsLast() {
        return isLast;
    }

    public void setIsLast(int isLast) {
        this.isLast = isLast;
    }
}
