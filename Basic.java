import java.util.*;

public class Basic
{
    
    
    
   //  for inserting edge in graph........ 
   static void addEdge(ArrayList<ArrayList<Integer>> graph,int x,int y)
   {
       /*
         ArrayList<Integer> l=graph.get(x);
         l.add(y);
         //and also in y as well
         l=graph.get(y);
         l.add(x);
       */
       
       //  OR
   
       graph.get(x).add(y);
       graph.get(y).add(x); 
   }
   
   
   
    
   //BFS in graph...
   public static void BFS(ArrayList<ArrayList<Integer>> graph,int v,int start)
   {
       
       boolean visited []=new boolean[v+1];
       for(int i=0;i<=v;i++)
       {
           visited[i]=false;
       }
       
       int s=start;
       Queue <Integer> q=new LinkedList<Integer> ();
       q.add(s);
       visited[s]=true;
       while(q.isEmpty()!=true)
       {
           int value=q.poll();
           System.out.print(value+" ");
           for(int i=0;i<graph.get(value).size();i++)
           {
               if(visited[graph.get(value).get(i)]==false)
               {
                 q.add(graph.get(value).get(i));
                 visited[graph.get(value).get(i)]=true;
               }
           }   
       }
   }
   
   
   
   public static void main(String args[])
   {
       int v=5;
       ArrayList <ArrayList<Integer>> graph= new ArrayList<ArrayList<Integer>>(v+1);
       for(int i=0;i<v+1;i++)
       {
           graph.add(new ArrayList<Integer>());
       }
       
       int start=2;
       addEdge(graph,2,1);
       addEdge(graph,1,5);
       addEdge(graph,3,1);
       //we can create disconnected grpah by adding edge 4,5 because out of 4 and 5 nothing is here.
      // addEdge(graph,4,5);
      //and our bfs will not print it..
      // we can resolve by doing some simple changes.
       System.out.println("Breadth First Search....");
       BFS(graph,v,start);
   }
}
