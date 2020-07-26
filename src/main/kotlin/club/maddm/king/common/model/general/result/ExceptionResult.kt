package club.maddm.king.common.model.general.result

import club.maddm.king.common.model.general.except.HttpException
import club.maddm.king.common.model.general.except.HttpResult
import java.util.*

/**
 * 通用异常返回结果
 * @author  GG boy
 * @date  2020/7/14 16:25
 * @version 1.0
 */
public data class ExceptionResult(
        val status: Int,
        val message: String,
        val timestamp: Long) {
    constructor(httpResult: HttpResult)
            : this(httpResult.code, httpResult.message, Date().time) {
        //次构造器
    }
}