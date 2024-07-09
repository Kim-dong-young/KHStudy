package _coding_test;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860?language=java
// 작성중

class Node{
	Node leftChild;
	Node rightChild;
	
	char[] currentText;
	
	int cursor;
	int moveCount;
	
	public Node() {
		this.leftChild = null;
		this.rightChild = null;
		
		int cursor = 0;
		int moveCount = 0;
	}
}

class Tree{
	Node root;
	Node parent;
	Node minCountNode; // 현 시점 최소값 moveCount를 가지는 노드
	
	char[] targetText; // 완성해야할 문장
	
	public Tree(Node root, char[] targetText) {
		this.root = root;
		this.parent = root;
		this.targetText = targetText;
	}
	
	public void insertNode(Node node) {
		// 기저 조건 : 목표 문장을 완성했거나, 현시점 최소값보다 moveCount가 커질경우 종료
		// String.valueOf( char [] ) => 문자배열을 String으로 변환
		if(String.valueOf(targetText).equals( String.valueOf(node.currentText))) {
			return;
		}
		
		char currentChar = node.currentText[node.cursor];
		char targetChar = this.targetText[node.cursor];
		
		// TODO node의 현재 문자열 상태 처리, moveCount 계산 할 것
		if(currentChar != targetChar) {
			
		}
		
		// 깊이 우선으로 트리 생성 - 왼쪽자식 -> 오른쪽자식
		if(this.parent.leftChild == null) {
			this.parent.leftChild = node;
			this.parent.leftChild.cursor = ( node.cursor - 1 ) % this.targetText.length; // 커서 왼쪽 이동
			this.parent = node;
			insertNode(this.parent);
		}
		
		if(this.parent.rightChild == null) {
			this.parent.rightChild = node;
			this.parent.rightChild.cursor = ( node.cursor + 1 ) % this.targetText.length; // 커서 오른쪽 이동
			this.parent = node;
			insertNode(this.parent);
		}
	}
	
	public int countMove() {
		int count = 0;
		
		return count;
	}
	
}

public class TestCode_015 {

	public static void main(String[] args) {
		String name = "JEROEN";
		

	}
}
