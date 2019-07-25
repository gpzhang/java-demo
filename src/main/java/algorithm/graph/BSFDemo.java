package algorithm.graph;

/**
 * @author haishen
 * @date 2019/7/21
 * description：广度优先遍历使用队列实现,(无向非连通图)非递归实现.
 *
 *
 * demo图
 *
 *              A
 *             /  \
 *            /    \
 *           /      \
 *          /        \
 *         B          F
 *        / \        /\
 *       /   \      /  \
 *      /     \    /    \
 *     /       \ /      \
 *     /        G        \
 *    /       /  \        \
 *   /       I    \        \
 *  /       / \    H        \
 * /       /   \ /           \
 * C-----------D--------------E
 */
public class BSFDemo {

    /**
     * BFS的遍历序列，没有确定起始点就不唯一.这里是A是起点.
     *
     * @param args
     */
    public static void main(String[] args) {
        BSF g = new BSF(9);
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        // 设置顶点集
        g.setVertices(vertices);
        // 添加边
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(1, 8);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 0);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 4);
        g.addEdge(7, 6);
        g.addEdge(8, 1);
        g.addEdge(8, 2);
        g.addEdge(8, 3);
        g.bfs();
    }

}
