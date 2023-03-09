import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class QuadraticProbing<K,V> implements DictionaryInterface<K,V> {
    private int numberOfKeys;
    private int size;

    public static class Item<K,V> {
        public V value;
        public K key;
        Item() {
          value = null;
          key = null;  
        }
        Item(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    Item<K,V>[] hashTable;
    final int TABLE_SIZE = 25;

    QuadraticProbing(){
      hashTable = new Item[TABLE_SIZE];
      size = TABLE_SIZE; 
      numberOfKeys = 0;
    //   for (int i = 0; i < TABLE_SIZE; i++) {
    //     hashTable[i] = new Item<K,V>();
    //   }
    }
    QuadraticProbing(int size){
        hashTable = new Item[size];
        this.size = size; 
        numberOfKeys = 0;
        // for (int i = 0; i < size; i++) {
        //   hashTable[i] = new Item<K,V>();
        // }
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
        int hashIndex = hashCode % size;
        return hashIndex;
      }
    @Override
    public V get(K key) {
       
        int hash = getHashIndex(key);

        int i = 1;
        while (hashTable[hash] != null) {
            if(hashTable[hash].key == key){
                return hashTable[hash].value;
            }
            hash = (hash + i*i) % size;
            i++;
        }
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        if (size == numberOfKeys) {
            throw new IllegalStateException("Dictionary size is full");
        }
        int hash = getHashIndex(key);

        int i = 1;
        while (hashTable[hash] != null) {
            if(hashTable[hash].key == key){
                hashTable[hash].value = value;
                return true;
            }
            hash = (hash + i*i) % size;
            i++;
        }
        hashTable[hash] = new Item<K,V>(key, value);
        numberOfKeys++;
        return true;
    }

    @Override
    public boolean remove(K key) {
        // TODO Auto-generated method stub
        int hash = getHashIndex(key); 
        int i = 1;
        while (hashTable[hash] != null) {
            if(hashTable[hash].key == key){
                hashTable[hash] = null;
                numberOfKeys--;
                return true;
            }
            hash = (hash + i*i) % size;
            i++;
        }
       return false;
        
    }


    @Override
    public boolean replace(K key, V value) {
        // TODO Auto-generated method stub
        int hash = getHashIndex(key); 
        int i = 1;
        while (hashTable[hash] != null) {
            if(hashTable[hash].key == key){
                hashTable[hash].value = value;
                return true;
            }
            hash = (hash + i*i) % size;
            i++;
        }
       return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return numberOfKeys;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if(numberOfKeys == 0) return true;
        return false;
    }

    @Override
    public LinkedList<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(hashTable[i] != null){
                keys.add(hashTable[i].key);
            }
        }
        return keys;
        // TODO Auto-generated method stub
    }

    @Override
    public LinkedList<V> values() {
        // TODO Auto-generated method stub
        LinkedList<V> values = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(hashTable[i] != null){
                values.add(hashTable[i].value);
            }
        }
        return values;
    }
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        hashTable = new Item[size];
        numberOfKeys = 0;
    }

  
    
    
}
