import java.util.LinkedList;

@SuppressWarnings("unchecked")
class SeparateChaining<K,V> implements DictionaryInterface<K,V>{


    public static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;
        
        Node(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public static class myLinkedList<K,V>{
        private Node<K,V> head;
        private int innerNumberOfKeys;
    
        public myLinkedList() {
            head = null;
            innerNumberOfKeys = 0;
        }


        public void addFirst(K keys, V value) {
            Node<K,V> aNewNode = new Node<K,V>(keys, value);
            if(innerNumberOfKeys == 0){
                head = aNewNode;
                innerNumberOfKeys++;
                return;
            }else{
                aNewNode.next = head;
                head = aNewNode;
                innerNumberOfKeys++;
                return;
            }
            
        }
        public Node<K, V> getFirst(){
            if(innerNumberOfKeys > 0){
                return head;
            }
            return null;
        }

        public boolean remove(K key){
            if(innerNumberOfKeys > 0){
                Node<K,V> tmp = head;
                if(tmp.key == key){
                    head = tmp.next;
                    tmp.next = null;
                    innerNumberOfKeys--;
                    return true;
                }
                Node<K,V> after = head.next;
                while(after != null){
                    if(after.key == key){
                        tmp.next = after.next;
                        after.next = null;
                        innerNumberOfKeys--;
                        return true;
                    }
                    tmp = after;
                    after = after.next;
                }
                return false;
            }
            return false;
        }
        public boolean isEmpty(){
            if(innerNumberOfKeys == 0){
                return true;
            }
            return false;
        }
    }

    private int numberOfKeys;
    private myLinkedList<K,V>[] outerList;
    private int tableSize;

    SeparateChaining(){
        numberOfKeys = 0;
        outerList = new myLinkedList[25];
        tableSize = 25;
    }
    SeparateChaining(int num){
        numberOfKeys = 0;
        outerList = new myLinkedList[num];
        tableSize = num;
    }
    private int hashCode(K key) {
        int hash = 0;
        // horner's rule
        for (int i = 0; i < key.toString().length(); i++) {
          hash += 31 * hash + key.toString().charAt(i);
        }
        return hash;
      }
    
      private int getHashIndex(K key) {
        //
        int hashCode = hashCode(key); // TODO implement hashCode using Horner's rule
        int hashIndex = hashCode % tableSize;
        return hashIndex;
      }
      
    @Override
    public V get(K key) {
        
        int hash = getHashIndex(key);
        if(outerList[hash] == null){
            return null;
        }
        Node<K, V> tmp = outerList[hash].getFirst();
            while(tmp != null){
                if(tmp.key == key){      
                    return tmp.value;
                }
                tmp = tmp.next;
            }
        
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        int hash = getHashIndex(key);
        
        if(outerList[hash] == null){
            outerList[hash] = new myLinkedList<>();
            outerList[hash].addFirst(key,value);
            numberOfKeys++;
            return true;
        }
        else{
            Node<K, V> tmp = outerList[hash].getFirst();
            while(tmp != null){
                if(tmp.key == key){
                    tmp.value = value;
                    return true;
                }
                tmp = tmp.next;
            }
            // if(tmp.key == key){
            //     tmp.value = value;
            //     return true;
            // }
            outerList[hash].addFirst(key,value);
            numberOfKeys++;
            return true;
        }
        // TODO Auto-generated method stub
    }

    @Override
    public boolean remove(K key) {
        
        int hash = getHashIndex(key);
        if(outerList[hash] == null) return false;
        boolean truth = outerList[hash].remove(key);
        if(truth){
            numberOfKeys--;
            return true;
        }
        return false;
        // TODO Auto-generated method stub
      
    }

    @Override
    public boolean replace(K key, V value) {
        int hash = getHashIndex(key);
        if(outerList[hash] == null) return false;
        Node<K, V> tmp = outerList[hash].getFirst();
            while(tmp != null){
                if(tmp.key == key){
                    tmp.value = value;
                    return true;
                }
                tmp = tmp.next;
            }
            return false;
    }

    

    @Override
    public int size() {
        return numberOfKeys;
    }

    @Override
    public boolean isEmpty() {
        if(numberOfKeys == 0) return true;
        return false;
    }  
    @Override
    public java.util.LinkedList<K> keys() {
        if(numberOfKeys == 0) return null;
        LinkedList<K> keys = new LinkedList<>();
        for (myLinkedList<K, V> list : outerList) {
            if (list != null) {
                Node<K,V> tmp = list.getFirst();
                while(tmp != null){
                    keys.add(tmp.key);
                    tmp = tmp.next;
                }
            
            }
        }
        return keys;
    }
    @Override
    public java.util.LinkedList<V> values() {
        // TODO Auto-generated method stub
        if(numberOfKeys == 0) return null;
        LinkedList<V> values = new LinkedList<>();
        for (myLinkedList<K, V> list : outerList) {
            if (list != null) {
                Node<K,V> tmp = list.getFirst();
                while(tmp != null){
                    values.add(tmp.value);
                    tmp = tmp.next;
                }
            
            }
        }
        return values;
    }
    @Override
    public void clear() {
        numberOfKeys = 0;
        outerList = new myLinkedList[tableSize];
    }

    
  

}