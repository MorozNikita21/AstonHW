package lesson1_HW;

public class Test {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(5);
        myList.add(100, 2);
        for(Integer element : myList) {
            System.out.println(element);
        }
        System.out.println("-----------------------------");
        System.out.println(myList.get(2));
        myList.remove(20);
        myList.removeAt(0);
        System.out.println("-----------------------------");
        for(Integer element : myList) {
            System.out.println(element);
        }
        System.out.println("-----------------------------");
        System.out.println(myList.contains(20));
        System.out.println(myList.contains(5));
        System.out.println("-----------------------------");
        System.out.println(myList.size());
        System.out.println("-----------------------------");
        myList.clear();
        System.out.println(myList.size());
    }
}
