// Rectangular Pasture (Java)
// Jacob Liu (cenamuch)
// Submitted: Mon, Dec 21, 2020 16:05:37 EST
// Contest: USACO 2020 December Contest, Silver


import java.io.*;
import java.util.*;
public class rectangle {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());
        Pair[] coords = new Pair[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            coords[i] = new Pair(a, b);
        }
        Arrays.sort(coords);

        int[][] prefix = new int[n+1][n+1];
        

        long sum=n+1;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int above = 1;
                int below = 1;
                for(int k = i+1; k < j; k++) {
                    if(coords[k].y>coords[i].y && coords[k].y>coords[j].y) {
                        above++;
                    } else if (coords[k].y<coords[i].y && coords[k].y<coords[j].y) {
                        below++;
                    }
                }
                sum+=(above*below);
            }
        }
        System.out.println(sum);

    }
    static class Pair implements Comparable<Pair>{
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
        public int compareTo (Pair c) {
            return x-c.x;
        }
    }
}

