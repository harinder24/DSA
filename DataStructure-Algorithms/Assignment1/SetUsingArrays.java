

@SuppressWarnings("unchecked")
public class SetUsingArrays<T> implements SetInterface<T> {

    int numberOfElement;
    T[] array;
    SetUsingArrays(){
        numberOfElement = 0;
        
        array = (T[]) new Object[numberOfElement];
    }

    @Override
    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return numberOfElement;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if(numberOfElement == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        if (contains(newEntry) == false) {
            if (numberOfElement == array.length) {
                T[] newArray = (T[]) new Object[array.length + 1];
                System.arraycopy(array, 0, newArray, 0, numberOfElement);
                array = newArray;
            }
            array[numberOfElement] = newEntry;
            numberOfElement++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T anEntry) {
        
        if(contains(anEntry)){
            T[] newArray = (T[]) new Object[array.length - 1];
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if(array[i] != anEntry){
                    newArray[j] = array[i]; 
                    
                }
                j++;
            }
            array = newArray;
            numberOfElement--;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[numberOfElement];
        numberOfElement = 0;
        // TODO Auto-generated method stub      
    }

    @Override
    public boolean contains(T anEntry) {
        
        for (int i = 0; i < numberOfElement; i++) {
            if(array[i] == anEntry) return true;
        }
        
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return array;
    }

}
