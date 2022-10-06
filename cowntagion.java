// Cowntagion (Java)
// Jacob Liu
// Submitted: Mon, Dec 21, 2020 13:39:52 EST
// Contest: USACO 2020 December Contest, Silver

import java.io.*;
import java.util.*;
public class cowntagion {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());
        int[] connections = new int[n+1];
        connections[1]++;
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connections[a]++;
            connections[b]++;
        }
        int ctr = n-1;
        for(int i = 1; i <= n; i++) {
            int target = connections[i];
            int x = 1;
            int c = 0;
            while(x < target) {
                x*=2  ;
                c++;
            }
            ctr+=c;
        }
        System.out.println(ctr);
    }
}
