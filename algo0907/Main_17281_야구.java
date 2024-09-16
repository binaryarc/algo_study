package algo0907;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구 {
    static int N;
    static int[][] res;
    static int ans;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        res = new int[N][10];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=9;j++) {
                res[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] selected = new int[9]; //순열로 선택된 선수들 1번은 4번타자 고정 나머지 2~9 순열
        selected[3] = 1;
        ans = 0;
        cnt = 0;
        permutation(0,0,selected);
        System.out.println(ans);
    }

    static void permutation(int cnt,int flag,int[] selected) {
        if(cnt==3) {
            permutation(cnt+1, flag, selected);
            return;
        }
        if(cnt == 9) { //순열 완성시 경기
            ans = Math.max(ans, play(selected));
            return;
        }

        for(int i=2;i<=9;i++) {
            if((flag&1<<i)!=0)continue;
            selected[cnt] = i;
            permutation(cnt+1, flag|1<<i, selected);
        }
    }
    
    
    static int play(int[] selected) {
        int score = 0; //점수
        cnt = 0;
        for(int i=0;i<N;i++) {
        	int out = 0; //아웃카운트
        	int[] ru = new int[4];
            while(out<3) {
                //9번주자 다음은 처음부터 다시시작
                //전이닝의 다음 선수부터 현재이닝에서 시작 해야해서 전역변수로 저장
                int playerIndex = cnt % 9;
                int player = selected[playerIndex];
                if(res[i][player] == 0) { //아웃
                    out++;
                    cnt++;
                    continue;
                }
                if(res[i][player] == 1) { //안타 , 1루씩 진루
                    if(ru[3] > 0)score++;
                    ru[3] = ru[2];
                    ru[2] = ru[1];
                    ru[1] = player;
                }else if(res[i][player] == 2) { //2루타 , 2루씩 진루
                    if(ru[3] > 0)score++;
                    if(ru[2] > 0)score++;
                    ru[3] = 0 ;
                    ru[2] = 0 ;
                    ru[3] = ru[1];
                    ru[2] = player;
                    ru[1] = 0;
                }else if(res[i][player] == 3) { //3루타, 3루씩 진루
                    if(ru[3] > 0)score++;
                    if(ru[2] > 0)score++;
                    if(ru[1] > 0)score++;
                    ru[3] = player;
                    ru[2] = 0 ;
                    ru[1] = 0 ;
                }else if(res[i][player] == 4) { //홈런
                    if(ru[3] > 0)score++;
                    if(ru[2] > 0)score++;
                    if(ru[1] > 0)score++;
                    score++;
                    ru[3] = 0 ;
                    ru[2] = 0 ;
                    ru[1] = 0 ;
                }
                cnt++;
            }
        }
        return score;
    }

}