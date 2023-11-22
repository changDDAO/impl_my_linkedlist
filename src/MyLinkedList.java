import java.util.Iterator;

public class MyLinkedList<T>{
    private int size= 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public void addFirst(T val) {
        Node<T> newNode = new Node<T>(val);
        newNode.nextNode = head;
        head = newNode;
        size += 1;
        if (head.nextNode == null) {
            head.nextNode = tail;
        }
    }

    public void add(T val) { //마지막 노드에 val값을 가진 Node 추가하기
        Node<T> newNode = new Node<T>(val);
        if (this.size == 0) {
            addFirst(val);
        } else {
            tail.nextNode = newNode;
            tail = newNode;
            size += 1;
        }
    }

    Node<T> get(int index) {
        Node<T> findNode = head;
        for (int i = 0; i < index; i++) {
            findNode = findNode.nextNode;
            if (findNode == null) {
                return new Node("MyLinkedList의 범위를 초과하셨습니다.");
            }
        }
        return findNode;
    }
    public int getListSize() {
        return size;
    }
    public MyIterator myIter(){
        return new MyIterator();
    }
    public class MyIterator implements Iterator<Node<T>> {
        private Node<T> latestReturnedNode;
        private Node<T> next;
        private int iterCurIdx;

        public MyIterator() {
            next = head;
            iterCurIdx = 0;
        }

        @Override
        public boolean hasNext() {
            return iterCurIdx<getListSize();
        }

        @Override
        public Node<T> next() {
            latestReturnedNode = next;
            next = next.nextNode;
            iterCurIdx++;
            return latestReturnedNode;
        }
    }
}

