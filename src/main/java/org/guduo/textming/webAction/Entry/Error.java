package org.guduo.textming.webAction.Entry;

/**
 * @athor Lijian
 * @date 2016年04月21日
 */
public class Error {
public static final int ILLEGAL_REQUEST_PARAMETERS = 4000;//请求参数非法;//缺少必要参数，或者参数值格式不正确，具体错误信息请查看错误描叙 message 字段。
public static final int AUTHENTICATION_FAILURE = 4100;//鉴权失败;//签名鉴权失败，请参考文档中鉴权部分。
public static final int REQUEST_OUT_DATE = 4200;//请求过期;//请求已经过期，请参考文档中请求有效期部分。
public static final int PERMISSION_DENIED = 4300;//拒绝访问;//帐号被封禁，或者不在接口针对的用户范围内等。
public static final int OVER_QUOTA = 4400;//超过配额;//请求的次数超过了配额限制，请参考文档请求配额部分。
public static final int REPLAY_ATTACK = 4500;//重放攻击;//请求的 Nonce 和 Timestamp 参数用于确保每次请求只会在服务器端被执行一次,所以本次的 Nonce 和上次的不能重复, Timestamp 与腾讯服务器相差不能超过 2 小时。
public static final int PROTOCOL_NOT_SUPPORT = 4600;//协议不支持;//协议不支持，请参考文档说明。
public static final int RESOURCES_NOT_FOUND = 5000;//资源不存在;//资源标识对应的实例不存在，或者实例已经被退还，或者访问了其他用户的资源。
public static final int RESOURCE_OPERATION_FAILS = 5100;//资源操作失败;//对资源的操作失败，具体错误信息请查看错误描述 message 字段，稍后重试或者联系客服人员帮忙解决。
public static final int RESOURCE_BUY_FAILURE = 5200;//资源购买失败;//购买资源失败，可能是不支持实例配置，资源不足等等。
public static final int RESOURCE_BUY_FAILURE_NO_MONEY = 5300;//资源购买失败;//购买资源失败，余额不足。
public static final int PARTIAL_SUCCESS = 5400;//部分执行成功;//批量操作部分执行成功, 详情见方法返回值。
public static final int USER_QUALIFICATION_FAILED = 5500;//用户资质审核未通过;//购买资源失败，用户资质审核未通过。
public static final int INTERNAL_SERVER_ERROR = 6000;//服务器内部错误;//服务器内部出现错误，请稍后重试或者联系客服人员帮忙解决。
public static final int VERSION_NOT_SUPPORT = 6100;//版本暂不支持;//本版本内不支持此接口或该接口处于维护状态等。注意: 出现这个错误时, 请先确定接口的域名是否正确, 不同的模块, 域名可能不一样。
public static final int INTERFACE_UNABLE_ACCESS = 6200;//接口暂时无法访问
}
