package algo1023;

import java.io.*;
import java.util.*;

public class Main_11779_최소비용구하기2 {
    static class Vertex{
        int to;
        int w;
        public Vertex(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    static int n,m;
    static List<Vertex>[] v_list;
    static int[] prev;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 개수 - 정점
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 버스의 개수 - 간선
        prev = new int[n+1];
        v_list = new ArrayList[n+1];
        for(int i=1;i<=n;i++)v_list[i] = new ArrayList<Vertex>();
        
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            v_list[from].add(new Vertex(to, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        long res = getMinDist(start,end);
        System.out.println(res);
//        System.out.println(Arrays.toString(prev));
        List<Integer> path = getPath(start, end);
        System.out.println(path.size()); // 경로에 포함된 정점의 수
        for (int city : path) {
            System.out.print(city + " ");
        }
    }
    public static long getMinDist(int start, int end) {
        boolean[] visited = new boolean[n+1];
        int[] minDist = new int[n+1];
        int inf = 987654321;
        for(int i= 1 ;i<=n;i++) {
            minDist[i] = inf;
        }
        minDist[start] = 0 ;
        
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1,o2)->o1.w - o2.w);
        pq.offer(new Vertex(start, 0));
        
        while(!pq.isEmpty()) {
            Vertex cur = pq.poll();
            
            if(visited[cur.to])continue;
            visited[cur.to] = true;
            
            if(cur.to == end)break;
            
            for(Vertex next : v_list[cur.to]) {
                if(minDist[next.to] > minDist[cur.to] + next.w) {
                    minDist[next.to] = minDist[cur.to] + next.w;
                    pq.add(new Vertex(next.to, minDist[next.to]));
                    prev[next.to] = cur.to;
                }
            }
            
        }
        return minDist[end];
    }
    public static List<Integer> getPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            path.add(cur);
            cur = prev[cur];
        }
        Collections.reverse(path); // 역순으로 저장되었으니 경로를 뒤집음
        return path;
    }
}
