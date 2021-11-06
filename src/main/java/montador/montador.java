/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package montador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList; 
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.List;



public class montador {
    public static LinkedHashMap<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();    //Linked NÃO perde a ordem que foi acrescentado    
    static public List<String> instrucoes = new ArrayList<String>();
    
    
    public static void primeira_passagem() throws IOException {
        
        System.out.println("primeira_passagem ");
        instrucoes = Arrays.asList(tela.ArquivoCarregado.split("\n"));
        loadInstructionToFirstPass();
        //simbolos.put("valor", new Simbolo("valor","type", true));
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
    
    public static String getSymbolValue(String opd) {
        
        String value;
        value = simbolos.get(opd).getValue();
            
        return value;
    }
    
    public static void loadInstructionToFirstPass() throws IOException{
        
        System.out.println("loadIstruction ");
        String codigoIntermediario = new String();
        int controlSymbolTable = 0;
        for (int i = 0; i< instrucoes.size(); i++){
            
            String instrucao = instrucoes.get(i);
            if(instrucao.contains("add AX,AX")){
               
                codigoIntermediario += "0x03C0" + "\n"; 
            }
            
            else if(instrucao.contains("add AX,DX")){
                codigoIntermediario += "0x03C2" + "\n";
                //updateMemoria(0x03C2, controle_mem++);
   
            }else if(instrucao.matches("add AX,.*")){
                codigoIntermediario += "0x05";
                
                //updateMemoria(0x05, controle_mem++);
                String opd = instrucao.split("AX,")[1];
                opd = opd.trim();
                codigoIntermediario += opd + "\n";
                
                //updateMemoria(calculateOpd(opd),controle_mem++);
                
            }else if(instrucao.contains("div SI")){
                codigoIntermediario += "0xf7f6" + "\n";
                //updateMemoria(0xf7f6, controle_mem++);
                
            }else if(instrucao.contains("div AX")){
                codigoIntermediario += "0xf7c0" + "\n";
                //updateMemoria(0xf7c0, controle_mem++);
                
            }else if(instrucao.contains("sub AX AX")){
                codigoIntermediario += "0x2bc0" + "\n";
                //updateMemoria(0x2bc0, controle_mem++);
                
            }else if(instrucao.contains("sub AX DX")){
                codigoIntermediario += "0x2bc2" + "\n";
  
            }else if(instrucao.contains("sub AX,")){
                codigoIntermediario += "0x25";
                //updateMemoria(0x25, controle_mem++);
                String opd = instrucao.split("AX,")[1];
                codigoIntermediario += opd + "\n";
                //updateMemoria(calculateOpd(opd),controle_mem++);
                
            
            }/*else if(instrucao.contains("mul SI")){
                updateMemoria(0xf6f7, controle_mem++);
                
            }else if(instrucao.contains("mul AX")){
                updateMemoria(0xf7f0, controle_mem++);
                
            }else if(instrucao.contains("cmp AX DX")){
                updateMemoria(0x3BC2, controle_mem++);
                
            
            }else if(instrucao.contains("cmp AX ")){
                updateMemoria(0x3d, controle_mem++);
                String opd = instrucao.split("AX")[1];
                opd = opd.trim();
                updateMemoria(calculateOpd(opd),controle_mem++);

            }else if(instrucao.contains("and AX DX")){
                updateMemoria(0xf7C2, controle_mem++);
  
            }else if(instrucao.contains("and AX ")){
                updateMemoria(0x25, controle_mem++);
                String opd = instrucao.split("AX,")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
                
            
            }else if(instrucao.contains("not AX")){
                updateMemoria(0xF8C0, controle_mem++);
                
            }else if(instrucao.contains("or AX,AX")){
                updateMemoria(0x0BC0, controle_mem++);
                
            }else if(instrucao.contains("or AX,DX")){
                updateMemoria(0x0BC0, controle_mem++);
                
 
            }else if(instrucao.contains("or AX,")){
                updateMemoria(0x0D, controle_mem++);
                 String opd = instrucao.split("AX,")[1];
                opd = opd.trim();

                updateMemoria(calculateOpd(opd),controle_mem++);

            
            }else if(instrucao.contains("xor AX,AX")){
                updateMemoria(0x33C0, controle_mem++);

            }else if(instrucao.contains("xor AX,DX")){
                updateMemoria(0x33C2, controle_mem++);
 
            
            }else if(instrucao.contains("xor AX ")){
                updateMemoria(0x35, controle_mem++);
                String opd = instrucao.split("AX,")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);

            
            }else if(instrucao.contains("jmp ")){
                updateMemoria(0xEB, controle_mem++);
                String opd = instrucao.split("jmp")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
                
            
            }else if(instrucao.contains("jz ")){
                updateMemoria(0x74, controle_mem++);
                String opd = instrucao.split("jz")[1];
                opd = opd.trim();
                updateMemoria(calculateOpd(opd),controle_mem++);
                
            
            }else if(instrucao.contains("jnz ")){
                updateMemoria(0x75, controle_mem++);
                String opd = instrucao.split("jnz")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
 
            
            }else if(instrucao.contains("jp ")){
                updateMemoria(0x7A, controle_mem++);
                String opd = instrucao.split("jp")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
                
            
            }else if(instrucao.contains("call ")){
                updateMemoria(0xE8, controle_mem++);
                String opd = instrucao.split("call")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
                
            
            
            }else if(instrucao.contains("ret")){
                updateMemoria(0xEF, controle_mem++);
                
            
            }else if(instrucao.contains("hlt")){
                updateMemoria(0xEE, controle_mem++);
                
            }else if(instrucao.contains("pop AX")){
                updateMemoria(0x58C0, controle_mem++);
                
            }else if(instrucao.contains("pop DX")){
                updateMemoria(0x58C2, controle_mem++);
                
            
            }else if(instrucao.contains("pop ")){
                updateMemoria(0x58, controle_mem++);
                String opd = instrucao.split("pop")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
                
            }else if(instrucao.contains("popf")){
                updateMemoria(0x9C, controle_mem++);
                
            }else if(instrucao.contains("push AX")){
                updateMemoria(0x50C0, controle_mem++);
                
            }else if(instrucao.contains("push DX")){
                updateMemoria(0x50C2, controle_mem++);
                
            }else if(instrucao.contains("pushf")){
                updateMemoria(0x9C, controle_mem++);
                
            }else if(instrucao.contains("store AX")){
                updateMemoria(0x07C0, controle_mem++);
                
            }else if(instrucao.contains("store DX")){
                updateMemoria(0x07C2, controle_mem++);
                
            
            }else if(instrucao.contains("read ")){
                updateMemoria(0x12, controle_mem++);
                String opd = instrucao.split("read")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
                
            
            }else if(instrucao.contains("write ")){
                updateMemoria(0x08, controle_mem++);
                String opd = instrucao.split("AX,")[1];
                opd = opd.trim();

                
                updateMemoria(calculateOpd(opd),controle_mem++);
                controle_mem++;
            }else if(instrucao ==""||instrucao.contains("EQU") || instrucao.contains("DW")){

            }
            else{
                System.out.println("Instru��o nao reconhecida = "+ instrucao);
            }      

        //updateRegistrador(instrucoes.size(),"DS");    CASO SETAR DINAMICAMENTE OS SEGMENTOS   PILHA-INSTRUCOES-DADOS

         */
        }
        writeFirstPassInFile(codigoIntermediario);
    }
    
    public static void writeFirstPassInFile(String string) throws IOException{
        System.out.println("writeFirstPassInFile ");
        FileWriter fw = new FileWriter(new File(new String(System.getProperty("user.dir")+"/src/main/java/montador/firstPass.txt")));
        fw.write(string);
        fw.close();
        
        String[] vetor = string.split("\n");
        for (int i = 0; i < vetor.length; i++){     // Para adiciona texto intermediario na interface
            tela.listIntermediarioModel.addElement(vetor[i]);
        }
    }
            
}
