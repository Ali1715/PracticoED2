/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Prueba;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;
import java.util.Stack;
import bo.edu.uagrm.ficct.inf310sb.Arboles.*;

/**
 *
 * @author dell
 */
public class Consola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   //     Practico<Integer,String>arbol=new  Practico<>(); 

       ArbolBinarioBusqueda<Integer,String>arbolABB=new  ArbolBinarioBusqueda<>();
       ArbolBinarioBusqueda<Integer,String>arbolABB2=new  ArbolBinarioBusqueda<>(); 
       AVL<Integer,String> arbolAVL=new AVL<>();
       
       ArbolMViasBusqueda<Integer,String>arbolMVias=new ArbolMViasBusqueda<>();
       
        ArbolB<Integer,String>arbolB=new ArbolB<>();
       
    //arbolMVIAS   
      arbolMVias.insertar(80,"a");
      arbolMVias.insertar(120,"b");
      arbolMVias.insertar(200,"c");
      arbolMVias.insertar(50,"aa");
      arbolMVias.insertar(70, "aa");
      arbolMVias.insertar(75,"aa");
      arbolMVias.insertar(72,"ddd");
      arbolMVias.insertar(98,"ddd");
      arbolMVias.insertar(110,"ddd");
      arbolMVias.insertar(130,"ddd");
      arbolMVias.insertar(140,"ddd");
      arbolMVias.insertar(150,"ddd");
      arbolMVias.insertar(134,"ddd");
      arbolMVias.insertar(160,"ddd");
      arbolMVias.insertar(170,"ddd"); 
      arbolMVias.insertar(190,"ddd");
      arbolMVias.insertar(158,"ddd");
      arbolMVias.insertar(400,"ddd");
      arbolMVias.insertar(500,"ddd");
      arbolMVias.insertar(560,"ddd");
       
       
     /*  ArbolMViasBusqueda<Integer,String>mvias2=new ArbolMViasBusqueda<>();
      arbolMVias2.insertar(80,"a");
      arbolMVias2.insertar(120,"b");
      arbolMVias2.insertar(200,"c");
      arbolMVias2.insertar(50,"aa");
      arbolMVias2.insertar(70, "aa");
      arbolMVias2.insertar(75,"aa");
      arbolMVias2.insertar(72,"ddd");
      arbolMVias2.insertar(98,"ddd");
      arbolMVias2.insertar(110,"ddd");
      arbolMVias2.insertar(130,"ddd");
      arbolMVias2.insertar(140,"ddd");
      arbolMVias2.insertar(150,"ddd");
      arbolMVias2.insertar(134,"ddd");
      arbolMVias2.insertar(160,"ddd");
      arbolMVias2.insertar(170,"ddd");
       
      arbolMVias2.insertar(190,"ddd");
      arbolMVias2.insertar(158,"ddd");
      arbolMVias2.insertar(400,"ddd");
      arbolMVias2.insertar(500,"ddd");
      arbolMVias2.insertar(560,"ddd");
       
       */
     
     //arbolAVL
       arbolAVL.insertar(50, "Dilker");
       arbolAVL.insertar(35, "Daniel");
       arbolAVL.insertar(28, "miguel");
       arbolAVL.insertar(25, "manuel");
       arbolAVL.insertar(30, "juana");
       arbolAVL.insertar(40, "carla");
        
       //arbolABB
       arbolABB.insertar(50, "Dilker");
       arbolABB.insertar(35, "Daniel");
       arbolABB.insertar(28, "miguel");
       arbolABB.insertar(25, "manuel");
       arbolABB.insertar(30, "juana");
       arbolABB.insertar(40, "carla");
       arbolABB.insertar(90, "yenny");
       arbolABB.insertar(95, "andrea");
       arbolABB.insertar(93, "pedro");
       arbolABB.insertar(60, "richard");
       arbolABB.insertar(65, "richard");
       
       
       arbolABB2.insertar(50, "Dilker");
       arbolABB2.insertar(35, "Daniel");
       arbolABB2.insertar(28, "miguel");
       arbolABB2.insertar(25, "manuel");
       arbolABB2.insertar(30, "juana");
       arbolABB2.insertar(40, "carla");
       arbolABB2.insertar(90, "yenny");
       arbolABB2.insertar(95, "andrea");
       arbolABB2.insertar(93, "pedro");
       arbolABB2.insertar(60, "richard");
       arbolABB2.insertar(65, "richard");
       
      /*arbolB.insertar(50, "Dilker");
       arbolB.insertar(35, "Daniel");
       arbolB.insertar(28, "miguel");
       arbolB.insertar(25, "manuel");
       arbolB.insertar(30, "juana");
       arbolB.insertar(40, "carla");
       arbolB.insertar(90, "yenny");
       arbolB.insertar(95, "andrea");
       arbolB.insertar(93, "pedro");
       arbolB.insertar(60, "richard");
           */
       
        arbolMVias.eliminarLasHojas();
        System.out.println("");
        System.out.println("");
  
        System.out.println(arbolMVias.recorridoPorNiveles());
        System.out.println("");
        System.out.println("");
        System.out.println(""); 
        System.out.println(""); 
       /* System.out.println(arbolB.recorridoPorNiveles());
        System.out.println("");
        System.out.println("");
        System.out.println(""); 
        System.out.println("");    
    */    
        System.out.println(arbolABB.mostrarNiveles());
        System.out.println("");
        System.out.println("");
        System.out.println(""); 
        System.out.println("");    
         System.out.println(arbolABB2.mostrarNiveles());
        System.out.println("");
        System.out.println("");
        System.out.println(""); 
        System.out.println("");    
                
        System.out.println(arbolAVL.mostrarNiveles());              
        System.out.println("");
        System.out.println("");
        System.out.println(""); 
        System.out.println(""); 
        
        System.out.println("************************************************PRACTICO SOBRE ARBOLES BINARIOS DE BUSQUEDA Y MVIAS************************************************************");    
        System.out.println("");
        System.out.println("");
        System.out.println("PREGUNTA 1: Implemente un metodo que reciba en listas de parametros las llaves y valoreden respectivamente y que recostruya el arbolbinario original. Su metodo no debe usar el metodo insertar\");s de los recorridos en "
                + " post orden e inorden respectivamente y que recostruya el arbolbinario original. Su metodo no debe usar el metodo insertar");
        System.out.println("PREGUNTA 2: Para un arbol binario de busqueda implementar el recorrido en postorden iterativo ");
        System.out.println("PREGUNTA 3: Para un arbol MVias implementar recorrido en PostOrden que sirva tanto para arboles MVias de busqueda como para arboles B ");
        System.out.println("PREGUNTA 4: Para un arbol MVias implementar recorrido en PreOrden que sirva tanto para arboles MVias de busqueda como para arboles B ");
        System.out.println("PREGUNTA 5: Para un arbol MVias implementar recorrido en InOrden que sirva tanto para arboles MVias de busqueda como para arboles B  ");
                System.out.println("PREGUNTA 6: Para el arbol AVL implementar el metodo insertar ");//listo
                System.out.println("PREGUNTA 7: Para el arbol AVL implementar el metodo eliminar ");//listo
                System.out.println("PREGUNTA 8: Para el arbol B implementar el metodo insertar ");//listo
        System.out.println("PREGUNTA 9: Para el arbol B implementar el metodo eliminar ");
                System.out.println("PREGUNTA 10: Para el arbol MVias de busqueda implementar el metodo insertar ");//listo
                System.out.println("PREGUNTA 11: Para el arbol MVias de busqueda implementar el metodo eliminar ");//listo
        System.out.println("PREGUNTA 12: Implemente un metodo recursivo que retorne la cantidad de nodos que tienen un solo hijo no vacio. "
                                     + "La solucion debe usar un recorrido enPostOrden ");
        System.out.println("PREGUNTA 13: Implemente un metodo iterativo con la logica de un recorrido en inOrden "
                                     + "que retorne el numero de hijos vacios que tiene un arbol binario ");
        System.out.println("PREGUNTA 14: Implemente un metodo privado que reciba un nodo binario de un arbol binario y que retorne cual seria su predecesor"
                                     + "inOrden de la clave de dicho orden");
        System.out.println("PREGUNTA 15: Implemente un metodo que retorne verdadero si solo hay nodos completos en el nivel n de un arbol mvias."
                                     + "Falso caso contrario ");
        System.out.println("PREGUNTA 16: Implemente una clase ArbolBinarioBusquedaEnteroCadenna que usando como base el ArbolBinarioBusqueda "
                                     + "ya no sea un arbol generico sino un arbol binario de busqueda con claves enteras y valores cadena");
                System.out.println("PREGUNTA 17: Para un arbol mvias implemente un metodo que reciba otro arbol "//listo
                                     + "de parametro y que retorne verdadero si los arboles son similares. Falso en caso contrario ");
        System.out.println("PREGUNTA 18: Para un arbol binario de busqueda implemente un metodo que reciba como parametro otro arbol y que retorne"
                                     + "verdadero si los arboles son similares, falso en caso contrario ");
       
        
        
        
        System.out.println("");
        System.out.println("");
        System.out.print("INGRESE EL NUMERO DE PREGUNTA : ");
        Scanner entrada =new Scanner(System.in);
        String pregunta=entrada.next();
        
         System.out.println("----------------------------------------------- ");
         
        switch(pregunta){
        
       case "1":  
            System.out.println("INGRESE LA CANTIDAD DE ELEMETOS DEL ARBOL ");
                  Scanner t=new Scanner(System.in);
                  int liminte=t.nextInt();
                  
                  ArrayList<Integer>claveInOrden=new ArrayList<>();
                  ArrayList<String>valoresInOrden=new ArrayList<>();
                  ArrayList<Integer>clavesPostOrden=new ArrayList<>();
                  ArrayList<String>valoresPostOrden=new ArrayList<>();
                 
                  System.out.println("INSERTE LAS CLAVES EN INORDEN");
                  for(int i=0;i<liminte;i++){
                      Scanner tt=new Scanner(System.in);
                      int el=tt.nextInt();
                      claveInOrden.add(el);
                  }
                  System.out.println("INSERTE LOS VALORES EN INORDEN");
                  for(int i=0;i<liminte;i++){
                      Scanner tt=new Scanner(System.in);
                      String el=tt.nextLine();
                      valoresInOrden.add(el);
                  }
                  System.out.println("INSERTE LAS CLAVES EN POSTORDEN");
                  for(int i=0;i<liminte;i++){
                      Scanner tt=new Scanner(System.in);
                      int el=tt.nextInt();
                      clavesPostOrden.add(el);
                  }
                  System.out.println("INSERTE LOS VALORES EN POSTORDEN");
                  for(int i=0;i<liminte;i++){
                      Scanner tt=new Scanner(System.in);
                      String el=tt.nextLine();
                      valoresPostOrden.add(el);
                  }
                   ArbolBinarioBusqueda<Integer,String>nuevoArbol=new ArbolBinarioBusqueda(claveInOrden, valoresInOrden, clavesPostOrden, valoresPostOrden);
        
                 System.out.println(nuevoArbol.recorridoIn());
       break; 
       case "2":  
           System.out.println( arbolABB.recorridoEnPostOrdenIterativo());
       break; 
       case "3":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "4":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "5":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "6":  
              System.out.println("INGRESE LA CLAVE A INSERTAR");
                 Scanner clave=new Scanner(System.in);
                 int cl=clave.nextInt();
                 System.out.println("INGRESE EL VALOR A INSERTAR");
                 Scanner valor=new Scanner(System.in);
                 String va=valor.nextLine();
                 arbolAVL.insertar(cl, va);
                 
                 System.out.println("EL ARBOL AVL EN INORDEN ES -->:"+ arbolAVL.recorridoIn());
       break; 
       case "7":  
            System.out.println("INGRESE LA CLAVE A ELIMINAR");
            Scanner eliminar= new Scanner(System.in);
                 int eli=eliminar.nextInt();
                 System.out.print(arbolAVL.eliminar(eli));
                 System.out.print("EL ARBOL AVL SIN CLAVE "+eli+" ES -->: "+arbolAVL.recorridoIn());
                 
       break; 
       case "8":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
              /*System.out.println("INGRESE LA CLAVE A INSERTAR");
                 Scanner claveB=new Scanner(System.in);
                 int clB=claveB.nextInt();
                 System.out.println("INGRESE EL VALOR A INSERTAR");
                 Scanner valorB=new Scanner(System.in);
                 String vaB=valorB.nextLine();
                 arbolB.insertar(clB, vaB);
                 
                 System.out.println("EL ARBOL B EN INORDEN ES -->:"+ arbolB.recorridoEnInOrden());*/
       break; 
       case "9":  
            System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "10":  
             System.out.println("INGRESE LA CLAVE A INSERTAR");
                 Scanner claveMVias=new Scanner(System.in);
                 int clMVias=claveMVias.nextInt();
                 System.out.println("INGRESE EL VALOR A INSERTAR");
                 Scanner valorMVias=new Scanner(System.in);
                 String vaMVias=valorMVias.nextLine();
                 arbolMVias.insertar(clMVias, vaMVias);
                 
                 System.out.println("EL ARBOL MVias EN INORDEN ES -->:"+ arbolMVias.recorridoPorNiveles());
       break; 
       case "11":  
            System.out.println("INGRESE LA CLAVE A ELIMINAR");
            Scanner eliminarMVias= new Scanner(System.in);
                 int elimMVias=eliminarMVias.nextInt();
                 System.out.print( arbolMVias.eliminar(elimMVias));
                 System.out.print("EL ARBOL MVias SIN CLAVE "+elimMVias+" ES -->: "+arbolMVias.recorridoPorNiveles());
       break; 
       case "12":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "13":  
           System.out.println("LA CANTIDAD DE HIJOS CON EL RECORRIO EN INORDEN ES :"+ arbolABB.cantidadDeHijosConInOrden());
       break; 
       case "14":  
           
                 System.out.println("Ingrese el elemento a busca su precesor en InOrden");
                 Scanner an=new Scanner(System.in);
                 int das=an.nextInt();
                 System.out.println("EL predecesor en inorden del elemento "+ das +" es : "+arbolABB.predecesorInOrden(das));
       break; 
       case "15":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "16":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "17":  
           System.out.println("NO SE ENCUENTRA IMPLETADO EL METODO");
       break; 
       case "18":  
           System.out.println(arbolABB.verificarSiSonArbolesSimilares(arbolABB2));
       break; 
}

    }}
    

