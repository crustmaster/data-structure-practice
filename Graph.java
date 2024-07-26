import java.util.*; 

public class Graph {                //以无向图为例
    private final int V;
    private List<Integer>[] adj;     /*使用的是第3中存储方式：Adjacency lists。*/
    public Graph(int v) {
        V = v;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v=0; v<V; v++) { adj[v]=new ArrayList<Integer>(); }
    }
    public void addEdge(int v, int w) { adj[v].add(w); adj[w].add(v); }     /*假设是无向图，add()是arraylist类的built-in方法。*/
    Iterable<Integer> adj(int v) { return adj[v]; }
    int V();
    int E();
    
    /*DFS遍历start_vertex可以连接到的所有点。*/
    public List<Integer> DFS_findVertices(int start) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();
        findVerticesUtil(start, visited, result);
    }
    public void findVerticesUtil(int current, boolean[] visited, List<Integer> result) {
        visited[current] = true;
        result.add(current);
        for (int neighbor : adj[current]) {   
            if (!visit[neighbor]) { findVerticesUtil(neighbor, visited, result); }
        }
    }
     
    /*DFS遍历从start_vertex到end_vertex的所有路径，并打印最短路径。*/
    public List<Integer> DFS_findShortestPath(int start, int end) {
        boolean[] visited = new boolean[V];
        List<Integer> path = new ArrayList<>();               /*保存当前正在寻找、探索的path*/
        List<List<Integer>> allPaths = new Arraylist<>();    /*创建一个ArrayList，每个位置都一个是list形式保存的path。用于保存合格的path*/
        path.add(start);
        findAllPathsUtil(start, end, visited, path, allPaths);  
        
        List<Integer> shortestPath = null;            /*从allPaths中打印shortestpah。*/
        for (List<Integer> p : allPaths) {
            if ( shortestPath = null || p.size() < shortestPash.size() ) { shortestPath = p; }
        }
        return shortestPath;
    }
    public void findAllPathsUtil(int current, int end, boolean[] visited, List<Integer> path, List<List<Integer>> allPaths) {
        if (current == end) { addPaths.add( new ArrayList<>(path) ); return; }  /*如果找到了，则把当前path里存储的路径添加到addPath中去。*/
        visited[current] = true;                 
        for (int neighbor : adj[current]) {            /*对于current的所有neighbor*/
            if (!visited[neighbor]) {              /*如果cureent的这个neighbor是访问过的，则跳过去访问下一个neighbor；如果没有访问过，则接下来：*/
                path.add(neighbor);                /*把cureent的这个neighbor加入path*/
                findAllPathsUtil(neighbor, end, visited, path, allPaths);    /*寻找current+neighbor的接下来的path*/
                path.remove(path.size()-1);        /*这个neighbor接下来的path寻找完之后，回退到current点，准备迎接下一个neighbor。*/
            }
        }
        visited[current] = false;  /*把所有neighbor都遍历完之后，将当前current回退一位。去上一层current遍历它的其他neighbor，直到第一层current=start
        的findAllPathsUtil()运行完，最终结束运行findShortestPath()函数召唤的辅助函数Util。进行下一步打印shortestPath。*/
    }
    
    /*BFS方法遍历start_vertex可以连接到的所有点。*/
    public List<Integer> BFS_findVertices (int start) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();        /*从队列的出口取出一个顶点。*/
            result.add(vertex);           /*从出口出来的都是可以遍历到的vertex，可以遍历到的vertex也都会从出口出来。[有多个地方可以放这行代码]*/
        }
        for (int neighbor : adj[vertex]) {        /*把此vertex还未被访问过neighbor加入以访问list，并把其放入queue以便之后取出。*/
            if (!visited[neighbor]) { visited[neighbor]=true; queue.add(neighbor); }    
        }
    }
    
    /*BFS求start_vertex到end_vertex的最短路径，而不遍历所有路径。*/
    /* 因为其breadth first的特点，不会出现“下层级返回上层级然后再向下”特征的路径出现。所以1：不会遍历所有路径，2:会更快的识别出最短路径。*/
    public List<Integer> BFS_findShortestPath(int start, int end) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Array.fill(parent,-1);                    // 用array来表明每个点被遍历到时其parent是谁，即从哪来的。这样一个array存储了完整的path信息。
        Queue<Integer> queue = new LinkedList<>();        
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end ) { return constructPath(parent, start, end); }    //如果找到了end，则返回存储着“路径信息”的parent。结束BFS函数。
            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                }
            }
        }
        return Collections.emptyList();   // 如果没有找到路径，返回一个不可变的空列表（此方法是java.util.Collections类的一个静态方法）。
    }
    private List<Integer> consturctPath(int[] parent, int start, int end) {
        LinkedList<Integer> path = new LinkedList<>();
        for ( int at=end; at!=-1; at=parent[at] ) { path.addFirst(at); }     // 从终点开始，根据parent节点添加反向路径。
        if (path.getFirst() == start) {return path;}
        return Collections.emptyList();
    }
           
}
