/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shuntingyard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Miky
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Miguel Cruz\\Documents\\3er Semestre\\Estructura de datos\\Prueba Shunting Yard\\Input.txt"));
        RPN exp = new RPN();
        exp.convert(modifyInput(br1.readLine()));
        Calculadora calc = new Calculadora();
   
        System.out.println(String.format("%.2f", calc.calculate(exp.getQueue())));
    }

    public static LinkedList<String> modifyInput(String input){
        LinkedList<String> result = new LinkedList<>();
        String ops = "-+/*^()";
        char[] parts = input.replace(" ","").toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<parts.length;i++){
            if (ops.indexOf(parts[i])!=-1){
                if((sb.toString().equals("")))
                    result.add(String.valueOf(parts[i]));
                else {
                    result.add(sb.toString());
                    sb = new StringBuilder();
                    result.add(String.valueOf(parts[i]));
                }
            }
            else {
                sb.append(parts[i]);
                if (i == parts.length -1)
                    result.add(sb.toString());
            }
        }
        return result;
    }
}
