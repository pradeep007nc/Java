package Practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//[1,2,3,4,5,6,7,8]  t=9

public class solution {
    public void twoSum() {

        ArrayList<String> prac=new ArrayList<>();
        prac.add("mama");
        prac.add("mia");

        HashSet<String > map=new HashSet(prac);
        map.add("pil");
        map.add("bit");

        Iterator<String> ans=map.iterator();
        while (ans.hasNext()){
            System.out.println(ans.next().toString());
        }
    }
}
