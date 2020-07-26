package club.maddm.king.common.model.reception

import java.util.ArrayList

/**
 * 返回前台用的通用树模型
 * @author  GG boy
 * @date  2020/7/10 10:47
 * @version 1.0
 */
public interface TreeBuilder {
    /**
     * 根据集合构建树形--自动寻找顶级节点
     * [data] 继承了TreeNodeTransform接口的对象集合
     */
    public open fun buildTreeNode(data: List<TreeNodeTransform>): List<TreeNode> {
        val treeNodes: ArrayList<TreeNode> = arrayListOf<TreeNode>()
        if (data.isNotEmpty()) {
            val nodeList: List<TreeNode> = data.map(TreeNodeTransform::transform)
            //拿到所有id的集合，构建上级idmap
            val ids: List<String> = nodeList.map(TreeNode::key)
            val pidMap: Map<String, List<TreeNode>> = nodeList.groupBy(TreeNode::pid)

            //找出顶级节点的upId
            val rootNodeIds: List<String> = pidMap.filter { it ->
                !ids.contains(it.key)
            }.map { it ->
                it.key
            }
            treeNodes.addAll(mapToTreeOnRootIds(pidMap, rootNodeIds))
        }
        return treeNodes
    }
    /**
     * 根据 rootIds和upIdMap 构建树形
     */
    private fun mapToTreeOnRootIds(upIdMap: Map<String, List<TreeNode>>, rootIds: List<String>): List<TreeNode>{
        if (rootIds.isNotEmpty()) {
            val rootNodes: ArrayList<TreeNode> = arrayListOf<TreeNode>()
            for (rootId in rootIds) {
                val rt: List<TreeNode> = mapToTreeOnRootId(upIdMap, rootId)
                rootNodes.addAll(rt)
            }
            return rootNodes
        }
        return arrayListOf()
    }

    /**
     * 根据 rootId和upIdMap 构建树形
     */
    private fun mapToTreeOnRootId(upIdMap:Map<String,List<TreeNode>>,rootId:String):List<TreeNode>{
        val rootNodes: List<TreeNode> = upIdMap[rootId]!!
        for (rn in rootNodes) {
            if (upIdMap.containsKey(rn.key)) {
                val chirld: List<TreeNode> = mapToTreeOnRootId(upIdMap, rn.key)//递归
                rn.children = chirld//连接关系
            }
        }
        return rootNodes
    }

    /**
     * 树形转换接口
     */
    public interface TreeNodeTransform{
        fun transform(): TreeNode
    }
}