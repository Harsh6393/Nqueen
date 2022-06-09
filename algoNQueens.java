import java.util.*;
import java.util.Scanner;

public class algoNQueens {
    public static void main(String[] args){
        System.out.println("enter the no of Queens :");
       Scanner sc = new Scanner(System.in);
      // System.out.println("enter the no of Queens :");
       int n = sc.nextInt();
      int[][] arr=new int[n][n];
      if(recursiveNQueens(arr,0,n)==true){
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 System.out.print(arr[i][j]+" ");
             }
             System.out.println();
         }
      }
    }
public static boolean issafe(int x,int y,int[][] arr,int n){
    for(int row=0;row<x;row++){
        if(arr[row][y]==1){
            return false;
        }
    }
    int row=x;
    int col=y;
    while(row>=0 && col>=0){
        if(arr[row][col]==1)return false;
        col--;
        row--;
    }
    row=x;
    col=y;
    while(row>=0 && col<n){
        if(arr[row][col]==1)return false;
        row--;
        col++;
    }
    return true;
}
    public static boolean recursiveNQueens(int[][] arr,int r,int n){
       
        if(r>=n){
           return true;
        }
        for(int col=0;col<n;col++){
            if(issafe(r,col,arr,n)){
                arr[r][col]=1;
                if(recursiveNQueens(arr,r+1,n)){
                    return true;
                }
                arr[r][col]=0;   //backtracking
            }
        }
        return false;
    }
}