package com.clc.springboot.demo1.facade.enums.exception;

public enum ExceptionTypeEnum {

    //    程序异常
    UNKNOWN_EXCEPTION(-1, "系统内部错误"),
    LOGIN_ERROR(600, "用户未登陆，请重新登陆"),
    PARAM_EXCEPTION(601, "参数异常"),
    PARAM_NULL_EXCEPTION(602, "参数不可为空"),
    PARAM_NOT_EXISTS_EXCEPTION(603, "参数不存在"),
    SQL_EXCEPTION(604, "SQL异常,{0}"),
    SQL_FORMAT_EXCEPTION(605, "SQL语句出错，请检查SQL是否正确！{0}"),
    DATA_EXCEPTION(606, "数据异常"),
    SERVICE_EXCEPTION(607, "业务异常"),
    JSON_EXCEPTION(608, "json异常"),
    JSON_PARSE_EXCEPTION(609, "json解析出错"),
    SQL_ANALYSIS_ERROR(610, "SQL解析失败"),
    NO_AUTH_OF_USER(611, "当前用户无该权限"),
    ONLY_SELECT_ALLOW(612, "只允许执行查询语句,请检查SQL语句！"),
    LOG_PARAM_ERROR(613, "日志记录参数错误"),
    USER_NOT_EXIST(614, "用户不存在"),
    ONLY_SUPPORT_SELECT(615, "仅支持查询语句"),
    TYPE_CAST_ERROR(616, "数据类型转换失败"),
    RSA_ENCRYPT_FAIL(617, "加密失败"),
    RSA_DECRYPT_FAIL(618, "解密失败"),
    BACKEND_NOT_LOGIN(619, "您未登陆配置后台，请登陆后重试"),
    VALIDATE_CODE_OUT_OF_DATE(619, "验证码已过期，请重新获取"),
    CUSTOM_EXCEPTION(620, "{0}"),

    //    自定义异常 1000↑
    PARENT_FOLDER_NOT_EXIST(1001, "父级文件夹不存在或已删除"),
    FIVE_DEEP_FOLDER(1002, "文件夹深度最多5层"),
    FOLDER_NOT_EMPTY(1003, "该文件夹尚未清除所有文件，请清除后再尝试"),
    COLLECTION_ID_NOT_NULL(1004, "参数:数据集Id不可为空"),
    COLLECTION_NOT_EXIST(1005, "此数据集(id={0})不存在"),
    COLUMN_NOT_EXIST(1006, "SQL解析出错：{0} 字段在表 {1} 中不存在."),
    DATASOURCE_TYPE_ERROR(1007, "数据集来源类型异常"),
    FILE_SOURCE_NOT_EXIST(1008, "文件来源不存在"),
    BOARD_NOT_EXIST(1009, "仪表板不存在"),
    USER_FROZEN(1010, "当前账户被冻结，请前往钉钉修改密码"),
    COLLECTION_TABLE_NOT_EXISTS(1011, "数据集所在的数据表不存在"),
    MEMBER_REPEAT(1012, "不可重复添加成员"),
    NAME_REPEAT(1013, "名称不可重复"),
    FOLDER_NOT_CLEAR_EMPTY(1014, "该文件夹尚未清除所有文件！请清除后再尝试"),
    SHARE_REPEAT(1015, "当前文件不可重复分享到该部门/项目"),
    FOLDER_OR_FILE_NOT_EXIST(1016, "当前文件/文件夹已不存在"),
    COLLECTION_NOT_USE_AUTH(1017, "您没有数据集【{0}】使用权限，请联系管理员！"),
    COLLECTION_NAME_NOT_EMPTY(1018, "数据集名称不能为空"),
    SQL_PARAM_CNAME_NOT_REPEAT(1019, "字段别名【{0}】不可重复,请检查字段别名"),
    FOLDER_IS_DELETED(1020, "该文件夹已被删除,请刷新列表！"),
    COLLECTION_HAS_NOT_USE_COLUMN(1021, "该数据集对当前用户没有可用字段，请联系管理员"),
    COLLECTION_DELETED(1022, " 数据集【{0}】已被删除"),
    SPECIAL_ROLE_CAN_NOT_DELETE(1023, "特殊角色不能删除"),
    COLUMN_PATTERN_NOT_EXISTS(1024, "当前格式：{0} 在数据库中不存在，请联系管理员"),
    COLUMN_GATHER_TYPE_NOT_EXISTS(1025, "当前字段的聚集类型不存在，请联系管理员"),
    COLUMN_GROUP_NOT_EXISTS(1026, "字段组id={0}不存在，请检查后重试"),
    COLUMN_ID_NOT_NULL(1027, "字段名称{0}的ID不可为空，请检查后重试"),
    SELF_DATA_TASK_NOT_WITHDRAWAL(1028, "该任务OC已处理，不可撤回"),
    SELF_DATA_TASK_OC_WITHDRAWAL_FAIL(1029, "该任务在OC撤回失败"),
    SELF_DATA_TASK_IS_PROCESSING(1030, "任务正在处理，不可取消"),
    SELF_DATA_TASK_IS_CANCELLED(1031, "任务已经取消，不可取消"),
    SELF_DATA_TASK_IS_INVALID(1032, "任务已经失效，不可取消"),
    SELF_DATA_TASK_IS_NOT_INVALID(1033, "任务不是失效状态，不可激活"),
    TEMPLATE_NOT_EXIST(1034, "当前取数模板已不存在"),
    OSS_UPLOAD_FAIL(1035, "OSS文件上传失败"),
    EXCEL_BUILT_FAIL(1036, "Excel文件生成失败"),
    RELEASE_FILE_FAIL(1037, "释放文件失败"),
    JOIN_CONDITION_NOT_NULL(1038, "表关联的join关系不能为空"),
    COLLECTION_JOIN_BUILT_ERROR(1039, "表关联JOIN生成异常"),
    DATE_PATTERN_NOT_EXISTS(1040, "日期格式{0}不存在,请联系管理员检查数据"),
    DATE_PATTERN_NOT_ERROR(1041, "日期格式转换异常"),
    COLUMN_CNAME_NOT_EXISTS(1042, "字段名{0}不存在，请检查"),
    DERIVED_COLUMN_PATTERN_ERROR(1043, "衍生字段{0}格式不正确，请检查衍生字段的格式"),
    JOIN_TABLE_TOO_MUCH(1044, "关联的表过多，请减少表个数"),
    EXPORT_ERROR(1045, "导出文件出错"),
    ONLY_SUPPORT_READ(1046, "SQL只支持READ,请修改SQL"),
    COLLECTION_MAIN_TABLE_NOT_EXIST(1047, "数据集主表不存在"),
    COLLECTION_JOIN_TYPE(1048, "表关联的join类型不能为空"),
    DERIVED_GATHER_CANNOT_TRANSFER_DATE(1049, "带聚合的衍生字段不能转换成日期字段"),
    COLLECTION_COLUMN_NOT_EXIST(1050, "[{0}]字段不存在"),
    COLLECTION_JOIN_QUERY_NO_COLUMNS(1051, "请至少选择一个字段查询"),
    PHONE_VALIDATE_ERROR(1052, "用户手机号格式错误"),
    EMAIL_VALIDATE_ERROR(1053, "用户邮箱格式错误"),
    DEPARTMENT_NAME_REPEAT(1054, "部门名称不可重复"),
    DIM_COLUMN_NOT_NULL(1055, "维度字段不能为空"),
    ADVANCE_COLUMN_DATA_ERROR(1056, "高级计算字段参数错误"),
    DATE_COLUMN_TYPE_ERROR(1057, "日期字段类型错误"),
    ADD_UP_DATE_UNIT_ERROR(1058, "累计时间单位错误"),
    COLUMN_REFERENCE_BY_DERIVED(1059, "字段[{0}]被衍生字段引用,不可删除"),
    MYSQL_NOT_SUPPORT_FULL_JOIN(1060, "MySQL暂时不支持full join"),
    TABLE_NOT_EXISTS(1061, "表不存在"),
    PROJECT_NAME_REPEAT(1062, "部门名称不可重复"),
    SQL_TABLE_NO_ALIAS(1063, "SQL表别名可为空"),
    RECORD_HAVE_DELETED(1064, "记录已被删除，请刷新重试"),
    DEPARTMENT_ROLE_CAN_NOT_NULL(1065, "用户无OC角色部门信息"),
    SPECIAL_APPROVE_ERROR(1066, "无法定位策略特殊审批人信息"),
    TASK_JUDGE_FAILED(1067, "任务判定失败"),
    AUDIT_WITHDRAW_ERROR(1067, "审批撤回异常，未找到任务对应的流程"),
    TASK_NOT_EXIST(1068, "当前任务不存在"),
    WITHDRAW_TASK_ERROR(1069, "当前任务状态已无法撤回"),
    APPLY_TASK_ERROR(1069, "当前任务状态已无法发起申请"),
    PUSH_PARAM_ERROR(1070, "推送任务参数异常"),
    DEPARTMENT_CAN_NOT_REPEAT(1071, "部门全局不能重复"),
    ROLE_CAN_NOT_REPEAT_IN_COLLECTION(1072, "同一数据集集合下，角色不能重复"),
    FILE_LOCK_ERROR(1064, "文件锁定出错"),
    FILE_UNLOCK_ERROR(1065, "文件解锁出错"),
    WEBSOCKET_SEND_MESSAGE_ERROR(1066, "消息通知失败"),
    WEBSOCKET_OPEN_CONNECTION_ERROR(1067, "websocket建立连接失败"),
    WEBSOCKET_CLOSE_CONNECTION_ERROR(1068, "websocket关闭连接失败"),
    WEBSOCKET_TRANSPORT_ERROR(1069, "websocket消息传输失败"),
    FILE_IS_LOCKED_CANNOT_OPERATE(1070, "当前文件正在被【{0}】锁定，请等待对方解锁后再操作"),
    COLLECTION_EDIT_SAVE_GET_LOCK_ERROR(1071, "数据集保存获取锁失败"),
    BOARD_SHARE_CANCELLED(1072, "该仪表板分享被取消"),
    FILE_IS_LOCKED_CANNOT_RENAME(1073, "文件正在被锁定，不能重命名，请解锁后重试"),
    FILE_IS_LOCKED(1074, "文件已经被锁定,请等待解锁后重试"),
    CURRENT_USER_NOT_AUTH(1075, "暂无该[{0}]操作权限，如有问题请咨询相关负责人或系统管理员！"),
    COLUMN_NO_LOOK_AUTH(1076, "您对于该数据集的字段[{0}]没有查看权限，请联系相关负责人"),
    FILE_SHARE_ERROR(1077, "文件分享失败，请检查是否已保存"),
    END_OC_ROLE_ERROR(1078, "无法定位策略终止角色信息"),
    TACTICS_DETAIL_REPEAT(1079, "同角色集合下，三个条件不能重复"),
    PORTAL_NOT_EXIST(1086, "数据门户不存在"),
    USE_MARK_NOT_EXIST(1087, "该标识未定义，请联系技术添加！"),
    UPLOAD_FILE_NOT_EXIST(1088, "请选择上传文件！"),
    PORTAL_HOME_UNIQUE(1089, "数据门户首页不唯一"),
    PARENT_NODE_NOT_NULL(1090, "父级菜单不能设置内容"),
    COLUMN_TOO_MUCH(1080, "交叉表列数不得超过500列"),
    COLUMN_SAME_GATHER(1081, "相同字段【{0}】字段的聚合方式不能相同"),
    COLLECTION_SELECT_NO_COLUMNS(1082, "请至少选择一个字段查询"),
    FILTER_NOT_SAME_LEVEL(1091, "只能过滤相同日期单位的字段"),
    WEE_DATE_COLUMN_NOT_NULL(1092, "最细日期纬度字段不能为空"),
    MERCHANT_IS_NOT_EXIST(1093, "商户不存在"),
    DEPARTMENT_CAN_NOT_EDIT(1094, "当前部门不可编辑"),
    DIM_DATE_UNIT_ERROR(1095, "时间颗粒度混乱，请重新选择"),
    COLUMN_SHOW_NAME_NOT_REPEAT(1096, "数据集字段【{0}】中文名重复,请修改后重新保存"),
    COOPERATION_FILE_NOT_EXIST(1097, "当前空间该文件已不存在"),
    SQL_COLUMN_QUOTA_DEFINITION_NOT_EMPTY(1098, "字段【{0}】的指标定义不能为空"),
    SQL_COLUMN_ORIGIN_NOT_EMPTY(1099, "字段【{0}】的字段来源(来源表和来源字段)不能为空"),
    TASK_CANCEL_FAILED(1100, "任务取消失败"),
    NO_MAPPING_TACTICS(1101, "未匹配到任何一条审批策略，请检查策略配置"),
    COLLECTION_ROLLBACK_READ_FILE_ERROR(1102, "数据集还原失败，参数文件读取失败"),
    OSS_DOWNLOAD_FAIL(1103, "OSS文件获取失败"),
    VERSION_NOT_EXISTS(1104, "此备份不存在"),
    NO_FILE_EDIT_AUTH(1099, "缺少文件编辑权限，无法保存"),
    COLLECTION_GROUP_NOT_EXIST(1099, "数据集集合已被删除"),
    COLLECTION_GROUP_CAN_NOT_NULL(1100, "数据集集合不能为空，请到策略配置页面删除对应策略。"),
    SQL_QUOTA_NOT_MAINTAIN(1105, "存在未维护字段"),
    NO_PREVIEW_AUTH(1106, "暂无{0}[{1}]的{2}权限，如需查看可联系[{3}]设置协作权限~"),
    LEQEE_SPACE_RULE_ERROR(1107, "商户空间机制配置错误，乐其商户只支持用户组制"),
    GROUP_NAME_REPEAT(1106, "用户组名称不可重复"),
    EMPTY_CHART_CAN_NOT_EXPORT(1108, "内容为空，无法导出"),
    WEEK_PARAM_FORMAT_EXCEPTION(1109, "周参数格式异常,格式示例:[{0}]"),

    SPREADSHEET_NOT_EXIST(1210, "电子表格不存在"),
    SPREADSHEET_SAVE_ERROR(1211, "电子表格保存错误"),
    RDS_NOT_ENABLE(1220, "数据源【{0}】暂停使用"),
    RDS_TYPE_NOT_SUPPORT(1221, "数据源类型暂时不支持"),
    RDS_LINK_FAIL(1222, "数据源连接失败,请检查连接配置,{0}"),
    RDS_DATASOURCE_TEST_ERROR(1223, "测试失败,【{0}】无法链接，请核对"),
    RDS_NOT_EXISTS(1224, "数据源不存在，请检查参数"),
    RDS_DATASOURCE_NOT_EXISTS(1225, "数据源【{0}】中的数据库【{1}】不存在或者无权限"),
    DATASOURCE_NOT_EXISTS(1226, "数据库不存在，请联系管理员！"),
    RDS_TYPE_ERROR(1226, "数据源类型不正确,请选择【{0}】数据源"),
    SLOW_SQL_ERROR(1221, "此SQL执行太慢,请联系管理员"),


    LEVEL_NOT_REPEAT(2001, "层级不可重复"),
    AUTH_CODE_NOT_NULL(2002, "权限码不能为空"),
    AUTH_CODE_NOT_REPEAT(2003, "权限码不能重复"),
    CHILD_BE_NULL_WHEN_CHANGE_PARENT(2004, "当前权限下含有子权限，不可变更所属节点"),

    CONTAIN_DELETED_COLUMN(3001, "存在已删除字段"),

    ;

    private Integer code;
    private String message;

    ExceptionTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
