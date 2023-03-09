import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
public class QuadricTest {
    @Test
    public void put_Test(){  // Test to check put method...... also checks get and size method
        DictionaryInterface<String,Integer> dict = new QuadraticProbing<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
     
        assertEquals(new Integer(2), dict.get("two"));
        assertEquals(3, dict.size());  
    }

    @Test
    public void remove_Test(){  // Test to check remove method
        DictionaryInterface<String,Integer> dict = new QuadraticProbing<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        
        dict.remove("two");

        assertEquals(null, dict.get("two"));
        assertEquals(2, dict.size());  
    }

    @Test
    public void replace_Test(){ // check replace method
        DictionaryInterface<String,Integer> dict = new QuadraticProbing<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);

        dict.replace("two", 4);
        assertEquals(new Integer(4), dict.get("two"));

    }

    @Test
    public void isEmpty_and_Clear_Test(){ // for isEmpty and clear Method
        DictionaryInterface<String,Integer> dict = new QuadraticProbing<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);

        assertEquals(false, dict.isEmpty());
        
        dict.clear();

        assertEquals(null, dict.get("two"));
        assertEquals(true, dict.isEmpty());

    }

    @Test
    public void keys_Test(){ // checks keys methods
        DictionaryInterface<String,Integer> dict = new QuadraticProbing<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);
        dict.put("five", 5);

        LinkedList<String> x = new LinkedList<>();
        x.add("two");
        x.add("three");
        x.add("four");
        x.add("five");
        x.add("one");
        assertEquals(x, dict.keys());
    }

    @Test
    public void value_Test(){ // checks values methods
        DictionaryInterface<String,Integer> dict = new QuadraticProbing<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);
        dict.put("five", 5);

        LinkedList<Integer> x = new LinkedList<>();
        x.add(2);
        x.add(3);
        x.add(4);
        x.add(5);
        x.add(1);
        assertEquals(x, dict.values());
    }
}
