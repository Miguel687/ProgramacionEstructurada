/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.shuntingyard;

/**
 * 
 * @author Miky
 */
public class Calculadora {
    private LinkedPila<Double> ls = new LinkedPila<>();
    public Double calculate(LinkedCola<String> lq){
        
        while(lq.size()!=0){
            if(RPN.ops.indexOf(lq.peek())==-1){
                ls.push(Double.parseDouble(lq.dequeue()));
            }

            else if (lq.peek().equals("+")) {
                ls.push(add(ls));
                lq.dequeue();
            }
            else if (lq.peek().equals("-")) {
                ls.push(subtract(ls));
                lq.dequeue();
            }
            else if (lq.peek().equals("*")) {
                ls.push(multiply(ls));
                lq.dequeue();
            }
            else if (lq.peek().equals("/")) {
                ls.push(divide(ls));
                lq.dequeue();
            }
            else if (lq.peek().equals("^")) {
                ls.push(pow(ls));
                lq.dequeue();
            }
        }
        return ls.pop();
    }


    public Double add(LinkedPila<Double> ls){
        return ls.pop()+ls.pop();
    }

    public Double subtract(LinkedPila<Double> ls){
        Double subtrahend = ls.pop();
        Double minuend = ls.pop();
        return minuend-subtrahend;
    }

    public Double multiply(LinkedPila<Double> ls){
        return ls.pop()*ls.pop();
    }

    public Double divide(LinkedPila<Double> ls){
        Double divisor = ls.pop();
        Double dividend = ls.pop();
        return dividend/divisor;
    }

    public Double pow(LinkedPila<Double> ls){
        Double power=ls.pop();
        Double value = ls.pop();
        return Math.pow(value,power);
    }
}