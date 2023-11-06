package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Stack;
import java.util.ArrayList;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private int nodesNum;
    private int edgeNum;
    private Set<N> nodeList;
    private HashMap<N, Collection<N>> edgeList;

    public GraphImpl(){
        nodeList = new TreeSet<N>();
        edgeList = new HashMap<N, Collection<N>>();
        nodesNum = 0;
        edgeNum = 0;
    }

    public void addNode(N node){
        nodeList.add(node);
        nodesNum++;
    }

    public void addEdge(N source, N target){
        Collection<N> sourceSet = edgeList.get(source);
        if(sourceSet == null){
            sourceSet = new HashSet<N>();
        }
        if(sourceSet.add(target)){
            edgeList.put(source, sourceSet);
            edgeNum++;
        }
    }

    public Set<N> nodeSet(){
        return nodeList;
    }

    public Set<N> linkedNodes(N node){
        Set<N> tmp = new HashSet<N>();
        for(N n : edgeList.get(node)){
            tmp.add(n);
        }
        return tmp;
    }

    public List<N> getPath(N source, N target){
        N actualNode = null;
        Collection<N> discovered = new TreeSet<N>();
        List<N> result = new ArrayList<N>();
        Stack<N> stack = new Stack<N>();
        
        stack.push(source);
        while(!stack.isEmpty()){
            actualNode = stack.pop();
            if(!discovered.contains(actualNode)){
                discovered.add(actualNode);
                result.add(actualNode);
                if(actualNode.equals(target)){
                    break;
                }
                for(N n : edgeList.get(actualNode)){
                    stack.push(n);
                }
            }
        }
        return result;
    }
    
}
