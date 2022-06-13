package hashmap;
import java.util.*;

public class HashMapInternal {
    public static void main(String[] args) {
        Map<String, Long> phoneBook = new HashMap<>();

        phoneBook.put("Vikram",8149101254L);
        phoneBook.put("Mike",9020341211L);
        phoneBook.put("Jim",7788111284L);

       /*
       // gives concurrent error because one we modify the map using one of them, it disrupts the operation of the second,
       // so the call to keyIterator2.remove(); will result in ConcurrentModificationException.
       Iterator<String> keyIterator1 = phoneBook.keySet().iterator();
        Iterator<String> keyIterator2 = phoneBook.keySet().iterator();
        keyIterator1.remove();
        keyIterator2.remove();
*/
       /*while (keyIterator1.hasNext()) {
           try {
               String key = keyIterator1.next();
               if ("Vikram".equals(key)) {
                   keyIterator1.remove();
               }
           } catch (Exception ex) {
               System.out.println(ex);
           }
       }*/


        SampleHashMap g1 = new SampleHashMap("aditya", 1);
        SampleHashMap g2 = new SampleHashMap("aditya", 1);
        SampleHashMap g3 = new SampleHashMap("amit", 1);

        Map<SampleHashMap, String> map = new HashMap<SampleHashMap, String>();
        map.put(g1, "CSE");
        map.put(g2, "IT");
        map.put(g3, "BCS");

        for(SampleHashMap geek : map.keySet())
        {
            System.out.println(map.get(geek).toString()+"  "+geek.hashCode());
        }
    }
}
