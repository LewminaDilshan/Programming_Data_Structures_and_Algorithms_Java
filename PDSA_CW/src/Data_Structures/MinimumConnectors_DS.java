/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Structures;

import DataBase_Access.DB_Access;
import Models.Branches;
import Models.Distances;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author smprs
 */
public class MinimumConnectors_DS 
{
    static Queue<String[]> BranchDistanceQueue;
    static DB_Access db;
    static LinkedList<Branches> branchList = new LinkedList<>();
    static LinkedList<Distances>  distanceList = new LinkedList<>();
    static LinkedList<Distances> userSelectedDistanceList = new LinkedList<>();
    
    
    public MinimumConnectors_DS()
    {
//        branchList = new LinkedList<>();
//        distanceList = new LinkedList<>();
        BranchDistanceQueue = new LinkedList<String[]>();
        //userSelectedDistanceList = new LinkedList<>();
        db = new DB_Access();
    }
    
    public void LoadBranchInfo()
    {
        ResultSet rs = db.BranchInformationLoad();
        try{
            while(rs.next())
            {
                String[] aryRecd = new String[3];
                aryRecd[0] = String.valueOf(rs.getInt(1));
                aryRecd[1] = rs.getString(2);
                aryRecd[2] = rs.getString(3);
                branchList.add(new Branches(  Integer.parseInt(aryRecd[0]), aryRecd[1],  aryRecd[2]));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
     
    public void LoadBranchDistances(JTable jt)
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
                distanceList.add(new Distances(Integer.parseInt(aryRecd[1]),  Integer.parseInt(aryRecd[4]), aryRecd[7]));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : BranchDistanceQueue) { 
            Object[] row = s;
            model.addRow(row);
        }    
    }
    
    static class Graph {
        
        LinkedList<Branches> branchList = new LinkedList<>();
        int vertices;
        double matrix[][];
        
        class ResultSet 
        {
            // will store the vertex(parent) from which the current vertex will reached
            int parent;
            // will store the weight for printing the MST weight
            double weight;
        }
           
        private int searchBranchIndex(int branchId) {
            int i = -1;
            for (Branches b : branchList) {
                if (b.getBranchId() == branchId) {
                    return branchList.indexOf(b);
                }
            }
            return i;
        }

        public Graph(LinkedList<Branches> branchList) {
            this.branchList = branchList;
            this.vertices = branchList.size();

            matrix = new double[branchList.size()][branchList.size()];
        }

        public void addEdge(int source, int destination, double weight) {

            int source_i = searchBranchIndex(source);
            int destination_i = searchBranchIndex(destination);

            if (source_i > -1 && destination_i > -1) {
                //add edge
                matrix[source_i][destination_i] = weight;

                //add back edge for undirected graph
                matrix[destination_i][source_i] = weight;
            }
        }

        //get the vertex with minimum key which is not included in MST
        int getMinimumVertex(boolean[] mst, double[] key) {
            double minKey = Double.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i < vertices; i++) {
                if (mst[i] == false && minKey > key[i]) {
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }
        
        public void primMST(JTextArea txtArea) 
        {
            boolean[] mst = new boolean[vertices];
            ResultSet[] resultSet = new ResultSet[vertices];
            double[] key = new double[vertices];

            //Initialize all the keys to infinity and
            //initialize resultSet for all the vertices
            for (int i = 0; i < vertices; i++) {
                key[i] = Integer.MAX_VALUE;
                resultSet[i] = new ResultSet();
            }

            //start from the vertex 0
            key[0] = 0;
            resultSet[0] = new ResultSet();
            resultSet[0].parent = -1;

            //create MST
            for (int i = 0; i < vertices; i++) {

                //get the vertex with the minimum key
                int vertex = getMinimumVertex(mst, key);

                //include this vertex in MST
                mst[vertex] = true;

                //iterate through all the adjacent vertices of above vertex and update the keys
                for (int j = 0; j < vertices; j++) {
                    //check of the edge
                    if (matrix[vertex][j] > 0) {
                        //check if this vertex 'j' already in mst and
                        //if no then check if key needs an update or not
                        if (mst[j] == false && matrix[vertex][j] < key[j]) {
                            //update the key
                            key[j] = matrix[vertex][j];
                            //update the result set
                            resultSet[j].parent = vertex;
                            resultSet[j].weight = key[j];
                        }
                    }
                }
            }
            //print mst
            printMST(resultSet,txtArea);
        }

        public void printMST(ResultSet[] resultSet,JTextArea txtArea) {
            int total_min_weight = 0;
            txtArea.setText(txtArea.getText() + "************************Minimum Spanning Tree************************\n\n");
            for (int i = 1; i < vertices; i++) {
                 txtArea.setText(txtArea.getText()+branchList.get(i).getBranchName() + " - " + branchList.get(resultSet[i].parent).getBranchName() + "  ------> Distance : " + resultSet[i].weight+"\n\n");
                total_min_weight += resultSet[i].weight;
            }
            txtArea.setText(txtArea.getText()+"***********************************************************************");
            txtArea.setText(txtArea.getText()+"\n\nTotal Distance : " + total_min_weight);
        }
    }
    
    public void FindDefaultMinimumSpaningTree(JTextArea txtArea)
    {
        Graph graph = new Graph(branchList);
        distanceList.forEach((d) -> {
            graph.addEdge(d.getFromBranchId(), d.getToBranchId(), Double.parseDouble(d.getDistance()));
        });
        graph.primMST(txtArea);
    }
    
    public void FindMinimumSpaningTree(JTextArea txtArea, JTable jt)
    {
        Queue<String[]> selectedBranchDistances = new LinkedList<String[]>();;
        
        int[] indexes = jt.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        for (int i = 0; i < indexes.length; i++) {           
            for(String[] s : BranchDistanceQueue) { 
                if(s[0].equals(model.getValueAt(indexes[i], 0)))
                {
                    selectedBranchDistances.add(s);
                }
            }
        }
        
        Graph graph = new Graph(branchList);
        userSelectedDistanceList.clear();
        selectedBranchDistances.forEach((s) -> {
        userSelectedDistanceList.add(new Distances(Integer.parseInt(s[1]),  Integer.parseInt(s[4]),s[7]));
        });
        userSelectedDistanceList.forEach((d) -> {
            graph.addEdge(d.getFromBranchId(), d.getToBranchId(), Double.parseDouble(d.getDistance()));
        });
        graph.primMST(txtArea);
    }
}
