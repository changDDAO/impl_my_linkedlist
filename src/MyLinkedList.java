import java.util.Iterator;

public class MyLinkedList<T>{
    private int size= 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public void add(T val) { //마지막 노드에 val값을 가진 Node 추가하기
        Node<T> newNode = new Node<T>(val);
        if (this.size == 0) {
            head = newNode;
            size += 1;
            } else {
            Node<T> prevNode = this.get(size - 1);
            prevNode.nextNode = newNode;
            newNode.prevNode = prevNode;
            tail = newNode;
            size += 1;
        }
    }
    //첫번째 노드 삭제
    public Node<T> removeFirst() {
        Node<T>  temp = head;
        head = temp.nextNode;
        size -= 1;
        return temp;
    }
    //인덱스 위치 노드 삭제
    public Node<T> remove(int index) {
        try {
            if (index == 0) {
                return removeFirst();
            }
            this.get(index - 1).nextNode = this.get(index+1);
            this.get(index + 1).prevNode = this.get(index-1);
            size -= 1;
            return this.get(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Node("리스트가 빈 상태 이거나, 리스트 인덱스의 범위를 초과하였습니다.");
    }


    public Node<T> get(int index) {
        Node<T> findNode = head;
        for (int i = 0; i < index; i++) {
            findNode = findNode.nextNode;
            if (findNode == null) {
                return new Node("입력된 index는 MyLinkedList의 범위를 초과하셨습니다.");
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

        public MyIterator() {// 기본 생성자를 통해 초기값 전달
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
            if (next != tail) {
                next = next.nextNode;
            }
            iterCurIdx++;
            return latestReturnedNode;
        }
    }
}

