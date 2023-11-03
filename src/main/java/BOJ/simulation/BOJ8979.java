package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class BOJ8979_Country {
    int id;
    int gold;
    int silver;
    int bronze;

    public BOJ8979_Country(int id, int gold, int silver, int bronze) {
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}

public class BOJ8979 {
    static List<BOJ8979_Country> countries = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int targetCountry = 0;

        for(int i = 0; i < n; i++){
            input = br.readLine().split(" ");

            int id  = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze = Integer.parseInt(input[3]);

            if(id == k) targetCountry = i;

            BOJ8979_Country country = new BOJ8979_Country(id, gold, silver, bronze);
            countries.add(country);
        }

        System.out.println(getRank(n, targetCountry));
    }

    public static int getRank(int n, int targetCountry){
        int rank = 0;

        for(int i = 0; i < n; i++){
            BOJ8979_Country currnet = countries.get(i);
            BOJ8979_Country target = countries.get(targetCountry);

            if(i != targetCountry){
                if(currnet.gold > target.gold)
                    rank++;
            }

            else if(currnet.gold == target.gold){
                if(currnet.silver > target.silver)
                    rank++;
            }

            else if(currnet.silver == target.silver){
                if(currnet.bronze > target.bronze)
                    rank++;
            }
        }

        return rank + 1;
    }
}
