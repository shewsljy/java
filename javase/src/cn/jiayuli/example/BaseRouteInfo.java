package cn.jiayuli.example;

import java.io.Serializable;

public class BaseRouteInfo implements Serializable {
    private static final long serialVersionUID = 5522832152608014628L;
    private String chnlLocaleCode = null;
    private String shopLocaleCode = null;
    private String loginStaffType = null;

    public BaseRouteInfo() {
    }

    public String getChnlLocaleCode() {
        return chnlLocaleCode;
    }

    public void setChnlLocaleCode(String chnlLocaleCode) {
        this.chnlLocaleCode = chnlLocaleCode;
    }

    public String getShopLocaleCode() {
        return shopLocaleCode;
    }

    public void setShopLocaleCode(String shopLocaleCode) {
        this.shopLocaleCode = shopLocaleCode;
    }

    public String getLoginStaffType() {
        return loginStaffType;
    }

    public void setLoginStaffType(String loginStaffType) {
        this.loginStaffType = loginStaffType;
    }
}
