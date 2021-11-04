/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package montador;


public class Simbolo {
    
    private String value;
    private String type;
    private boolean definition;

    public Simbolo(String value, String type, boolean definition){
        
        this.value = value;
        this.type = type;
        this.definition = definition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        if(type.equals("Const")){
            this.value = value;
        }else{
            System.out.println("Not permited chenges");
        }
       
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }   
}
