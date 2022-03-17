package com.demo.constant;

public class Constants {
    //常用编码静态常量
    public final static String ENCODE_GBK = "gbk";
    public final static String ENCODE_GB2312 = "gb2312";
    public final static String ENCODE_UTF8 = "UTF-8";
    public final static String HTTP_METHOD = "GET";

    //HTTP请求静态常量
    public final static Integer CONNECTION_TIMEOUT = 15000;
    public final static Integer SO_TIMEOUT = 15000;
    public final static Integer CONN_REQ_TIMEOUT = 15000;

    // region 缓存时间常量（单位：分钟）
    public final static Integer CACHE_MID = 60;
    /**
     * 真值字符
     */
    public final static String TRUE_STR = "true";

    /**
     * 真值字符
     */
    public final static String FALSE_STR = "false";

    /**
     * 加密类型
     */
    private final static String SIGN_TYPE_MD5 = "MD5";

    //程序参数静态常量
    public final static String COMMON_PARAM_PAGENO = "pageNo";
    public final static String COMMON_PARAM_PAGESIZE = "pageSize";



    public static final int RESPONSE_RESULT_SUCCESS = 1;
    public static final int RESPONSE_RESULT_ERROR = 0;
    public static final int FAMILY_MEMBER_MAX_COUNT = 10;
    public static final int FAMILY_MEMBER_MAX_EXCLUDEDELETE_COUNT = 30;

    public static final String FEIGN_PASSPORT_USERINFO_SERVICE= "sfapp";
    public static final String FEIGN_PASSPORT_PHONE_SERVICE= "soufun-mysoufun-web";
    public static final String FEIGN_PASSPORT_PHONE_V= "2280A2A928B5F4ABDD3EFF1978FD6E07";


    public static final String RESPONSE_MESSAGE_SUCCESS = "成功";
    public static final String RESPONSE_MESSAGE_ERROR = "程序异常";
    public static final String RESPONSE_MESSAGE_ERROR_DB = "数据库异常";
    public static final String RESPONSE_MESSAGE_ERROR_DBORPASSPORTURL = "数据库或者通行证接口异常";
    public static final String RESPONSE_MESSAGE_ERROR_USERID = "userid异常";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILYID = "familyid异常";
    public static final String RESPONSE_MESSAGE_ERROR_FROMUSERID = "fromuserid异常";
    public static final String RESPONSE_MESSAGE_ERROR_REMARKEDUSERID = "remarkeduserid异常";
    public static final String RESPONSE_MESSAGE_ERROR_REMARK = "备注信息异常";

    public static final String RESPONSE_MESSAGE_ERROR_FAMILYCODE = "familycode异常";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER1 = "您不在该家庭群组中";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER2 = "同一用户只允许加入一个家庭";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER3 = "您已加入该家庭";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER4 = "该家庭成员数已达上限";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER5 = "邀请者不在家庭中";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER6 = "用户不存在或已退出家庭群组";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER7 = "无家庭信息";
    public static final String RESPONSE_MESSAGE_ERROR_FAMILY_ALTER8 = "无家庭成员信息";

    public static final String RESPONSE_MESSAGE_ERROR_HOUSE_ALTER1 = "房源不存在";

    public static final String RESPONSE_MESSAGE_ERROR_HOUSE_REMARK_ALTER1 = "该备注不存在";



    public static final String LOG_CONTENT_START = " request start ";
    public static final String LOG_CONTENT_END = " request end ";
    public static final String LOG_CONTENT_ERROR = " error ";

}
