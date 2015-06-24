package com.cybercoders.interview;

import static com.cybercoders.interview.Exercise3.TreeNode;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class TreeNodeTest {
    /**
     * The root node to be populated with children, for test purposes.
     */
    private TreeNode<Integer> rootNode;

    /**
     * Prepares the test data. In this case, it happens to be a root node populated with children, in accordance with
     * exercise #3 of the coding tasks.
     */
    @Before
    public void setUp() {
        // Leaf Nodes (i.e. nodes without children)
        TreeNode<Integer> _78 = new TreeNode<Integer>(78);
        TreeNode<Integer> _56 = new TreeNode<Integer>(56);
        TreeNode<Integer> _89 = new TreeNode<Integer>(89);
        TreeNode<Integer> _7 = new TreeNode<Integer>(7);

        // Non-root nodes with children
        TreeNode<Integer> _22 = new TreeNode<Integer>(22, ImmutableList.of(_78));
        TreeNode<Integer> _12 = new TreeNode<Integer>(12, ImmutableList.of(_22));
        TreeNode<Integer> _3 = new TreeNode<Integer>(3, ImmutableList.of(_89, _7));

        // The Root node
        rootNode = new TreeNode<Integer>(34, ImmutableList.of(_3, _56, _12));
    }

    @Test
    public void printDataItemListInDesiredSortOrder() throws Exception {
        // When:
        List<Integer> printedList = rootNode.generateDataItemListInDesiredSortOrder();

        // Then
        assertThat(rootNode.printDataItemListInDesiredSortOrder(),is("[78, 22, 7, 89, 12, 56, 3, 34]"));
    }

    @Test
    public void generateDataItemListInDesiredSortOrder() throws Exception {
        // When:
        List<Integer> printedList = rootNode.generateDataItemListInDesiredSortOrder();

        // Then
        assertEquals(ImmutableList.of(78, 22, 7, 89, 12, 56, 3, 34), printedList);
    }
}