package Assignment1;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedListTest{
    @Test
    public void isEmptyTest() {     // Checks if set linked list is empty or not
      LinkedListSetInterface<String> x = new LinkedListSetInterface<String>();
      assertEquals(true, x.isEmpty());
      x.add("star");
      assertEquals(false, x.isEmpty());
      x.remove("star");
      assertEquals(true, x.isEmpty());
    }

    public void numOfElement(){ // checks number of element
        LinkedListSetInterface<String> x = new LinkedListSetInterface<String>();
      assertEquals(0, x.getCurrentSize());
      x.add("star");
      assertEquals(1, x.getCurrentSize());
      x.add("planet");
      assertEquals(2, x.getCurrentSize());
      x.remove("star");
      assertEquals(1, x.getCurrentSize());
    }

    @Test
    public void addingElementTest(){ // check add function
        LinkedListSetInterface<String> x = new LinkedListSetInterface<String>();
      x.add("planet");
      assertEquals(false, x.add("planet"));
      x.add("star");
      assertEquals(2, x.getCurrentSize());
    }

    @Test
    public void removeElementTest(){ // checks remove function
        LinkedListSetInterface<String> x = new LinkedListSetInterface<String>();
      x.add("planet");
      assertEquals(1, x.getCurrentSize());
      assertEquals(true, x.contains("planet"));
      x.remove("planet");
      assertEquals(true, x.isEmpty());
      assertEquals(false, x.contains("planet"));
    }

    @Test
    public void clearTest() { // checks clear funtion
        LinkedListSetInterface<String> x = new LinkedListSetInterface<String>();
       
        
        x.add("earth");
        x.add("mars");
        x.add("sun");
        assertEquals(3, x.getCurrentSize());
        assertEquals(false, x.isEmpty());
        x.clear();
        assertEquals(0,x.getCurrentSize());
        assertEquals(true,x.isEmpty());
    }

    @Test
    public void toArrayTest(){ // prints array of from linkedlist
        LinkedListSetInterface<String> x = new LinkedListSetInterface<String>();
       
        
      x.add("earth");
      x.add("mars");
      x.add("sun");

      String [] arr = {"earth","mars","sun"};
      
      assertArrayEquals(arr, x.toArray());

    }
      
    @Test 
    public void containTest(){ // checks contain method
        LinkedListSetInterface<String> x = new LinkedListSetInterface<String>();
      x.add("earth");
      assertEquals(false, x.contains("sun"));
      assertEquals(true, x.contains("earth"));
    }
}
