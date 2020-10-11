/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.shuntingyard;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedPila<T> {
    private LinkedList<T> items = new LinkedList<>();

    
    public void push (T value){
        items.add(0,value);
    }
  
    public T pop()
    {
        if (items.size() == 0)
        {
            throw new NoSuchElementException("The stack is empty");
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

    public boolean isEmpty(){
        if (items.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
