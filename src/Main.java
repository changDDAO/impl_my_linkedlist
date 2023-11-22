public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myIntList = new MyLinkedList<Integer>();
        MyLinkedList<String> myStringList = new MyLinkedList<>();
        //error check
//        Node<Integer> removed = myIntList.remove(0);
//        System.out.println(removed.getValue());
        /*Cannot read field "nextNode" because "temp" is null
        리스트가 빈 상태 이거나, 리스트 인덱스의 범위를 초과하였습니다.*/

        myIntList.add(5);
        System.out.printf("사이즈 : %d head: %d \n", myIntList.getListSize(), myIntList.get(0).value);
        myIntList.add(143);
        myIntList.add(17);
        myIntList.add(315);
        myIntList.add(200);
        System.out.print("root node부터 순차적으로 Next node를 조회한 값은 : ");
        MyLinkedList<Integer>.MyIterator iter = myIntList.myIter();
        while (iter.hasNext()) {
            System.out.print(iter.next().value+" ");
            //root node부터 순차적으로 Next node를 조회한 값은 : 5 143 17 315 200
        }
        System.out.println();
        //첫번 째 인덱스를 제거해보자;
//        myIntList.remove(1);
        iter = myIntList.myIter();
        while(iter.hasNext()) {//143값을 가진 노드가 제게되어야함 (clear)
            System.out.print(iter.next().value+" ");// 5 17 315 200
        }
        System.out.println();
        myStringList.add("changho");
        myStringList.add("goorm");
        MyLinkedList<String>.MyIterator strIter = myStringList.myIter();
        while (strIter.hasNext()) {
            System.out.print(strIter.next().value+" ");//changho goorm
        }

    }
}
