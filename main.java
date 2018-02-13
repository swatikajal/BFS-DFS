
package org.DfsBfs.org;

import java.io.*;
public class main {

	public static void main(String args[])throws IOException
	{
		
			
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(ir);
			System.out.println("Enter the number of vertices");
			int NumberOfVertices = Integer.parseInt(br.readLine());
			
			//Creating the graph
			graph g = new graph(NumberOfVertices);
			//System.out.println("Enter the vertices and its connection");
			//System.out.print("In the format of V1 V1 with one space");
			
			String exit ="";
	
	//	int arr1[] = {1,1,2,2,3,3,4,4,4,5,6,7,8,8,9,10,10,10};
		//	int arr2[] = {9,10,5,6,4,5,5,8,9,1,10,9,1,2,7,3,5,7};
int arr1[] = {1,2,2,2,3,3,3,4,4,5,5,6,6,7,8,9,9,10};
	int arr2[] = {8,1,3,5,4,9,10,8,10,4,10,5,10,9,9,1,2,6};
		
		//int arr1[] = {1,2,2,2,3,3,4,5,7,7,8,8,8,9,9,9,10,10};
			//  int arr2[] = {8,1,3,7,2,6,2,6,3,8,3,4,9,6,8,10,1,9};
		
			

			
			boolean visited[] = new boolean[11];
			for(int i=0;i<arr1.length;i++){
				g.AddEdge(arr1[i], arr2[i]);
			}
					
			g.BFS(g, 1);
			g.DisplayGraph(g);
			for(int i=1;i<=10;i++){
				System.out.print(i+":"+" ");
				g.PrintPath(1,i);
			}
			System.out.println();
			g.DFS(g, 1,1, visited);
			g.EdgeClassification(arr1, arr2);
			System.out.print("Topological Sort: ");
			g.topologicalSort(g);
		
	}
}
