package org.DfsBfs.org;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.print.attribute.standard.Finishings;

/*
 * This class creates the graph using the adj
 */
public class graph {
	
	private int nodes;
	private LinkedList<Integer> adjacent[]; 
	boolean  visited[] = new boolean[11];
	int previous[] = new int[11];
	int discoveryTime[] = new int[11];
	int finsihTime[] = new int[11];
	ArrayList<Integer> list = new ArrayList<Integer>();
	int time =0;
	int parent[]= new int[11];
	public graph(int nodes) {
		// TODO Auto-generated constructor stub
		this.nodes = nodes;
		adjacent = new LinkedList[nodes+1];
		for(int i=0;i<=nodes;i++){
			adjacent[i] = new LinkedList<Integer>();
		}
	}
	
	public void AddEdge(int v,int AdjacentVertice ){
		
		adjacent[v].add(AdjacentVertice);
	}
	
	public void DisplayGraph(graph g){
	
		System.out.println("Connected Graph");
		for(int i=0;i<=g.nodes;i++){
			{
				System.out.println("i= "+adjacent[i]);
			}
		}
		
	//	for(int i=1;i<previous.length;i++)
	//	System.out.print(previous[i] + " ");
		System.out.println();
		
	}
	
	public void BFS(graph g,int source){
		
		for(int i=0;i<nodes;i++){
			visited[i] = false;
			previous[i] = -1;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		//previous[source] = source;
		while(queue.size() != 0){
			
			source = queue.poll();
			visited[source] =true;
		
			Iterator<Integer> it = g.adjacent[source].listIterator();
			while(it.hasNext()){
				int n = it.next();
				if (!visited[n])
                {
                    visited[n] = true;
                    previous[n] = source;
                    queue.add(n);
                }
				
			}
		}
	}
	
	public void DFS(graph g, int source,int parentX,boolean visitedD[]){
		visitedD[source] = true;
		time++;
		discoveryTime[source] = time;
		Iterator<Integer> it = g.adjacent[source].listIterator();
		while(it.hasNext()){
			int n = it.next();
			if(!visitedD[n]){
				parent[source] = parentX;
				list.add(source);
				DFS(g,n,source,visitedD);
			}
		}
		time++;
		finsihTime[source] = time;
	    System.out.println("Vertex: " + source + " Discovery: " + discoveryTime[source] + " Finished: " + finsihTime[source]);
	}
	
	
	void topologicalSort(graph g)
    {
        Stack stack = new Stack();
      
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[11];
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
 
       
        for (int i = 1; i < visited.length; i++)
            if (visited[i] == false)
                topologicalSortUtil(g, i, visited, stack);
 
        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
	
	//Topological Sort
	void topologicalSortUtil(graph g,int v, boolean visited[],
            Stack stack)
	{
			// Mark the current node as visited.
			visited[v] = true;
			Integer i;

            // Recur for all the vertices adjacent to this
			// vertex
			Iterator<Integer> it = g.adjacent[v].iterator();
			while (it.hasNext())
			{
				i = it.next();
					if (!visited[i])
						topologicalSortUtil(g,i, visited, stack);
			}

			// Push current vertex to stack which stores result
			stack.push(new Integer(v));
}
	
	public void EdgeClassification(int arr1[],int arr2[]){
		System.out.println();
		System.out.print("Tree Edge: ");
		System.out.print("[");
		for(int i=0;i<arr1.length;i++){
			if((discoveryTime[arr1[i]] < discoveryTime[arr2[i]])  && finsihTime[arr1[i]] > finsihTime[arr2[i]]){
				System.out.print("("+arr1[i]+", "+arr2[i]+")"+", ");
			}
		}
		System.out.println("]");
		
		System.out.print("Back");
		System.out.print("[");
		for(int i=0;i<arr1.length;i++){
			if((discoveryTime[arr1[i]] > discoveryTime[arr2[i]])  && finsihTime[arr1[i]] < finsihTime[arr2[i]]){
				System.out.print("("+arr1[i]+", "+arr2[i]+")"+", ");
			}
		}
		
		System.out.println("]");
		
		System.out.print("Forward Edge");
		System.out.print("[");
		for(int i=0;i<arr1.length;i++){
			if((discoveryTime[arr1[i]] >= discoveryTime[arr2[i]])  && finsihTime[arr1[i]] >= finsihTime[arr2[i]]){
				System.out.print("("+arr1[i]+", "+arr2[i]+")"+", ");
			}
		}
		System.out.println("]");
		
		System.out.print("Cross Edge");
		System.out.print("[");
		for(int i=0;i<arr1.length;i++){
			if((discoveryTime[arr1[i]] > discoveryTime[arr2[i]])  && finsihTime[arr1[i]] > finsihTime[arr2[i]]){
				System.out.print("("+arr1[i]+", "+arr2[i]+")"+", ");
			}
		}
		System.out.println("]");
		
	}
	//This method retraces the path 
	public void PrintPath(int source, int Destination){
		
		ArrayList<Integer> al = new ArrayList<>();
		int currentV = Destination;
		
		while(previous[currentV]!=-1){
			al.add(currentV);
			currentV = previous[currentV];
		}
		al.add(source);
		System.out.print(al.size()-1+" "+"[");
		for(int i=al.size()-1;i>=0;i--){
			System.out.print(al.get(i)+" ");
		}
		System.out.print("]");
		System.out.println("");
	}
}
