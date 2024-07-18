package _coding_test;

// https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java
// 작성중

class Node{
	Node leftChild;
	Node rightChild;
	int value;
	
	public Node(int value) {
		this.value = value;
	}
}

class Tree{
	Node root;
	Node parent;
	int maxSum;
	
	public Tree(Node root) {
		this.root = root;
		this.parent = this.root;
	}
	
	public void insertNode(Node node) {
		if(parent.leftChild == null) {
			parent.leftChild = node;
		}
		
		else if(parent.rightChild == null) {
			parent.rightChild = node;
		}
	}
}

public class TestCode_022 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		Tree tree = new Tree(new Node(triangle[0][0]));
		
		
	}
}
