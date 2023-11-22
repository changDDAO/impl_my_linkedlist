public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> q = new MyLinkedList<Integer>();
        q.add(5);
        System.out.println(q.get(0).value);
       q.addFirst(19);
        MyLinkedList<Integer>.MyIterator myIterator = q.myIter();
        while(myIterator.hasNext()) {
            System.out.println(myIterator.next().value);
        }
    }
}
