package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemove {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();


        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(6);

//      报错
//        for (Integer i : list) {
//            if(i % 2 == 0) {
//                list.remove(i);
//            }
//        }

//        list.forEach(i -> {
//            if(i % 2 == 0) {
//                list.remove(i);
//            }
//        });


        for(int index = 0; index < list.size(); ) {
            Integer i = list.get(index);

            if(i % 2 == 0) {
                list.remove(i);
            } else {
                index++;
            }
        }


//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            Integer i = iterator.next();
//            if(i % 2 == 0) {
//                iterator.remove();
//            }
//        }



        list.forEach(System.out::println);
    }
}
