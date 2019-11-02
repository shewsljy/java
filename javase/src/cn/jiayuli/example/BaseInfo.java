package cn.jiayuli.example;

import java.io.Serializable;

public class BaseInfo implements Serializable {
    private static final long serialVersionUID = 3636032595393246236L;
    private String appName = "example";
    private String threadId;
    private Integer pageNo = 1;
    private Integer pageSize = 1;
    private String localeCode = null;
    private BaseRouteInfo baseRouteInfo = null;

    public BaseInfo() {
        this.localeCode = LocaleCodeUtil.getLocaleCode();
        this.threadId = ThreadId.getThreadId();
        this.baseRouteInfo = new BaseRouteInfo();
        this.setShopLocaleCode(LocaleCodeUtil.getShopLocaleCode());
        this.setChnlLocaleCode(LocaleCodeUtil.getChnlLocaleCode());
    }

    public String getLocaleCode() {
        return this.localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public int getStartRowIndex() {
        return (this.getPageNo() - 1) * this.getPageSize() + 1;
    }

    public int getEndRowIndex() {
        return this.getPageNo() * this.getPageSize();
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "appName='" + appName + '\'' +
                ", threadId='" + threadId + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", localeCode='" + localeCode + '\'' +
                ", baseRouteInfo=" + baseRouteInfo +
                '}';
    }

    public String getChnlLocaleCode() {
        return this.baseRouteInfo.getChnlLocaleCode();
    }

    public void setChnlLocaleCode(String chnlLocaleCode) {
        this.baseRouteInfo.setChnlLocaleCode(chnlLocaleCode);
    }

    public String getShopLocaleCode() {
        return this.baseRouteInfo.getShopLocaleCode();
    }

    public void setShopLocaleCode(String shopLocaleCode) {
        this.baseRouteInfo.setShopLocaleCode(shopLocaleCode);
    }
}
