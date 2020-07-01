package com.tristan.exam.alipay.tranfer.model;

/**
 * @author byzuse
 * datetime: 2018/10/27 11:22.
 */
public enum StatusCode {
    /******正常成功提示*******/
    SUCCESS(100000, "成功"),
    TRIAL_MEMBER(100201, "试用版会员充值成功"),

    /*****常规错误******/
    CLIENT_ERROR(200000, "客户端错误"),
    SMS_CODE_ERROR(200001, "短信验证码错误"),
    NOT_LOGIN(200002, "用户未登录"),
    OPENID_EXIST(200003, "您的微信号已绑定其它手机号，可直接使用该微信号登录"),
    INVALID_TOKEN(200004, "登陆信息已过期，请重新登录"),
    INVALID_MESSAGE(200005, "消息不存在"),
    PARAMS_ERROR(200006, "参数错误"),
    BACKUP_VERSION_ERROR(200007, "备份版本错误"),
    SHARE_TOKEN_ERROR(200008, "分享码错误"),
    PHONE_EXIST(200009, "您的手机号已绑定其它微信号，可直接使用该手机号登录"),
    FILE_TYPE_NOT_SUPPORT(200010, "不支持该文件类型"),

    /******用户相关错误******/
    USER_NOT_EXISTS(300000, "该用户不存在，或者userId异常"),
    INVALID_PHONE(300001, "该手机无效或已注册"),
    USER_COMPANY_NOT_MATCH(300002, "用户公司不匹配"),
    ROLE_ACCESS_ERROR(300003, "用户角色不匹配"),
    POST_USER_ERROR(300004, "用户信息保存失败"),
    USER_VERIFIED_ERROR(300005, "用户未实名认证"),
    USER_CERT_API_ERROR(300006, "调用身份认证api失败"),
    USER_CERT_API_NOT_MATCH_ERROR(300007, "信息不匹配"),
    TARGET_USER_VERIFIED_ERROR(300008, "对方未实名认证"),
    PUBLIC_KEY_EXISTS(300009, "用户公钥已存在"),
    PHONE_NOT_MATCH(300010, "手机号不匹配"),
    ALREADY_VERIFIED(300011, "用户已实名认证"),
    USER_VERIFIED_FAILED(300012, "用户实名认证失败"),
    USER_DID_ALREADY_BIND(300013, "用户已绑定DID"),
    USER_DID_NOT_BIND(300014, "用户未绑定DID"),

    /*****名片相关错误******/
    CARD_EXISTS(400000, "该名片已经存在"),
    CARD_NOT_EXISTS(400001, "名片不存在"),
    CARD_VERIFIED_ERROR(400002, "该名片未通过公司认证"),
    CARD_SAME_USER_ERROR(400003, "名片对应同一个用户"),
    TARGET_CARD_VERIFIED_ERROR(400004, "对方名片未通过公司认证"),
    CARD_ALREADY_VERIFIED(400005, "名片已认证"),
    CARD_UNVERIFIED_DELETE_ERROR(400006, "您的身份已被公司认证，暂不可删除"),


    /*****公司相关错误******/
    COMPANY_VERIFIED_ERROR(500000, "公司尚未开通会员，请联系公司管理员进行开通"),
    COMPANY_NOT_EXISTS(500001, "未找到该公司"),
    COMPANY_ALREADY_CHAIN(500002, "该公司已上链"),
    COMPANY_CREDIT_CODE_EMPTY(500003, "公司统一社会信用代码为空"),
    COMPANY_NO_ADMIN(500004, "公司没有管理员"),
    COMPANY_ALREADY_VERIFIED(500005, "公司已认证"),
    COMPANY_NOT_CHAIN(500006, "公司未上链"),
    COMPANY_DID_NOT_BIND(500007, "公司未绑定DID"),
    COMPANY_DID_ALREADY_BIND(500008, "公司已绑定DID"),
    COMPANY_VERIFING(500009, "公司认证中，请稍后"),
    COMPANY_NOT_VERIFIED(500010, "公司未认证"),

    /*****会员相关错误******/
    MEMBER_NOT_OPEN(600000, "未开通会员"),
    BUSINESS_INSUFFICIENT(600001, "商机数量不足,无法通过"),
    EMPLOYEE_INSUFFICIENT(600002, "员工名额不足,无法通过"),
    PRODUCT_INSUFFICIENT(600003, "产品数量不足"),
    BUSINESS_OVERDUE(600004, "名片交换已过期"),
    MEMBER_COUPON_INVALID(600005, "此优惠券无效或与套餐不匹配"),
    MEMBER_OPENED(600006, "该公司已开通会员"),
    MEMBER_TRIAL_RENEW_ERROR(600007, "试用版不支持续约"),
    MEMBER_RENEW_EMPLOYEE_ERROR(600008, "您续约标准版，需要操作移除员工名片至十人或十人以内哦~"),
    MEMBER_RENEW_PRODUCT_ERROR(600009, "您续约标准版，需要操作移除产品名片至两张或两张以内哦~"),
    MEMBER_ORDER_ERROR(600010, "创建订单失败"),
    MEMBER_PRODUCT_NOT_EXISTS(600011, "会员版本信息不存在"),
    MEMBER_PRODUCT_TYPE_ERROR(600012, "会员版本类型错误"),
    MEMBER_PRODUCT_FREE_VERSION(600013, "免费版本，不需要付费"),
    MEMBER_DOWNGRADE_NOT_SUPPORT(600014, "不支持版本降级"),
    MEMBER_ONLINE_OPEN_NOT_SUPPORT(600015, "版本不支持在线开通"),
    MEMBER_UNIFIED_ORDER_ERROR(600016, "创建支付订单失败"),
    MEMBER_ZERO_PERMISSION_COUNT(600100, "会员权限次数已达上限"),
    MEMBER_PRODUCT_PERMISSION_NOT_FOUND(600101, "会员产品权限信息不存在"),
    MEMBER_PRODUCT_NO_PERMISSION(600101, "会员产品没有权限"),

    // 会员服务无权查看活动或公告
    VIEW_NOT_AUTHORIZED(600100, "暂无查看权限"),
    ALREADY_ORG_MEMBER(600101, "已加入该组织"),
    EMPLOYEE_NOT_CERTIFIED(600102, "未员工认证"),
    NOT_ORG_MEMBER_ANYMORE(600103, "已被移出组织"),
    SIGN_UP_CAPACITY_FILLED(600104, "报名人数已满"),
    SIGN_UP_CLOSED(600105, "报名已截止"),
    SIGN_UP_UNAUTHORIZED(600106, "您没有报名权限"),
    SIGNED_UP(600107, "您已报名"),
    SIGN_UP_NOT_STARTED(600108, "报名未开始"),
    NOTICE_NOT_RECALLABLE(600109, "超过1小时不可撤回"),
    NOTICE_RECALLED(600110, "发起者撤回了该公告~"),
    ACTIVITY_RECALLED(600111, "发起者撤回了该活动~"),
    BUSINESS_RECALLED(600112, "发起者撤回了该商机~"),
    ACTIVITY_ORDER_ERROR(600200, "创建订单失败"),
    ACTIVITY_NOT_EXISTS(600201, "活动信息不存在"),
    ACTIVITY_ABOUT_TO_START(600202, "活动即将开始，不能取消"),
    PARTICIPANT_NOT_SUCCESS(600203, "报名状态不正确，不能取消"),
    ACTIVITY_ORDER_NOT_EXISTS(600204, "活动订单不存在，不能取消"),
    ACTIVITY_REFUND_AMOUNT_ERROR(600205, "订单金额计算错误，不能取消"),
    ACTIVITY_ORDER_WAIT_PAY(600206, "已报名，待付费"),
    ACTIVITY_ORDER_WAIT_REFUND(600207, "已报名，退费中"),
    ACTIVITY_ORDER_REFUNDED(600208, "已退费"),
    ACTIVITY_SIGN_UP_CANCELED(600209, "已取消报名"),
    ACTIVITY_ORDER_ALREADY_PAYED(600210, "订单已支付"),

    /*****会员相关错误******/
    PRODUCT_EXISTS(700000, "产品已存在"),
    PRODUCT_NOT_EXISTS(700001, "产品不存在"),
    MEMBER_PAID(700002, "该已开通会员，等待上链"),

    /*****电子协议相关错误*****/
    CONTRACT_NOT_EXISTS(800000, "未找到该电子协议"),
    CONTRACT_NOT_AUTHORIZED(800001, "暂无签约权限"),
    CONTRACT_OVER_DUE(800002, "电子协议已过签署截止日期"),
    CONTRACT_REJECT(800003, "电子协议已拒签"),
    CONTRACT_COMPANY_ERROR(800004, "签约公司错误"),
    CONTRACT_SELF_SIGN(800005, "已签署电子协议"),
    CONTRACT_SELF_REJECT(800006, "已拒签电子协议"),
    CONTRACT_COMPLETE(800007, "电子协议已完结"),
    CONTRACT_RECORD_ERROR(800008, "电子协议流程错误"),
    CONTRACT_PROCESSED(800009, "电子协议已处理"),
    CONTRACT_NEED_SIGN(800010, "需要先签署待签协议"),
    CONTRACT_RECORD_FILE_KEY_EXISTS(800011, "协议文件密钥已上传"),
    CONTRACT_CHAIN_ERROR(800012, "电子协议上链状态错误"),

    /**
     * 证书相关错误
     */
    CERTIFICATE_IS_HIDDEN(1000000, "证书已隐藏"),
    CERTIFICATE_IDENTITY_CANNOT_WITNESS(1000001, "身份类证书不能见证"),
    CERTIFICATE_TEMPLATE_NOT_EXISTS(1000002, "证书模板不存在"),


    /**
     * 伙伴互证（邀请他证）
     */
    PARTNER_RELATION_ALREADY_EXISTS(1100000, "认证关系已存在"),
    PARTNER_RELATION_NOT_EXISTS(1100001, "认证关系不存在"),

    /**
     * 组织相关错误
     */
    NOT_ORG_MEMBER(1200000, "不是组织成员"),
    ORG_MEMBER_NOT_ACCEPTED(1200001, "不是认证的组织成员"),
    NO_GRADE_FOUND(1200002, "组织等级不存在"),

    /**
     * 链节点相关错误
     */
    CHAIN_NODE_PROCESSING(1300000, "链节点申请处理中"),
    CHAIN_NODE_HAS_VOTE(1300001, "已投票"),
    CHAIN_NODE_STATUS_ERROR(1300002, "链节点状态错误"),

    /**
     * 订单相关错误
     */
    ORDER_STATUS_ERROR(1400000, "订单状态错误"),
    ORDER_ALREADY_CANCELED(1400001, "订单已取消"),
    NOT_SUPPORT_PAY_TYPE(1400002, "支付类型错误"),
    PAY_STATUS_ERROR(1400003, "支付状态错误"),
    ORDER_NOT_EXISTS(1400004, "订单信息不存在"),

    /******服务端错误***/
    SERVER_ERROR(900000, "服务端错误"),
    IMAGE_UPLOAD_FAILURE(900001, "图片上传失败"),
    NOT_AUTHORIZED(900002, "没有权限"),
    DATA_NOT_EXISTS(900003, "数据不存在"),
    DID_ALREADY_USED(900004, "DID已经被使用"),
    DATA_EXISTS(900005, "数据已存在"),;

    private final int code;

    private final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
