/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Structures;

import DataBase_Access.DB_Access;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lewmi
 */
class Edge
{
	int source, dest, weight;

	public Edge(int source, int dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
}

class Node {
	int vertex, weight;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

class Graph
{
	// A List of Lists to represent an adjacency list
	List<List<Edge>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N)
	{
		adjList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge edge: edges) {
			adjList.get(edge.source).add(edge);
		}
	}
}

public class ShortestPath_DS {
    Queue<String[]> BranchInfoQueue;
    Queue<String[]> BranchDistanceQueue;
    DB_Access db;
    int NumberOfVertex = 0;
    Graph graph;
    
    public ShortestPath_DS()
    {
        BranchInfoQueue = new LinkedList<String[]>();
        BranchDistanceQueue = new LinkedList<String[]>();
        db = new DB_Access();
    }
    
    public void LoadBranchInfo(JTable jt)
    {
        ResultSet rs = db.BranchInfoLoad();
        BranchInfoQueue.clear();
        try{
            while(rs.next())
            {
                String[] aryRecd = new String[3];
                aryRecd[0] = String.valueOf(rs.getInt(1));
                aryRecd[1] = rs.getString(2);
                aryRecd[2] = rs.getString(3);
                BranchInfoQueue.add(aryRecd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : BranchInfoQueue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void LoadBranchDistances()
    {        
        ResultSet rs = db.BranchDistanceLoad();
        BranchDistanceQueue.clear();
        try{
            while(rs.next())
            {
                String[] aryRecd = new String[8];
                aryRecd[0] = String.valueOf(rs.getInt(1));
                aryRecd[1] = rs.getString(2);
                aryRecd[2] = rs.getString(3);
                aryRecd[3] = rs.getString(4);
                aryRecd[4] = rs.getString(5);
                aryRecd[5] = rs.getString(6);
                aryRecd[6] = rs.getString(7);
                aryRecd[7] = rs.getString(8);
                BranchDistanceQueue.add(aryRecd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        CreateGraph();
    }
    
    private void getRoute(int[] prev, int i, List<Integer> route)
    {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }

    // Run Dijkstra's algorithm on given graph
    public void shortestPath(Graph graph, int source, int N, JTextArea ta)
    {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        List<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
        dist.set(source, 0);

        boolean[] done = new boolean[N];
        done[source] = true;

        int[] prev = new int[N];
        prev[source] = -1;

        List<Integer> route = new ArrayList<>();

        while (!minHeap.isEmpty())
        {
            Node node = minHeap.poll();
            int u = node.vertex;

            for (Edge edge: graph.adjList.get(u))
            {
                int v = edge.dest;
                int weight = edge.weight;

                // Relaxation step
                if (!done[v] && (dist.get(u) + weight) < dist.get(v))
                {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            done[u] = true;
        }
        String fromBranchName = null;
        for(String[] s : BranchInfoQueue) {
            if(s[0].equals(String.valueOf(source)))
            {
                fromBranchName = s[1];
            }
        }
        
        for (int i = 1; i < N; ++i)
        {
            String ToBranchName = null;
            if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                getRoute(prev, i, route);
                for(String[] s : BranchInfoQueue) {
                    if(s[0].equals(String.valueOf(i)))
                    {
                        ToBranchName = s[1];
                    }
                }
                ta.setText(ta.getText() + "\n" + "From Branch : " + fromBranchName + "    To Branch : " + ToBranchName + "    |    Distance : " + dist.get(i) + "    |    Route :" + route);
                route.clear();
            }
        }
    }
    
    public void CreateGraph()
    {
        ArrayList<Edge> edges =  new ArrayList<Edge>();

        for(String[] s : BranchDistanceQueue) {
            double dist = Double.parseDouble(s[7]);
            edges.add(new Edge(Integer.parseInt(s[1]), Integer.parseInt(s[4]), (int)dist));
            edges.add(new Edge(Integer.parseInt(s[4]), Integer.parseInt(s[1]), (int)dist));
        }

        // Set number of vertices in the graph

        ResultSet rs2 = db.GetDistancesCount();
        BranchDistanceQueue.clear();
        try{
            while(rs2.next())
            {
                NumberOfVertex = rs2.getInt(1) + 1;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // construct graph
        graph = new Graph(edges, NumberOfVertex);
    }
    
    public void PrintShortestPath(JTextArea ta, int source)
    {    
        shortestPath(graph, source, NumberOfVertex, ta);
    }      
}
