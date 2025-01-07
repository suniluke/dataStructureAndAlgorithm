package Strings;

import java.util.HashMap;

public class MinWindowSubString {

    public String minWindow(String s, String t) {
        int l=0;
        HashMap<Character,Integer> tmap=new HashMap<>();
        int cnt=0;
        int sindex=-1;
        int minlen=Integer.MAX_VALUE;
        String st="";
        for(int i=0;i<t.length();i++){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for(int r=0; r < s.length(); r++){
            char ch=s.charAt(r);
            if(tmap.containsKey(ch) && tmap.get(ch)>0){
                cnt++;
            }
            tmap.put(ch,tmap.getOrDefault(ch,0)-1);
            while(cnt==t.length()){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    sindex = l;
                }
                tmap.put(s.charAt(l),tmap.get(s.charAt(l))+1);
                if(tmap.get(s.charAt(l))>0){
                    cnt--;
                }
                l++;
            }
        }
        return sindex==-1?"":s.substring(sindex,sindex+minlen);
    }

    public static void main(String[] args) {
        MinWindowSubString sol = new MinWindowSubString();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + sol.minWindow(s, t));
    }
}
