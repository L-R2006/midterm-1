package t1;


/**
 * The program simulates a specific transformation process inspired by an animation.
 * 
 * <p>It starts with:
 * <ul>
 *   <li><b>list1</b>: a list of integers from 1 to 10.</li>
 *   <li><b>list2</b>: a list of predefined strings exactly matching the animation:
 *       ["zau", "njt", "jdp", "ptm", "peq", "pbo", "ltd", "tud", "zew", "nnt"]
 *   </li>
 * </ul>
 * 
 * Step 1:</b> A fixed index mapping is used to reorder the strings from list2.
 * Mapping used is: {4, 0, 8, 3, 7, 5, 6, 9, 1, 2}
 * 
 * <Step 2: These reordered values are placed into a new list,  in the order defined by list1 (1 to 10).
 * 
 * <p>The program is implemented to follow the animation  but the logic is general and should work
 * with any values in list1 and list2  as long as the sizes match and the mapping is valid.
 * 
 * <pPackage:</b> t1
 * 
 * 
 * @author lizi rakviashvili
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class t1 {
    public static void main(String[] args) {
        
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

 
        List<String> list2 = Arrays.asList(
            "zau", "njt", "jdp", "ptm", "peq", "pbo", "ltd", "tud", "zew", "nnt"
        );

       
        int[] indexMap = {4, 0, 8, 3, 7, 5, 6, 9, 1, 2};

        
        List<String> list3 = new ArrayList<>();

        for (int i = 0; i < indexMap.length; i++) {
            list3.add(list2.get(indexMap[i]));
        }

  
        System.out.println("List1 (Integers): " + list1);
        System.out.println("List2 (Strings): " + list2);
        System.out.println("List3 (Mapped Output): " + list3);
    }
    }
