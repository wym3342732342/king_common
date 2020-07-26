package club.maddm.king.common.model.general.except

/**
 * @author  GG boy
 * @date  2020/7/14 16:31
 * @version 1.0
 */
enum class HttpResultEnum(
        override val code: Int,
        override var message: String
) : HttpResult {
    NOT_FOUND(404,"您访问的资源没有找到！")
    ;

    /**
     * 自定义内容
     */
    public fun customMessage(message: String): HttpResultEnum {
        this.message = message
        return this
    }
}