public class Node<T>{
    public T value; //각 노드가 담고있을 값의 field
    public Node<T> prevNode;// 이전 노드를 가리킬 Filed
    public Node<T> nextNode; // 다음 노드를 가리킬 field

    public Node(T value) {
        this.prevNode =null;
        this.value = value;
        this.nextNode = null;
    }
    public String getValue() {
        return String.valueOf(this.value);
    }

}
