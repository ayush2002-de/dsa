import java.lang.reflect.Array;
import java.util.ArrayList;

public class day2 {
    static void helper(ArrayList<String>arr,ArrayList<String>ans,String c){
        if(arr==null)return;
        for(String s:arr){
            ans.add(c+s);
        }
    }
    static ArrayList<String> mazePathHVD(int sr,int sc,int tr,int tc){
        if(sr==tr && sc==tc){
          ArrayList<String>ans=new ArrayList<>();
          ans.add("");
          return ans;
        }
        if(sr>tr || sc> tc){
            return null;
        }
       ArrayList<String>horizontal=mazePathHVD(sr, sc+1, tr, tc);
       ArrayList<String>vertical=mazePathHVD(sr+1, sc, tr, tc);
       ArrayList<String>diagonal=mazePathHVD(sr+1, sc+1, tr, tc);
       ArrayList<String>ans=new ArrayList<>();
       helper(horizontal,ans,"H");
       helper(vertical,ans,"V");
       helper(diagonal,ans,"D"); 
       return ans;
       
    }
    static void mazePathHVD(int sr,int sc,int tr,int tc,ArrayList<String>ans,StringBuilder sb ){
        if(sr==tr && sc==tc){
            String s=sb.toString();
            ans.add(s);
            return ;
        }

        if(sr>tr || sc>tc)return;

        sb.append('H');
        mazePathHVD(sr, sc+1, tr, tc, ans, sb);
        sb.deleteCharAt(sb.length()-1);
         sb.append('V');
        mazePathHVD(sr+1, sc, tr, tc, ans, sb);
        sb.deleteCharAt(sb.length()-1);
         sb.append('D');
        mazePathHVD(sr+1, sc+1, tr, tc, ans, sb);
        sb.deleteCharAt(sb.length()-1);

    }
    static ArrayList<String> mazePathHVDMulti(int sr,int sc,int tr,int tc){
        if(sr==tr && sc==tc){
          ArrayList<String>ans=new ArrayList<>();
          ans.add("");
          return ans;
        }
        if(sr>tr || sc> tc){
            return null;
        }
       ArrayList<String>ans=new ArrayList<>();

       for(int i=1;i<=Math.max(tr,tc);i++){
          ArrayList<String>horizontal=mazePathHVDMulti(sr, sc+(1*i), tr, tc);
          ArrayList<String>vertical=mazePathHVDMulti(sr+(1*i), sc, tr, tc);
          ArrayList<String>diagonal=mazePathHVDMulti(sr+(1*i), sc+(1*i), tr, tc);
          
          helper(horizontal,ans,i+"H-");
          helper(vertical,ans,i+"V-");
          helper(diagonal,ans,i+"D-"); 
       }
       
       return ans;
       
    }
    static void mazePathHVDMulti(int sr,int sc,int tr,int tc,ArrayList<String>ans,StringBuilder sb ){
        if(sr==tr && sc==tc){
            String s=sb.toString();
            ans.add(s);
            return ;
        }

        if(sr>tr || sc>tc)return;

        for(int i=1;i<=Math.max(tr,tc);i++){
           sb.append(i+"H");
           mazePathHVDMulti(sr, sc+i, tr, tc, ans, sb);
           sb.delete(sb.length()-2,sb.length());
            sb.append(i+"V");
           mazePathHVDMulti(sr+i, sc, tr, tc, ans, sb);
            sb.delete(sb.length()-2,sb.length());
            sb.append(i+"D");
           mazePathHVDMulti(sr+i, sc+i, tr, tc, ans, sb);
            sb.delete(sb.length()-2,sb.length());
        }
    }
    static int mazePathBetter(int sr,int sc,int tr,int tc,int [][]direction,char[] directionMap,String s){
        if(sr==tr && sc==tc){
            System.out.println(s);
            return 1;
        }
        int count=0;
        for(int i=0;i<direction.length;i++){
            int r=sr+direction[i][0];
            int c=sc+direction[i][1];
            if(r<=tr && c<=tc){
                count+=mazePathBetter(r, c, tr, tc, direction, directionMap, s+directionMap[i]);
            }
        }
        return count;
    }
    static int mazePathMultiBetter(int sr,int sc,int tr,int tc,int [][]direction,char[] directionMap,String s){
        if(sr==tr && sc==tc){
            System.out.println(s);
            return 1;
        }
        int count=0;
        for(int i=0;i<direction.length;i++){
            for(int j=1;j<=Math.max(tr,tc);j++){
                int r=sr+j*direction[i][0];
                int c=sc+j*direction[i][1];
                if(r<=tr && c<=tc){
                    count+=mazePathMultiBetter(r, c, tr, tc, direction, directionMap, s+j+directionMap[i]);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
      int direction[][]={{0,1},{1,0},{1,1},{-1,1}};
      char directionMap[]= {'H','V','D','N'};
      System.out.println(mazePathBetter(0, 0, 2, 2, direction,directionMap,""));

    }
}
// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// https://practice.geeksforgeeks.org/problems/special-matrix4201/1
// https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/?ref=r