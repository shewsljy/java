package cn.jiayuli.mybatis.entity;

import java.util.Date;

public class Recharge {
    private int id;
    private String name;
    private double total;
    private double used;
    private double balance;
    private String remark;
    private String createStaff;
    private Date createTime;
    private String updateStaff;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getUsed() {
        return used;
    }

    public void setUsed(double used) {
        this.used = used;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(String updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", used=" + used +
                ", balance=" + balance +
                ", remark='" + remark + '\'' +
                ", createStaff='" + createStaff + '\'' +
                ", createTime=" + createTime +
                ", updateStaff='" + updateStaff + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
