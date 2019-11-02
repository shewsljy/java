package cn.jiayuli.example;

public class LocaleCodeUtil {
    private static ThreadLocal<String> threadLocal = new ThreadLocal();
    private static ThreadLocal<String> shopThreadLocal = new ThreadLocal();
    private static ThreadLocal<String> chnlThreadLocal = new ThreadLocal();

    private LocaleCodeUtil() {
    }

    public static String getLocaleCode() {
        return (String)threadLocal.get();
    }

    public static void setLocaleCode(String localeCode) {
        threadLocal.set(localeCode);
    }

    public static void removeLocaleCode() {
        threadLocal.remove();
    }

    public static String getShopLocaleCode() {
        String locale = (String)shopThreadLocal.get();
        return locale != null && locale.length() >= 1 ? locale : getLocaleCode();
    }

    public static void setShopLocaleCode(String localeCode) {
        shopThreadLocal.set(localeCode);
    }

    public static void removeShopLocaleCode() {
        shopThreadLocal.remove();
    }

    public static String getChnlLocaleCode() {
        String code = (String)chnlThreadLocal.get();
        return code != null && code.length() >= 1 ? code : getLocaleCode();
    }

    public static void setChnlLocaleCode(String localeCode) {
        chnlThreadLocal.set(localeCode);
    }

    public static void removeChnlLocaleCode() {
        chnlThreadLocal.remove();
    }

    public static void clearLocalecode() {
        removeChnlLocaleCode();
        removeShopLocaleCode();
        removeLocaleCode();
    }
}
