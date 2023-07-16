//Write Hashmap

import java.io.*;
import java.util.*;

public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int N; // buckets.length
    private int n=0; // size
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      this.N=4;
      buckets = new LinkedList[N];
      for (int bi = 0; bi < N; bi++) {
        buckets[bi] = new LinkedList<>();
      }
      n=0;
    }

    private int hashFuc(K key) {
        int hc = key.hashcode();
        return Math.abs(hc)%N;
    }
    private int searchInLL(K key, int bi) {
        LinkedList<HMNode> ll = buckets[bi];
        int di = 0;
        
        for(int i=0; i<ll.size(); i++){
            HMNode node = ll.get(i);
            if(node.key==key){
                return di;
            }
            di++;
        }
        
        return -1;
    }
    private void rehash() {
        LinkedList<HMNode> oldbuck[] = buckets;
        N=2*N;
        buckets = new LinkedList[N];
        for (int bi = 0; bi < N; bi++) {
            buckets[bi] = new LinkedList<>();
        }
        
        for(int i=0; i<oldbuck.length; i++){
            LinkedList<HMNode> ll = oldbuck[i];
            for(int j=0; j<ll.size(); j++){
                HMNode node = ll.remove();
                put(node.key, node.vale);
            }
        }
    }

    public void put(K key, V value) throws Exception {
      // write your code here
      int bi= hashFunc(key);
      int di= searchInLL(key, bi);
      
      if(di != -1){
        HMNode node = buckets[bi].get(di);
        node.value = value;
      }else{
        buckets[bi].add(new HMNode(key,value));
        n++;
      }
      
      double lembda = (double)n/N;
      if(lembda > 2.0){
          rehash();
      }
    }

    public V get(K key) throws Exception {
      // write your code here
      int bi= hashFunc(key);
      int di= searchInLL(key, bi);
      
      if(di != -1){
        return buckets[bi].get(di).value;
      }
      return null;
    }

    public boolean containsKey(K key) {
      // write your code here
       int bi= hashFunc(key);
      int di= searchInLL(key, bi);
      
      if(di != -1){
        return true;
      }else{
        return false;
      }
    }

    public V remove(K key) throws Exception {
      // write your code here
      int bi= hashFunc(key);
      int di= searchInLL(key, bi);
      
      if(di != -1){
           n--;
        return buckets[bi].remove(di).value;
       
      }
      return null;
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
      ArrayList<K> keys = new ArrayList<>();
      
      for(int i=0; i<buckets.length; i++){
          LinkedList<HMNode> ll = buckets[i];
          for(HMNode node : ll){
             keys.add(node.key);
          }
      }
      return keys;
    }

    public int size() {
      // write your code here
      return n;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}
