// Stuck in a Rut (Java)
// Jacob Liu 
// Submitted: Mon, Dec 21, 2020 15:15:34 EST
// Contest: USACO 2020 December Contest, Silver

import java.io.*;
import java.util.*;
public class stuckrut {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());

        Cow[] cows = new Cow[n];

        TreeSet<Cow> northCow = new TreeSet<Cow>(new Comparator<Cow>() {
            @Override
            public int compare(Cow c1, Cow c2) {
                return c1.x - c2.x;
            }
        });
        TreeSet<Cow> eastCow = new TreeSet<Cow>(new Comparator<Cow>() {
            @Override
            public int compare(Cow c1, Cow c2) {
                return c1.y - c2.y;
            }
        });

        for(int i =0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String d = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(d.equals("N")) {
                northCow.add(new Cow(i, x, y, 0));
            } else {
                eastCow.add(new Cow(i, x, y, 1));
            }
        }

//        for(Cow c:northCow) {
//            System.out.println("north: "+ c.x + " " + c.y);
//        } for(Cow c:eastCow) {
//            System.out.println("east: "+ c.x + " " + c.y);
//        }

        for(Cow east: eastCow) {
            Cow north = northCow.higher(east);
//            higher gives the north-facing cow that is just right of the east-facing cow
            while(north != null && !east.stopped){
                east.check(north);
                north = northCow.higher(north);
            }
        }

        int i=0;
        for(Cow c:northCow) {
            cows[i]=c;
            i++;
        }
        for(Cow c:eastCow){
            cows[i]=c;
            i++;
        }
        Arrays.sort(cows);
        for(Cow c: cows) {
            System.out.println(c.ctr);
        }



    }

    static class Cow implements Comparable<Cow>{
        public int x;
        public int y;
        public int dir;
        public int id;
        public boolean stopped = false;
        public int ctr = 0;
        //        0 = north, 1 = east
        public Cow(int id, int x, int y, int dir) {
            this.id=id;
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
        public int compareTo (Cow c) {
            return id-c.id;
        }

        public void check(Cow c) {
            if (c.stopped)
                return;
            if (c.y >= y)
                return;
            if (c.x-x < y-c.y) {
                c.stopped = true;
                ctr++;
                ctr+=c.ctr;
            }  else if (c.x-x > y-c.y){
                stopped = true;
                c.ctr++;
                c.ctr+=ctr;
            }
        }
    }
}
