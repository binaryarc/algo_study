package algo0902;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution_7465_창용마을무리개수 {
    static int N,M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1 ; tc<=T ; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N+1];
            visited = new boolean[N+1];
            for(int i=1;i<=N;i++)list[i] = new ArrayList<Integer>();
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                list[to].add(from);
            }
            int ans=0;
            for(int i=1;i<=N;i++) {
                if(!visited[i]) {
                    dfs(i);
                    ans++;
                }
                 
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int from) {
         
        for(Integer to : list[from]) {
            if(!visited[to]) {
                visited[to] = true;
                dfs(to);
            }
        }
         
         
    }
}