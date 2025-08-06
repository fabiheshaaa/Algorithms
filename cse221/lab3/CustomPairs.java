
import java.util.*;

public class CustomPairs {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> arr=new ArrayList<>();

        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }

        long[]cnt=new long[1];
        divide(arr,0,n-1,cnt);
        System.out.println(cnt[0]);
    }

    static void divide(List<Integer>arr,int l,int r,long[]cnt){
        if(l<r){
            int m=(l+r)/2;
            divide(arr,l,m,cnt);
            divide(arr,m+1,r,cnt);
            count(arr,l,m,r,cnt);
            combine(arr,l,m,r);
        }
    }

    static void count(List<Integer>arr,int l,int m,int r,long[]cnt){
        sortByAbs(arr,m+1,r);
        int i=l,j=m+1,mid=m+1;
        while(i<=m&&j<=r){
            long sq=(long)arr.get(j)*arr.get(j);
            if(arr.get(i)>sq){
                cnt[0]+=(mid-i);
                j++;
            }else{
                i++;
            }
        }
    }

    static void combine(List<Integer>arr,int l,int m,int r){
        sortSection(arr,m+1,r);
        glue(arr,l,m,r);
    }

    static void mergeRun(List<Integer>arr,int l,int m,int r,int i,int j){
        List<Integer>tmp=new ArrayList<>();
        while(i<=m&&j<=r){
            if(arr.get(i)<=arr.get(j)){
                tmp.add(arr.get(i++));
            }else{
                tmp.add(arr.get(j++));
            }
        }
        placeSorted(arr,l,m,r,i,j,tmp);
    }

    static void sortByAbs(List<Integer>arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            sortByAbs(arr,l,m);
            sortByAbs(arr,m+1,r);
            mergeByAbs(arr,l,m,r);
        }
    }

    static void mergeByAbs(List<Integer>arr,int l,int m,int r){
        int i=l,j=m+1;
        List<Integer>tmp=new ArrayList<>();
        while(i<=m&&j<=r){
            int a=Math.abs(arr.get(i));
            int b=Math.abs(arr.get(j));
            if(a<b||(a==b&&arr.get(i)<arr.get(j))){
                tmp.add(arr.get(i++));
            }else{
                tmp.add(arr.get(j++));
            }
        }
        placeSorted(arr,l,m,r,i,j,tmp);
    }

    static void placeSorted(List<Integer>arr,int l,int m,int r,int i,int j,List<Integer>tmp){
        while(i<=m)tmp.add(arr.get(i++));
        while(j<=r)tmp.add(arr.get(j++));
        for(int k=0;k<tmp.size();k++){
            arr.set(l+k,tmp.get(k));
        }
    }

    static void sortSection(List<Integer>arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            sortSection(arr,l,m);
            sortSection(arr,m+1,r);
            glue(arr,l,m,r);
        }
    }

    static void glue(List<Integer>arr,int l,int m,int r){
        int i=l,j=m+1;
        mergeRun(arr,l,m,r,i,j);
    }
}
