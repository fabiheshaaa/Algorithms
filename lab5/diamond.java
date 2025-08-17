//You are given a 2D grid with R
// rows and H
// columns.

//Each cell in the grid is one of the following:
//. — Empty cell: You can move into this cell.
//D — Cell with a diamond: You can move into this cell and collect the diamond.
//# — Obstacle: You cannot move into this cell.
//You may start from any non-obstacle cell and move in the four directions: up, down, left, or right. Your goal is to choose a starting cell such that you can collect the maximum number of diamonds

//Input
//The first line contains two integers R and H (1≤R,H≤1000)
// — the number of rows and columns of the grid. The next R lines each contain H
// characters, describing the grid.

//Output
//Print a single integer — the maximum number of diamonds you can collect starting from a valid cell.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class diamond {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input1= br.readLine().split(" ");
        int rows= Integer.parseInt(input1[0]);
        int col= Integer.parseInt(input1[1]);

        char[][] arr= new char[rows][col]; 
        for(int i= 0;i< rows; i++){
            arr[i]=br.readLine().toCharArray();
        }           

        boolean [][] check= new boolean[rows][col];
        int max=0;
        
        int[] dr = {-1, 1, 0, 0}; 
        int[] dc = {0, 0, -1, 1};

        for( int i=0; i<rows;i++){
            for( int j=0;j<col; j++){
                if(!check[i][j] && arr[i][j] !='#'){
                    int diams=0;
                    Queue<int[]> queue= new LinkedList<>();
                    queue.add(new int[]{i,j});
                    check[i][j]= true;

                    while(!queue.isEmpty()){
                        int[]cell= queue.poll();
                        int r= cell[0];
                        int c= cell[1];
                        if(arr[r][c]=='D') diams++;

                         for (int k =0; k < 4; k++) {
                            int nr =r+ dr[k];
                            int nc =c+ dc[k];
                            if (nr>=0 && nr<rows && nc>=0 && nc<col && !check[nr][nc] && arr[nr][nc] != '#'){
                                check[nr][nc]=true;
                                queue.add(new int[]{nr,nc});
                            }
                        }
                    }
                    max = Math.max(max,diams);
                }                                                             
            }
        }
        System.out.println(max);

    }
}
