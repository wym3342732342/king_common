package club.maddm.king.common.model.general.except

/**
 * 通用http返回异常
 * @author  GG boy
 * @date  2020/7/14 16:28
 * @version 1.0
 */
public interface HttpResult {
    val code: Int //异常状态码
    var message: String//异常消息
}