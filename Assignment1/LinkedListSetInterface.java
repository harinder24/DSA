package Assignment1;


public class LinkedListSetInterface<T> implements SetInterface<T> {

    Node head;
    Node tail;
    int numberOfelements;

    LinkedListSetInterface(){
        head = null;
        tail = null;
        numberOfelements = 0;
    }

    class Node{
        Node next;
        T value;
        Node(){
            next = null;
        }
    }
    @Override
    public int getCurrentSize() {
        
        return numberOfelements;
    }

    @Override
    public boolean isEmpty() {
        if (numberOfelements == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        if(contains(newEntry)){
            return false;
        }
        Node x = new Node();
        x.value = newEntry;

        if (numberOfelements == 0){
            head = x;
            tail = x;
            numberOfelements++;
            return true;
        }
        tail.next = x;
        tail = x;
        numberOfelements++;
        return true;
    }

    @Override
public boolean remove(T anEntry){

    if(numberOfelements == 1){
        if(head.value == anEntry){
            head = null;
            numberOfelements--;
            return true;
        }
        return false;
    }
    if(numberOfelements == 0){
        return false;
    }
    Node tmp = head;
    if(anEntry == head.value){
        head = head.next;
        tmp.next = null;
        numberOfelements--;
        return true;
    }
    Node afterTmp = tmp.next;
    while (afterTmp != null) {
        if(afterTmp.value == anEntry){
            tmp.next = afterTmp.next;
            afterTmp.next = null;
            numberOfelements--;
            return true;
        }
        tmp = tmp.next;
        afterTmp = afterTmp.next;
    }
    return false;
};


    @Override
    public void clear() {
        head = null;
        tail = null;
        numberOfelements = 0;
        
    }

    @Override
    public boolean contains(T anEntry) {
            
        if(numberOfelements == 0) return false;

        Node tmp = head;

        while(tmp != null){
            if(tmp.value == anEntry){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

 
    @Override
    public T[] toArray(){
    @SuppressWarnings("unchecked") T[] myarr = (T[]) new Object[numberOfelements];
    Node tmp = head;
    int num = 0;
    while (tmp != null) {
        myarr[num] = tmp.value;
        tmp = tmp.next;
        num++;
    }
    return myarr;

};
    
}
