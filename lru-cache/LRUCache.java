/*
LRU Cache Total Accepted: 37543 Total Submissions: 252182 My Submissions Question Solution 
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

@https://leetcode.com/problems/lru-cache/
*/
import java.io.*;
import java.util.*;

public class LRUCache {
    
	LinkedList<Integer> keys = new LinkedList<Integer>();
	//LinkedList<Integer> values = new LinkedList<Integer>();
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    int size = 0;

    public LRUCache(int capacity) 
    {
        this.size = capacity;
    }

    //update when set
    public void update(int key)
    {
    	int a = getIndex(key);
        if(a != -1){ // cache contains this key
    	   keys.remove(a);
    	   keys.add(key);
        }else if(isFull()){//cache does not contain this key, and cache is full
            int popKey = keys.poll();
            data.remove(popKey);
            keys.add(key);
        }else{//cache does not contain this key, and cache is not full
            keys.add(key);
        }
    }

    //if keys not contain this key , return -1
    public int getIndex(int key)
    {
        if(data.containsKey(key)){
            return keys.indexOf(key);
        }
        return -1;
    }
    
    public boolean isFull()
    {
        return keys.size() == size;
    }

    public int get(int key) {
        if(!data.containsKey(key)){
            return -1;
        }
        int a = getIndex(key);
        keys.remove(a);
        keys.add(key);
        return data.get(key);
    }
    
    public void set(int key, int value)
    {
        if(!data.containsKey(key)){
            update(key);
            data.put(key,value);
        }       
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void showCache(LRUCache s)
    {
        println(s.keys);
        println(s.data);
        println("====");
    }
    public static void main(String[] args) {
    	LRUCache s = new LRUCache(3);
        s.set(1,3);       
        //s.get(1);
        s.set(2,4);
        s.set(3,5);
        showCache(s);
        println(s.get(1));
        showCache(s);
        s.set(8,10);
        showCache(s);
        println(s.get(10));
    	//println();    
    }
}