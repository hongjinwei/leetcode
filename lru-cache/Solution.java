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
    
	LinkedList<Integer> key = new LinkedList<Integer>();
	LinkedList<Integer> value = new LinkedList<Integer>();
	int size = 0;

    public LRUCache(int capacity) 
    {
        this.size = capacity;
    }

    public void update(int index)
    {
    	int a = key.get(index);
    	int b = value.get(index);
    	key.remove(index);
    	value.remove(index);
    	key.add(a);
    	value.add(b);
    }

    public int getIndex(int key)
    {

    }

    
    public int get(int key) {
        
    }
    
    public void set(int key, int value) {
        
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	LRUCache s = new LRUCache();
    	//println();    
    }
}