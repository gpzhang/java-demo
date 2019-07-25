package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haishen
 * @date 2019/7/21
 * <p>
 * description：广度优先遍历使用队列实现,(无向非连通图)非递归实现.
 * <p>
 * 图的存储结构采用邻接矩阵的表示方式
 */
public class BSF {

    /**
     * 存储节点信息
     */
    private char[] vertices;

    /**
     * 存储边信息（邻接矩阵）
     */
    private int[][] arcs;

    /**
     * 图的节点数
     */
    private int vexnum;

    /**
     * 记录节点是否已被遍历
     */
    private boolean[] visited;

    /**
     * 初始化
     */
    public BSF(int n) {
        vexnum = n;
        vertices = new char[vexnum];
        arcs = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                arcs[i][j] = 0;
            }
        }
    }

    /**
     * 添加边（也叫弧）
     */
    public void addEdge(int i, int j) {
        if (i == j) {
            return;
        }
        arcs[i][j] = 1;
        arcs[j][i] = 1;
    }

    /**
     * 设置元素节点集
     */
    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }

    /**
     * 设置节点访问标记
     */
    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    /**
     * 打印遍历节点
     */
    public void visit(int i) {
        System.out.print(vertices[i] + " ");
    }

    /**
     * 输出邻接矩阵
     */
    public void pritf(int[][] arcs) {
        for (int i = 0; i < arcs.length; i++) {
            for (int j = 0; j < arcs[0].length; j++) {
                System.out.print(arcs[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 实现广度优先遍历
     */
    public void bfs() {
        // 初始化所有的节点的访问标志
        for (int v = 0; v < visited.length; v++) {
            visited[v] = false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        System.out.print("广度优先遍历节点顺序：");
        for (int i = 0; i < vexnum; i++) {
            if (!visited[i]) {                          // 如果节点未访问
                visited[i] = true;
                visit(i);                               // 打印当前已经遍历的节点
                queue.add(i);                           // 添加到队列里面
                while (!queue.isEmpty()) {              // 只要队列不为空
                    int k = queue.poll();               // 节点出队,也就是这一层的节点.
                    for (int j = 0; j < vexnum; j++) {  // 遍历所有未被访问的邻接节点,放入队列
                        if (arcs[k][j] == 1 && !visited[j]) {// 也就是访问这一层剩下的未被访问节点
                            visited[j] = true;
                            visit(j);
                            queue.add(j);
                        }
                    }
                }
            }
        }
        System.out.println("\n邻接矩阵:");
        pritf(arcs);
    }


}
