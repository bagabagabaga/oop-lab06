package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private int nodesNum;
    private int edgeNum;
    Set<N> nodeList;
    Set<> edgeList;

    public GraphImpl(){
        nodeList = new HashSet<N>();
        edgeList = new HashSet<>();
    }

    public void addNode(N node){
        nodeList.add(node);
    }

    public void addEdge(N source, N target){

    }

    public Set<N> nodeSet(){

    }

    public Set<N> linkedNodes(N node){

    }

    public List<N> getPath(N source, N target){

    }
    
}
