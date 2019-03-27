package com.lena.pojo;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeBulder {
    public static List<TreeNode> build(List<TreeNode> treeNodes,Integer topId){
        List<TreeNode> nodes =new ArrayList<>();
        for (TreeNode treeNode:treeNodes) {
            if(treeNode.getPid()==topId){
                nodes.add(treeNode);
            }
            for (TreeNode node:treeNodes) {
                if(node.getPid()==treeNode.getId()){
                   treeNode.getChildren().add(node);
                }
            }
        }
        return  nodes;
    }
}
