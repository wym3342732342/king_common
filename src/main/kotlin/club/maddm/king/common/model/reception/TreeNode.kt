package club.maddm.king.common.model.reception

import java.lang.Exception

/**
 * 树形节点接口
 * @author  GG boy
 * @date  2020/7/10 11:28
 * @version 1.0
 */
public interface TreeNode {
    var key: String
    var title: String
    var pid: String
    var children:List<TreeNode>
}