package club.maddm.king.common.model.general.except

import java.lang.RuntimeException

/**
 * http异常
 * @author  GG boy
 * @date  2020/7/14 17:08
 * @version 1.0
 */
public class HttpException(val httpResultEnum: HttpResultEnum)
    : RuntimeException() {

}