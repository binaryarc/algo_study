package algo1103;
import java.io.*;
import java.util.*;

public class Main_HAST_출퇴근길 {
    static int N,M;
    static List<Integer>[] graph,reverseGraph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N + 1];
        for(int i=1;i<=N;i++) {
        	graph[i] = new ArrayList<Integer>();
        	reverseGraph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            
            
            //출, 퇴근길이 연결되는지 확인할 용도의 그래프
            //기존 graph 에서 집 -> 회사 로 가는 지점이 아니라도 
            //경로에 방문처리가 되어있을수 있기때문에
            reverseGraph[to].add(from); // 역방향 그래프 생성
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        boolean[] visited1 = new boolean[N+1];
        boolean[] visited2 = new boolean[N+1];
        
        
        visited1[end] = true;
        visited2[start]=true;
        
        dfs(start, visited1, graph);
        dfs(end, visited2, graph);
        
        boolean[] visited3 = dfs(start, new boolean[N+1], reverseGraph);
        boolean[] visited4 = dfs(end, new boolean[N+1], reverseGraph);
        
        int cnt = 0;
        for(int i=1;i<=N;i++) {
        	if(visited1[i] && visited2[i] && visited3[i] && visited4[i]) {
        		cnt++;
        	}
        }
        
        System.out.println(cnt-2);
        
    }
    
    static boolean[] dfs(int start, boolean[] visited ,List<Integer>[] graph) {
    	if(visited[start])return visited;
    	else {
    		visited[start] = true;
    	}
    	
    	for(int next : graph[start]) {
    		dfs(next,visited,graph);
    	}
    	return visited;
    }
}