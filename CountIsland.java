
/*																     Count Islands
																      ----------------
																	
A group of connected 1s forms an island now your task is to return the number of islands present.

Input:
The first line of input will be the no of test cases T then T test cases follow.
The first line of each test case contains Two space separated integers N and M.
Then in the next line are the NxM inputs of the matrix A separated by space .

Output:
The output in the expected output will be the total no of islands present.

Constraints:
1 <= T <= 100
1 <= N, M <= 50
0 <= A[i][j] <= 1

Example:
Input
1
3 3
1 1 0 0 0 1 1 0 1

Output
2

Explanation:
Testcase 1: The graph will look like
1 1 0
0 0 1
1 0 1
Here,  two islands will be formed
First island will be formed by elements { A[0][0] ,  A[0][1], A[1][2], A[2][2] }
Second island will be formed by  { A[2][0] }

*/																	
																	









import java.util.*;
import java.lang.*;
import java.io.*;


class CountIslands
 {
     
    static boolean visited[][]; 
    static int arr[][]; 
    
    //for making pair of x and y...
    static class Pair
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    
    
    //for the validiation of coordinate.....
    public static boolean isSafe(int x,int y,int n,int m)
    {
        if((x>=0)&&(x<n)&&(y>=0)&&(y<m)&&(arr[x][y]==1)&&(visited[x][y]==false))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
     
    public static void BFS(int arr[][],int n,int m)
    {
        Queue <Pair> q=new LinkedList <Pair>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((arr[i][j]==1)&&(visited[i][j]!=true))
                {
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    count++;
                    while(q.isEmpty()!=true)
                    {
                        Pair p=q.poll();
                        int x=p.x;
                        int y=p.y;
                        
                        //up
                        if(isSafe(x-1,y,n,m)==true)
                        {
                          q.add(new Pair(x-1,y));
                          visited[x-1][y]=true;
                        }
                        
                        //down
                        if(isSafe(x+1,y,n,m)==true)
                        {
                          q.add(new Pair(x+1,y));
                          visited[x+1][y]=true;
                        }
                        
                        //left
                        if(isSafe(x,y-1,n,m)==true)
                        {
                          q.add(new Pair(x,y-1));
                          visited[x][y-1]=true;
                        }
                        
                        //right
                        if(isSafe(x,y+1,n,m)==true)
                        {
                          q.add(new Pair(x,y+1));
                          visited[x][y+1]=true;
                        }
                        
                        //up-left
                        if(isSafe(x-1,y-1,n,m)==true)
                        {
                          q.add(new Pair(x-1,y-1));
                          visited[x-1][y-1]=true;
                        }
                        
                        //up-right
                        if(isSafe(x-1,y+1,n,m)==true)
                        {
                          q.add(new Pair(x-1,y+1));
                          visited[x-1][y+1]=true;
                        }
                        
                        //down left
                        if(isSafe(x+1,y-1,n,m)==true)
                        {
                          q.add(new Pair(x+1,y-1));
                          visited[x+1][y-1]=true;
                        }
                        
                        //down right
                        if(isSafe(x+1,y+1,n,m)==true)
                        {
                          q.add(new Pair(x+1,y+1));
                          visited[x+1][y+1]=true;
                        }
                        
                    }
                }
            }
        }
        System.out.println(count);
    }
     
     
	public static void main (String[] args)
	 {
	   Scanner in=new Scanner(System.in);
	   int t=in.nextInt();
	   for(int k=0;k<t;k++)
	   {
	     int n=in.nextInt();
	     int m=in.nextInt();
	     arr=new int[n][m];
	     visited=new boolean[n][m];
	     for(int i=0;i<n;i++)
	     {
	         for(int j=0;j<m;j++)
	         {
	              arr[i][j]=in.nextInt();       
	         }
	     }
	     BFS(arr,n,m);
	   }
    }
}
