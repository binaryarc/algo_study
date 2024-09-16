package algo0902;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_이진호 {
    static class Node{
        int r,c;
        public Node(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, M;
    static int[][] map;
    static ArrayList<Node> nodeList;
    static ArrayList<Node> virusList;
    static boolean[][] visited;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virusList = new ArrayList<Node>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)virusList.add(new Node(i,j));
            }
        }
        nodeList = new ArrayList<>();
        ans = 0;
        combi(0,0);
        System.out.println(ans);
    }
    public static void combi(int cnt,int start) {
        if(cnt == 3 ) {
        	for(Node node : nodeList)map[node.r][node.c] = 1;
            bfs();
            for(Node node : nodeList)map[node.r][node.c] = 0;
            return;
        }
        
        for(int idx = start ; idx < N * M ; idx++) {
            int r = idx / M;
            int c = idx % M;
            if(map[r][c] == 0) {
                nodeList.add(new Node(r,c));
                combi(cnt+1, idx+1);
                nodeList.remove(nodeList.size() - 1);
            }
        }
    }
    
    public static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        for(Node n : virusList)q.offer(n);
        visited = new boolean[N][M];
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i=0;i<4;i++) {
                int nr = cur.r + dx[i];
                int nc = cur.c + dy[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || 
                        visited[nr][nc] || map[nr][nc] == 1)continue;
                visited[nr][nc] = true;
                q.offer(new Node(nr,nc));
            }
            
        }
        
        int cnt=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(!visited[i][j] && map[i][j] == 0 ) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

}