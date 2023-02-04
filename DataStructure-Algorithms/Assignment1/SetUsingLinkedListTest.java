

import static org.junit.Assert.*;

import org.junit.Test;

public class SetUsingLinkedListTest {
  @Test
  public void initialTest() { // Test to check function are working before adding any element
    SetUsingLinkedList<Integer> x = new SetUsingLinkedList<Integer>();
    assertEquals(true, x.isEmpty()); // true
    assertEquals(false, x.contains(4)); // false
    assertEquals(false, x.remove(3)); // false
    assertEquals(0, x.getCurrentSize()); // 0
    Integer[] array = {};
    assertArrayEquals(array, x.toArray()); //true
  }

  @Test
  public void addingElement(){ // function to check every scenario if an element is added
    SetUsingLinkedList<Integer> x = new SetUsingLinkedList<Integer>();
    x.add(1);
    assertEquals(false, x.isEmpty()); // false
    assertEquals(1, x.getCurrentSize()); // 1
    assertEquals(true, x.contains(1)); // true
    assertEquals(false, x.contains(4)); // false
  }

  @Test
  public void removeElement(){
    SetUsingLinkedList<Integer> x = new SetUsingLinkedList<Integer>();
    x.add(1);
    assertEquals(false, x.isEmpty()); // false
    assertEquals(1, x.getCurrentSize()); // 1
    assertEquals(true, x.contains(1)); // true

    x.remove(1);
    assertEquals(true, x.isEmpty()); // true
    assertEquals(0, x.getCurrentSize()); // 0
    assertEquals(false, x.contains(1)); // false
  }
    @Test
    public void mainTest() {
        SetUsingLinkedList<Integer> x = new SetUsingLinkedList<Integer>();
        
        assertEquals(true, x.isEmpty()); // true
        
        x.add(10);
        x.add(20);
        x.add(30);
        assertEquals(false, x.isEmpty()); // false
        assertEquals(false, x.add(20)); // false
        assertEquals(true, x.contains(30)); // true
        assertEquals(false, x.contains(40)); // false
        assertEquals(3, x.getCurrentSize()); // 3
        
        assertEquals(true, x.remove(30)); // true
        assertEquals(false, x.remove(30)); // false
        assertEquals(2, x.getCurrentSize()); // 2
        Integer[] array = {10,20};
        assertArrayEquals(array, x.toArray()); //true

        x.clear();
        assertEquals(0,x.getCurrentSize()); // 0
        assertEquals(true,x.isEmpty()); // true
      }
}
