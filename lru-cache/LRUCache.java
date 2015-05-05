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
	LinkedList<Integer> values = new LinkedList<Integer>();
	int size = 0;

    public LRUCache(int capacity) 
    {
        this.size = capacity;
    }

    public void update(int index)
    {
    	int a = keys.get(index);
    	int b = values.get(index);
    	keys.remove(index);
    	values.remove(index);
    	keys.add(a);
    	values.add(b);
    }

    //if not contain this key , return -1
    public int getIndex(int key)
    {
        for(int i=0;i<keys.size();i++ ){
            if(keys.get(i) == key){
                return i;
            }
        }
        return -1;
    }
    
    public boolean isFull()
    {
        return values.size() == size;
    }

    public int get(int key) {
        int index = getIndex(key);
        int value;
        if(index == -1){
            return -1;
        }else{
            value = values.get(index);
            update(index);
            return value;
        }
    }
    
    public void set(int key, int value)
    {
        int index = getIndex(key);
        if(index != -1){
            return;
        }

        if(isFull()){
            keys.poll();
            values.poll();
        }
        keys.add(key);
        values.add(value);     
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void showCache(LRUCache s)
    {
        println(s.keys);
        println(s.values);
        println("====");
    }
    public static void main(String[] args) {
    	LRUCache s = new LRUCache(3);
        s.set(1,3);       
        //s.get(1);
        s.set(2,4);
        s.set(3,5);
        showCache(s);
        s.get(1);
        showCache(s);
        s.set(8,10);
        showCache(s);
        println(s.get(10));
    	//println();    
    }
}