/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.shuntingyard;

  
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedCola<T> {
    LinkedList<T> items = new LinkedList<T>();

    public boolean isEmpty(){
        if (items.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    
    public void enqueue(T value){
        items.add(value);
    }

    
    public T dequeue(){
        if (items.size() == 0)
        {
            throw new NoSuchElementException("The queue is empty");
        }

        T result = items.get(0);
        items.remove(0);
        return result;
    }
    
    public T peek(){
        if (items.size() == 0)
        {
            throw new NoSuchElementException("The stack is empty");
        }

        return items.get(0);
    }

    public int size(){
        return items.size();
    }
}
