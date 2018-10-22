package cn.jiayuli.mybatis.entity;

import java.util.Date;

public class Recharge {
    private Integer id;

    private String name;

    private Double total;

    private Double used;

    private Double balance;

    private String remark;

    private String createStaff;

    private Date createTime;

    private String updateStaff;

    private Date updateTime;

    public Recharge(Integer id, String name, Double total, Double used, Double balance, String remark, String createStaff, Date createTime, String updateStaff, Date updateTime) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.used = used;
        this.balance = balance;
        this.remark = remark;
        this.createStaff = createStaff;
        this.createTime = createTime;
        this.updateStaff = updateStaff;
        this.updateTime = updateTime;
    }

    public Recharge() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getUsed() {
        return used;
    }

    public void setUsed(Double used) {
        this.used = used;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff == null ? null : createStaff.trim();
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
        this.updateStaff = updateStaff == null ? null : updateStaff.trim();
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