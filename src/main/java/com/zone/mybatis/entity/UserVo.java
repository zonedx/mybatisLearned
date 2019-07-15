package com.zone.mybatis.entity;

/**
 * @ClassName UserVo
 * @Author ZONE
 * @Date 2019/7/15 14:14
 * @Version 1.0
 **/
public class UserVo extends User {
    private String familyMemberName;

    public String getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }
}
