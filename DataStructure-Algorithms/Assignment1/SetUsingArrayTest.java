import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetUsingArrayTest {

    @Test
    public void initialTest() { // Test to check function are working before adding any element
      SetUsingArrays<String> x = new SetUsingArrays<String>();
      assertEquals(true, x.isEmpty()); // true
      assertEquals(false, x.contains("four")); // false
      assertEquals(false, x.remove("three")); // false
      assertEquals(0, x.getCurrentSize()); // 0
      String[] array = {};
      assertArrayEquals(array, x.toArray()); //true
    }

    @Test
    public void addingElement(){ // function to check every scenario if an element is added
      SetUsingArrays<String> x = new SetUsingArrays<String>();
      x.add("one");
      assertEquals(false, x.isEmpty()); // false
      assertEquals(1, x.getCurrentSize()); // 1
      assertEquals(true, x.contains("one")); // true
      assertEquals(false, x.contains("four")); // false
    }

    @Test
    public void removeElement(){
      SetUsingArrays<String> x = new SetUsingArrays<String>();
      x.add("one");
      assertEquals(false, x.isEmpty()); // false
      assertEquals(1, x.getCurrentSize()); // 1
      assertEquals(true, x.contains("one")); // true

      x.remove("one");
      assertEquals(true, x.isEmpty()); // true
      assertEquals(0, x.getCurrentSize()); // 0
      assertEquals(false, x.contains("one")); // false
    }

    @Test
    public void mainTest() {
        SetUsingArrays<String> x = new SetUsingArrays<String>();
        
        assertEquals(true, x.isEmpty()); // true
        
        x.add("one");
        x.add("two");
        x.add("three");
        assertEquals(false, x.isEmpty()); // false
        assertEquals(false, x.add("two")); // false
        assertEquals(true, x.contains("three")); // true
        assertEquals(false, x.contains("four")); // false
        assertEquals(3, x.getCurrentSize()); // 3
        
        assertEquals(true, x.remove("three")); // true
        assertEquals(false, x.remove("three")); // false
        assertEquals(2, x.getCurrentSize()); // 2
        String[] array = {"one","two"};
        assertArrayEquals(array, x.toArray()); //true

        x.clear();
        assertEquals(0,x.getCurrentSize()); // 0
        assertEquals(true,x.isEmpty()); // true
      }
}
