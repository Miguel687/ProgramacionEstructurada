/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.shuntingyard;

import java.util.LinkedList;


public class RPN {
    public static final String ops = "-+/*^";
    private LinkedCola<String> lq = new LinkedCola<>();
    private LinkedPila<Integer> ls = new LinkedPila<>();

    public void convert(LinkedList<String> infix){
        for (String token : infix) {
            if (token.isEmpty())
                continue;
            char firstSymbol = token.charAt(0); 
            int idx = ops.indexOf(firstSymbol);
         
            if (idx != -1) {
                if (ls.isEmpty())
                    ls.push(idx);

                else {
                    while (!ls.isEmpty()) {
                        int pr2 = ls.peek() / 2;
                        int pr1 = idx / 2;
                       
                        if (pr2 >=pr1)
                            lq.enqueue(String.valueOf(ops.charAt(ls.pop()))); 
                        else break;
                    }
                    ls.push(idx);
                }
            }
            else if (firstSymbol == '(') {
                ls.push(-2); 
            }
            else if (firstSymbol == ')') {
                while (ls.peek() != -2)
                    lq.enqueue(String.valueOf(ops.charAt(ls.pop())));
                ls.pop();
            }
            else {
                lq.enqueue(token);
            }
        }
        while (!ls.isEmpty()) {
            lq.enqueue(String.valueOf(ops.charAt(ls.pop())));
        }
    }


    public LinkedCola getQueue(){
        return lq;
    }
}