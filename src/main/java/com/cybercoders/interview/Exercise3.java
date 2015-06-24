package com.cybercoders.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exercise3 {
    /**
     * Implements a tree data structure, where each node can have an arbitrary number of child nodes.
     */
    public static class TreeNode<T extends Comparable> {
        private T data;
        private List<TreeNode<T>> children;

        public TreeNode(T data) {
            this.data = data;
        }

        public TreeNode(T data, List<TreeNode<T>> children) {
            this.data = data;
            this.children = children;
        }

        public T getData() {
            return data;
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }

        public String printDataItemListInDesiredSortOrder() {
            List<T> dataItemListInDesiredSortOrder = generateDataItemListInDesiredSortOrder();

            // Print the list to standard out, per the task requirements
            System.out.println(dataItemListInDesiredSortOrder);

            // Also return the list as a string, to facilitate testing
            return dataItemListInDesiredSortOrder.toString();
        }

        public List<T> generateDataItemListInDesiredSortOrder() {
            Map<Integer, List<T>> treeNodesToDepthLevelMap = new TreeMap<Integer, List<T>>();
            populateTreeNodesToDepthLevelMap(this, treeNodesToDepthLevelMap, 0);

            List<T> sortedDataItems = new ArrayList<T>();
            for (List<T> dataList : treeNodesToDepthLevelMap.values()) {
                for (T dataItem : dataList) {
                    sortedDataItems.add(dataItem);
                }
            }

            // Note: The class represented by T should have a natural ordering, as imposed by implementing Comparable
            Collections.reverse(sortedDataItems);

            return sortedDataItems;
        }

        /**
         * Traverses a given TreeNode structure in breadth-first order, while populating a map where the key is the current
         * tree depth and the values are a list of the data items for each tree.
         */
        private void populateTreeNodesToDepthLevelMap(TreeNode<T> currentNode, Map<Integer, List<T>> treeDepthToNodesMap, int currentDepth) {
            List<TreeNode<T>> children = currentNode.getChildren();
            if (!(children == null || children.isEmpty())) {
                for (TreeNode<T> child : children) {
                    populateTreeNodesToDepthLevelMap(child, treeDepthToNodesMap, currentDepth + 1);
                }
            }

            if (treeDepthToNodesMap.containsKey(currentDepth)) {
                treeDepthToNodesMap.get(currentDepth).add(currentNode.getData());
            } else {
                ArrayList<T> dataList = new ArrayList<T>();
                dataList.add(currentNode.getData());
                treeDepthToNodesMap.put(currentDepth, dataList);
            }
        }
    }
}