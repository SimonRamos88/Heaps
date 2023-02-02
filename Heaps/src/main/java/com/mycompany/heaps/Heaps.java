
package com.mycompany.heaps;



public class Heaps {

    private DinamicArray<Integer> array;
    
    
    
    //CONSTRUCTORES
    
    public Heaps(){
        this.array = new DinamicArray();
    }
    
    //METODOS
    
    //SIFTS
    // n = node prioriry, i = index
    public void siftUp(int i){
        int j  = (i-1)/2;
        int parent = array.get(j);
        int n = array.get(i);
        while(parent < n && i != 0){      
            array.set(i, parent);            
            array.set(j, n);
            i = j;
            j  = (i-1)/2;   
            parent = array.get(j);
            n = array.get(i);
        }
    
    }
    
    public int olderChildIndex(int i){
        int left = 2*i +1;
        int right = 2*i +2;
        if(left >= array.size() && right >= array.size()){ //Si no tiene hijos
            return i;
        } else if(right >= array.size()){ //Si solo tiene hijo izquierdo
            return left;
        }
        else if(array.get(left) > array.get(right)){ // si el izquiero es el mayor
            return left;
        }else{
            return right;
        }
    }
    
    public void siftDown(int i){
        int childIndx = olderChildIndex(i);
        int n = array.get(i);
        int child = array.get(childIndx);
        while( n < child  && i<array.size()){          
            array.set(childIndx, n);
            array.set(i, child);
            i = childIndx;
            childIndx = olderChildIndex(i);
            child = array.get(childIndx);
            n = array.get(i);
            
        }
        
    }
    
    
    //INSERT
    public void insert(int element){
        array.pushBack(element);
        siftUp(array.size() - 1);
        
        //System.out.println("Max: " + getMax());
        //System.out.println("olderCHild: " + array.get(olderChildIndex(0)));
        //System.out.println("size: " + array.size());
    }
    
    //EXTRACT
    
    public int extractMax(){
        if(array.size() == 0){
            throw new IllegalArgumentException("Ya estpa vacío pa");
        }
        int max = array.get(0);
        array.set( 0, array.get(array.size() - 1) );
        array.removes(array.size() - 1);
        siftDown(0);
        return max;
    
    }
    
    //GET
    
    public int getMax(){
        if(array.size() == 0){
            throw new IllegalArgumentException("Esta vacio pa");
        }
        return array.get(0);
    
    }
    
    //REMOVE
    
    public void remove(int index){
        array.set(index, getMax());
        siftUp(index);
        extractMax();
    }
    
    
    //CHANGE PRIORITY
    
    //p = priority
    public void changePriority(int index, int p){
        int old = array.get(index);
        array.set(index, p);
        if(p > old){        
            siftUp(index);
        }else if(p < old){
            siftDown(index);
        }
    
    }
    
    //GETTERS AND SETTERS

    public DinamicArray getArray() {
        return array;
    }

    public void setArray(DinamicArray array) {
        this.array = array;
    }

}
