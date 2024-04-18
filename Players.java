import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Players {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> loosers = new HashMap<>();
        HashMap<Integer,Integer> winners = new HashMap<>();

        for(int i=0; i<matches.length; i++){
            int win = matches[i][0];
            int lose = matches[i][1];

            if(winners.containsKey(win)){
                winners.put(win, winners.get(win)+1);
            }else{
                winners.put(win,1);
            }

            if(loosers.containsKey(lose)){
                loosers.put(lose, loosers.get(lose)+1);
            }else{
                loosers.put(lose,1);
            }
        }
        List<List<Integer>> out = new ArrayList<>();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for(int p : winners.keySet()){
            if(!loosers.containsKey(p)){
                a.add(p);
            }
        }
        for(int p: loosers.keySet()){
            if(loosers.get(p)==1){
                b.add(p);
            }
        }
        Collections.sort(a);
        Collections.sort(b);
        out.add(a);
        out.add(b);
        return out;
    }
}
