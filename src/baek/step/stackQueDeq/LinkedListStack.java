package baek.step.stackQueDeq;

public class LinkedListStack {
    public static void main(String[] args) {
        NodeManager linkedListStack = new NodeManager();

    }
   static class Node {
        private int item;
        private Node node;

        public Node(int item) {
            this.item = item;
            this.node = null;
        }

       //가리킬 노드를 지정
        protected void linkNode(Node node) {
            this.node = node;
        }
        protected int getData() {
            return this.item;
        }
       //다음 노드를 리턴
        protected Node getNextNode() {
            return this.node;
        }
    }

    //LinkedListStack 을 관리하는 클래스
    //가장 최근에 들어온 노드를 가리킴
   static class NodeManager {
        Node top;

        public NodeManager() {
            this.top = null;
        }
        public void push(int data) {
            Node node = new Node(data);    //노드를 생성
            node.linkNode(top);    //새로 생성된 노드가 top 이 가르키고 있는 노드를 맄크로 연결하게 함
            top = node;    //top 의 값을 가장 최근에 생성된 node 로 바꿈
        }
        public void pop() {
            top = top.getNextNode(); // 현재 top 이 가리키고 있는 노드를 가리키게 함
        }
        public int peek() {
            return top.getData();
        }
    }

}

