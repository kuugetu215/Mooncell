package enumeration;

/**
 * 数据库操作类型
 */
public enum OperationType {

    /**
     * 设置createTime和updateTime
     */
    INSERT,

    /**
     * 设置updateTime
     */
    UPDATE,

    /**
     * 更新时间与更新人id
     */
    TIMEUSER

}
