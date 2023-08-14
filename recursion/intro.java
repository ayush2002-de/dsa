import java.util.ArrayList;
import java.util.*;

class intro{
    static void printIncreasing(int a,int b){
        if(a==b)return ;
        System.out.println(a);
        printIncreasing(a+1, b);
    }

    static void printDecreasing(int a,int b){
      if(a==b)return ;
      printDecreasing(a+1, b);
      System.out.println(a);
    }
    static void printIncreasingDecreasing(int a,int b){
       if(a==b)return ;
       System.out.println(a);
       printIncreasingDecreasing(a+1, b);
       System.out.println(a);
    }

    static void printOddEven(int a,int b){
       if(a==b)return ;
       if(a%2!=0)System.out.println(a);
       printOddEven(a+1, b);
       if(a%2==0)System.out.println(a);
    }
    static int factorial(int n){
      return n==0?1:factorial(n-1)*n;
    }

    static int power(int a,int b){
      if(b==0)return 1;
      return power(a,b-1)*a;
    }

    static int powerBetter(int a,int b){
      if(b==0)return 1;
      int ans = powerBetter(a, b/2);
      int res=ans*ans;
      return b%2==0?res:res*a;
    }

    static void display(int arr[],int idx){
        if(idx==arr.length)return;
        System.out.println(arr[idx]);
        display(arr,idx+1);
    }

    static void displayReverse(int arr[],int idx){
      if(idx==arr.length)return;
      displayReverse(arr,idx+1);
      System.out.println(arr[idx]);
    }

    static int max(int arr[],int idx){
      if(idx==arr.length)return Integer.MIN_VALUE;
      int val=max(arr,idx+1);
      return Math.max(val,arr[idx]);
    }

    static int min(int arr[],int idx){
      if(idx==arr.length)return Integer.MAX_VALUE;
      int val=min(arr,idx+1);
      return Math.min(val,arr[idx]);
    }

    static int find(int arr[],int idx,int data){
      if(idx==arr.length)return -1;
      if(arr[idx]==data)return idx;
      return find(arr,idx+1,data);
    }

    static int firstIndex(int arr[],int idx,int data){
      if(idx==arr.length)return -1;
      if(arr[idx]==data)return idx;
      return firstIndex(arr,idx+1,data);
    }

    static int lastIndex(int arr[],int idx,int data){
      if(idx==arr.length)return -1;
      int ans=lastIndex(arr,idx+1,data);
      if(ans!=-1)return ans;
      return arr[idx]==data?idx:-1;
    }

    static int[] allIndex(int arr[],int idx,int data,int count){
      if(idx==arr.length){
        int base[]=new int[count];
        return base;
      }
      if(arr[idx]==data)count++;
      int ans[]=allIndex(arr,idx+1,data,count);
      if(arr[idx]==data)ans[count-1]=idx;
      return ans;
    }

   static ArrayList<String>subSeq(String s,int idx,StringBuilder sb){
       if(idx==s.length()){
          ArrayList<String>ans=new ArrayList<>();
          String s1=sb.toString();
          ans.add(s1);
          return ans;
       }
       sb.append(s.charAt(idx));
       ArrayList<String>inc=subSeq(s, idx+1, sb);
       sb.deleteCharAt(sb.length()-1);
       ArrayList<String>exc=subSeq(s, idx+1, sb);
       inc.addAll(inc.size()-1,exc);
       return inc;
   }

  static ArrayList<String>subSeq1(String s,int idx){
      if(idx==s.length()){
        ArrayList<String>ans=new ArrayList<>();
        ans.add("");
        return ans;
      }
      ArrayList<String>res=subSeq1(s,idx+1);
      ArrayList<String>ans=new ArrayList<>();
      for(String s1:res){
        ans.add(s1);
        ans.add(s.charAt(idx)+s1);
      }
      return ans;
   }

   static ArrayList<String>kpc(String s,String[] pattern,int idx){
      if(idx==s.length()){
        ArrayList<String>help=new ArrayList<>();
        help.add("");
        return help;
      }
      ArrayList<String>res=kpc(s,pattern,idx+1);
      int val=s.charAt(idx)-'0';
      ArrayList<String>ans=new ArrayList<>();
      for(String s1:res){
        for(char a:pattern[val].toCharArray()){
           ans.add(s1+a);
        }
      }
      return ans;

   }

    static int print (int n){
      if(n==0||n==1){
        System.out.println("base: "+ n);
        return n;
      }
      int ans=0;
      System.out.println("pre: "+n);
      ans+=print(n-1);
      System.out.println("in: "+n);
      ans+=print(n-2);
      System.out.println("post: "+n);
      return ans+3;
    }


    public static void main(String[] args) {
       ArrayList<String>ans=kpc("7896",new String[]{".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"},0);
       for(String s:ans)System.out.println(s);
    }
}