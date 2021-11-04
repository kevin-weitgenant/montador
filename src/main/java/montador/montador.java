/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package montador;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList; 
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;



public class montador {
    public static LinkedHashMap<String, Simbolo> simbolos= new LinkedHashMap<String, Simbolo>();    //Linked NÃO perde a ordem que foi acrescentado    
    
    public static void primeira_passagem() {
        simbolos.put("valor", new Simbolo("valor","type", true));
    }

    
    
    public static void segunda_passagem() {
        simbolos.put("nome", new Simbolo("valor","type", true));
    }
    
    
    public static void print_simbolos() {

    simbolos.put("nome", new Simbolo("valor","type", true));      
    for (String key : simbolos.keySet()){
        System.out.println(key+simbolos.get(key).getValue());
    
    }
        
                         
    }
}
