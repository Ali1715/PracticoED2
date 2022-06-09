/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.Arboles;

/**
 *
 * @author dell
 */
import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;

public class ArbolBinarioBusqueda<K extends Comparable<K>,V> implements IArbolBusqueda<K, V>{

    protected NodoBinario<K,V> raiz;
 public ArbolBinarioBusqueda(ArrayList<Integer> claveInOrden, ArrayList<String> valoresInOrden, ArrayList<Integer> clavesPostOrden, ArrayList<String> valoresInOrden0) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //VACIAR------------------------------------------------------
    @Override
    public void vaciar() {
      this.raiz=(NodoBinario<K,V>)NodoBinario.nodoVacio();
    }
//EsArbolVacio-------------------------------------------------------------
    @Override
    public boolean esArbolVacio() {
      return NodoBinario.esNodoVacio(this.raiz);
    }
//size----------------------------------------------------------------------
    @Override
    public int size() {
        Stack<NodoBinario<K,V>>pilaNodos=new Stack<>();
       int cantidad=0;
       if(this.esArbolVacio()){
           return cantidad;
       }
       pilaNodos.push(this.raiz);
       while(!pilaNodos.empty()){
           NodoBinario<K,V>nodo=pilaNodos.pop();
           cantidad++;
            if(!nodo.esVacioHijoDerecho()){
                pilaNodos.push(nodo.getHijoDerecho());
            }
            if(!nodo.esVacioHijoIzquierdo()){
                pilaNodos.push(nodo.getHijoIzquierdo());
            }
       }
       return cantidad;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }
    protected int altura(NodoBinario<K,V>nodo){
        if(NodoBinario.esNodoVacio(nodo)){
            return 0;
        }else{
            int a=altura(nodo.getHijoDerecho());
            int b=altura(nodo.getHijoIzquierdo());
            return a>b?a+1:b+1;
        }
        
    }
    public void eliminarLasHojas(){
        
       this.raiz=eliminarLasHojas(this.raiz);
        
    }
    private NodoBinario<K,V>eliminarLasHojas(NodoBinario<K,V> nodo){
        if(NodoBinario.esNodoVacio(nodo)){
            return null;
        }
        NodoBinario<K,V>aux=eliminarLasHojas(nodo.getHijoDerecho());
        NodoBinario<K,V>aux2=eliminarLasHojas(nodo.getHijoIzquierdo());
            if(nodo.esHoja()){
                return null;
            }else{
              nodo.setHijoDerecho(aux);
              nodo.setHijoIzquierdo(aux2);
            }
            return nodo;
    }
        public Queue<K>sacarPorNiveles(int nivelDado){
       //se usa una lista o vector para almacenar cada clave y su hijo de izquierda a derecha 
      Queue<NodoBinario<K,V>>colaNodos=new LinkedList<>();
      Queue<K>colaClaves=new LinkedList<>();
       if(esArbolVacio()){
          return colaClaves;
      }
      
      int nivelActual=0;
     // Queue<NodoBinario<K,V>>colaNodos=new LinkedList<>();
      colaNodos.offer(this.raiz);
       nivelActual++;
        while(!colaNodos.isEmpty()&& nivelActual<=nivelDado){
            int cantidadDeNodosEnLaCola=colaNodos.size();
            int i=0;
            nivelActual++;
           while(i<cantidadDeNodosEnLaCola){    
           NodoBinario<K,V> actual=colaNodos.poll();
           if(!actual.esVacioHijoIzquierdo()){
               colaNodos.offer(actual.getHijoIzquierdo());
           }
           if(!actual.esVacioHijoDerecho()){
               colaNodos.offer(actual.getHijoDerecho());
           }
           i++;
          }
          
        }  
             while(!colaNodos.isEmpty()){
                colaClaves.offer(colaNodos.poll().getClave());
             }   
      return colaClaves;
        }
        
    public void eliminarLosNodosDeUnNivel(int nivelAEliminar){
        if(esArbolVacio()){
            throw new IllegalArgumentException("El arbol es vacio");
        }
    Queue<K>clavesAEliminar=new LinkedList<>();
    clavesAEliminar=sacarPorNiveles(nivelAEliminar);
        while(!clavesAEliminar.isEmpty()){
            eliminar(clavesAEliminar.poll());
        }
    
    }
    public int alturaIt(){
       //se usa una lista o vector para almacenar cada clave y su hijo de izquierda a derecha 
      if(esArbolVacio()){
          return 0;
      }
      int alturaArbol=0;
      Queue<NodoBinario<K,V>>colaNodos=new LinkedList<>();
      colaNodos.offer(this.raiz);  
        while(!colaNodos.isEmpty()){
            int cantidadDeNodosEnLaCola=colaNodos.size();
            int i=0;
           while(i<cantidadDeNodosEnLaCola ){    
           NodoBinario<K,V> actual=colaNodos.poll();
           if(!actual.esVacioHijoIzquierdo()){
               colaNodos.offer(actual.getHijoIzquierdo());
           }
           if(!actual.esVacioHijoDerecho()){
               colaNodos.offer(actual.getHijoDerecho());
           }
           i++;
          }
          alturaArbol++;
        }  
      return alturaArbol;           
    }
    public int incompletoPorIzquierdaEnUnNIvel(int nivelABuscar){
        return incompletosPorIzquierdaEnUnNivel(this.raiz,0,nivelABuscar);
    }
    private int incompletosPorIzquierdaEnUnNivel(NodoBinario<K,V>nodoActual,int contador,int nivelABuscar){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int porIzquierda=incompletosPorIzquierdaEnUnNivel(nodoActual.getHijoIzquierdo(),contador+1,nivelABuscar);
         int porDerecha=incompletosPorIzquierdaEnUnNivel(nodoActual.getHijoDerecho(),contador+1,nivelABuscar);
            if(contador==nivelABuscar){
                if(nodoActual.IncompletoPorDerecha()){
                    return  porIzquierda+porDerecha+1;
                }
            
         }
         return porIzquierda+porDerecha;
    }

    
    public int nivel() {
        return this.altura()-1;
    }

  
    public K minimo() {
       if(esArbolVacio()){
           return null;
       }
       NodoBinario<K,V>actual=this.raiz;
       NodoBinario<K,V>anterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        while(!NodoBinario.esNodoVacio(actual)){
            anterior=actual;
            actual=actual.getHijoIzquierdo();
        }
       return anterior.getClave();
    }

   
    public K maximo() {
       if(esArbolVacio()){
           return null;
       }
        NodoBinario<K,V>actual=this.raiz;
        NodoBinario<K,V>anterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        while(!NodoBinario.esNodoVacio(actual)){
            anterior=actual;
            actual=actual.getHijoDerecho();
        }
        return anterior.getClave();
    }

    
    //INSERTAR----------------------------------------------------------------------------------------
    @Override
    public void insertar(K claveInsertar, V valorInsertar) {
        if(claveInsertar==null){
            throw new NullPointerException("Clave no puede ser nula");
           // throw new IllegalArgumentException("Clave no puede ser nula");
        }
         if(valorInsertar==null){
             throw new NullPointerException("Valor no puede ser nula");
            //throw new IllegalArgumentException("Valor no puede ser nulo");
        }
        if(this.esArbolVacio()){
            this.raiz=new NodoBinario(claveInsertar,valorInsertar);
            return;
        }
            NodoBinario<K,V> nodoActual=raiz;
            NodoBinario<K,V> nodoAnterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
                while(!NodoBinario.esNodoVacio(nodoActual)){
                    nodoAnterior=nodoActual;
                    K claveActual=nodoActual.getClave();
                        if(claveInsertar.compareTo(claveActual)<0){
                            nodoActual=nodoActual.getHijoIzquierdo();
                        }else if(claveInsertar.compareTo(claveActual)>0) {
                                nodoActual=nodoActual.getHijoDerecho();
                        }else{
                            nodoActual.setValor(valorInsertar);
                            return;
                        }
                } 
                   NodoBinario<K,V>nuevo=new NodoBinario<>(claveInsertar,valorInsertar);
                   K clavePadre=nodoAnterior.getClave();
                    if(claveInsertar.compareTo(clavePadre)<0){
                       nodoAnterior.setHijoIzquierdo(nuevo); 
                    }else{
                        nodoAnterior.setHijoDerecho(nuevo); 
                    }   
                    
        }

    @Override
    public V eliminar(K claveAEliminar) {
        V valorRetorno=this.buscar(claveAEliminar);
        if(valorRetorno==null){
          return null;
        }
        this.raiz=eliminar(raiz,claveAEliminar);
        return valorRetorno;
    }
    private NodoBinario<K,V>eliminar(NodoBinario<K,V>nodoActual,K claveAEliminar){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return (NodoBinario<K,V>)NodoBinario.nodoVacio();
        }
            K claveActual=nodoActual.getClave();
                if(claveAEliminar.compareTo(claveActual)<0){
                    NodoBinario<K,V>izquierdo=eliminar(nodoActual.getHijoIzquierdo(), claveAEliminar);
                    nodoActual.setHijoIzquierdo(izquierdo);
                    return nodoActual;
                }
                if(claveAEliminar.compareTo(claveActual)>0){
                   NodoBinario<K,V>derecho=eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
                   nodoActual.setHijoDerecho(derecho);
                   return nodoActual;
                }
             /// SI SE LLEGA A ESTE PUNTO SE ENCONTRO LA CLAVE A ELIMINAR
             ///YA QUE LA CLAVE A ELIMINAR NO ES MENOR NI MAYOR ,SINO IGUAL
            // # caso 1 el nodo a eliminar es una hoja
            if(nodoActual.esHoja()){
                return (NodoBinario<K,V>)NodoBinario.nodoVacio();
            }
            //# CASO 2 LA CLAVE A ELIMINAR ES UN NODO INCOMPLETO
            if(nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo()){
                return nodoActual.getHijoIzquierdo();
            }
            if(!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo()){
                return nodoActual.getHijoDerecho();
            }
            // # CASO 3 LA CLAVE A ELIMINAR ES UN NODO COMPLETO 
            // HAY QUE BUSCAR SU NODO SUCESOR
            NodoBinario<K,V>nodoSucesor=cambiar(nodoActual.getHijoDerecho());
            NodoBinario<K,V>posibleNuevo=eliminar(nodoActual.getHijoDerecho(),nodoSucesor.getClave());
            nodoActual.setHijoDerecho(posibleNuevo);
            nodoSucesor.setHijoDerecho(nodoActual.getHijoDerecho());
            nodoSucesor.setHijoIzquierdo(nodoActual.getHijoIzquierdo());
            nodoActual.setHijoDerecho((NodoBinario<K,V>)NodoBinario.nodoVacio());
            nodoActual.setHijoIzquierdo((NodoBinario<K,V>)NodoBinario.nodoVacio());
        
        return nodoSucesor;
    
    }
    public NodoBinario<K,V> cambiar(NodoBinario<K,V>nodoActual){ 
         NodoBinario<K,V>anterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
         if(NodoBinario.esNodoVacio(nodoActual)){
             return (NodoBinario<K,V>)NodoBinario.nodoVacio();
         }
         while(!NodoBinario.esNodoVacio(nodoActual)){
             anterior=nodoActual;
             nodoActual=nodoActual.getHijoIzquierdo();
         }
         return anterior;
    }

    @Override
    public boolean contiene(K clave) {
        return this.buscar(clave) != null;
    }

    @Override
    public V buscar(K clave) {
       if(!esArbolVacio()){
           NodoBinario<K,V>actual=raiz;
           while(!NodoBinario.esNodoVacio(actual)){
               K claveActual=actual.getClave();
               if(clave.compareTo(claveActual)==0){
                   return actual.getValor();
               }else if(clave.compareTo(claveActual)>0){
                   actual=actual.getHijoDerecho();
               }else{
                   actual=actual.getHijoIzquierdo();
               }
           }
           return null;
       }else{
           return null;
       }
    }

    @Override
    public List<K> recorridoEnInOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoEnPreOrden() {
       Stack<NodoBinario<K,V>>pilaNodos=new Stack<>();
       List<K>lista=new ArrayList();
       if(this.esArbolVacio()){
           return lista;
       }
       pilaNodos.push(this.raiz);
       while(!pilaNodos.empty()){
           NodoBinario<K,V>nodo=pilaNodos.pop();
           lista.add(nodo.getClave());
            if(!nodo.esVacioHijoDerecho()){
                pilaNodos.push(nodo.getHijoDerecho());
            }
            if(!nodo.esVacioHijoIzquierdo()){
                pilaNodos.push(nodo.getHijoIzquierdo());
            }
       }
       return lista;
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K>lista=new ArrayList<>();
        if(esArbolVacio()){
            return lista;
        }
        Stack<NodoBinario<K,V>>pilaNodos=new Stack<>();
        NodoBinario<K,V>actual=this.raiz;
        //el procesos inicial antes de iterar en la pila
        meterPilaParaPostOrden(pilaNodos,actual);
        //empezamos a iterar sobre la pila
            while(!pilaNodos.isEmpty()){
                actual=pilaNodos.pop();
                lista.add(actual.getClave());
                    if(!pilaNodos.isEmpty()){
                        NodoBinario<K,V>tope=pilaNodos.peek();
                            if(!tope.esVacioHijoDerecho() && (tope.getHijoDerecho() != actual)){
                                meterPilaParaPostOrden(pilaNodos,tope.getHijoDerecho());
                            }
                    }
            }
            return lista;
    }
    public void meterPilaParaPostOrden(Stack<NodoBinario<K,V>>pila,NodoBinario<K,V>nodo){
        while(!NodoBinario.esNodoVacio(nodo)){
            pila.push(nodo);
                if(!nodo.esVacioHijoIzquierdo()){
                    nodo=nodo.getHijoIzquierdo();
                }else{
                    nodo=nodo.getHijoDerecho();
                }
        }
    }

    @Override
    public List<K> recorridoPorNiveles() {
      List<K>claves=new ArrayList<>();//se usa una lista o vector para almacenar cada clave y su hijo de izquierda a derecha
     
      if(esArbolVacio()){
          return claves;
      }
      Queue<NodoBinario<K,V>>colaNodos=new LinkedList<>();
      colaNodos.offer(this.raiz);  
        while(!colaNodos.isEmpty()){
           NodoBinario<K,V> actual=colaNodos.poll();
           claves.add(actual.getClave());
           if(!actual.esVacioHijoIzquierdo()){
               colaNodos.offer(actual.getHijoIzquierdo());
           }
           if(!actual.esVacioHijoDerecho()){
               colaNodos.offer(actual.getHijoDerecho());
           }
        }  
      return claves;         
    }
  
    public List<K> recorridoIn(){
       List<K>recorrido=new ArrayList<>();
       recorridoIn(recorrido,this.raiz);
       return recorrido;
    }
    private void recorridoIn(List<K> lista,NodoBinario<K,V>nodo){
        if(NodoBinario.esNodoVacio(nodo)){
        }else{
         recorridoIn(lista,nodo.getHijoIzquierdo());
         lista.add(nodo.getClave());
         recorridoIn(lista,nodo.getHijoDerecho());
        }
    }
    public String mostrar(){
        String s="";
        mostrar(s,this.raiz);
        return s;
    }
    private void mostrar(String cadena,NodoBinario<K,V>nodo){
        if(NodoBinario.esNodoVacio(nodo)){
          
        }else{
            cadena=nodo.getClave()+"\n";
            mostrar(cadena,nodo.getHijoIzquierdo());
            mostrar(cadena,nodo.getHijoDerecho());
                   
            
        }
    }
    
    public String mostrarNiveles(){
        String cadena="";
        if(esArbolVacio()){
            return cadena;
        }
        Queue<NodoBinario<K,V>>colaDeNodos=new LinkedList<>();
        colaDeNodos.offer(raiz);
            while(!colaDeNodos.isEmpty()){
                int cantidadDeNodos=colaDeNodos.size();
                int i=0;
                    while(i<cantidadDeNodos){
                        NodoBinario<K,V>nodoActual=colaDeNodos.poll();
                        cadena=cadena+nodoActual.getClave().toString()+"    ";
                        if(!nodoActual.esVacioHijoIzquierdo()){
                            colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                        }if(!nodoActual.esVacioHijoDerecho()){
                            colaDeNodos.offer(nodoActual.getHijoDerecho());
                        }
                        i++;
                    }
                  cadena=cadena+"\n";  
            }
            return cadena;
    }
    
    public ArbolBinarioBusqueda(){
    
    }
    public ArbolBinarioBusqueda(List<K>clavesInOden,List<V> valoreInOrden,
            List<K> clavesNoInOrden,List<V> valoreNoInOrden,boolean preOrden){
    
        if(preOrden){
            this.raiz=reconstruirConPreOrdenDos(clavesInOden, valoreInOrden,
            clavesNoInOrden, valoreNoInOrden);
        }else{
            this.raiz=reconstruirConPostOrden(clavesInOden,valoreInOrden,
            clavesNoInOrden, valoreNoInOrden);
        }
        
        
    }
   
    public NodoBinario<K,V> reconstruirConPostOrden(List<K>clavesEnInOrden,List<V> valoresEnInOrden,List<K>
    clavesEnPostOrden,List<V> valoresEnPostOrden){
        
        if(clavesEnInOrden.isEmpty()){
            return (NodoBinario<K,V>)NodoBinario.nodoVacio();
        }
     int posicionPadrePostOrden=clavesEnPostOrden.size()-1;
     K clavePadrePostOrden=clavesEnPostOrden.get(posicionPadrePostOrden);
     V valorPadrePostOrden=valoresEnPostOrden.get(posicionPadrePostOrden);
     int posicionEnInOrden=this.BuscarPosicionDeLaClave(clavesEnInOrden, clavePadrePostOrden);
     //CONSTRUYENDO LA RAMA IZQUIERDA************
     List<K>clavezIzquierdaPost=clavesEnPostOrden.subList(0, posicionEnInOrden);
     List<V>valoreIzquierdaPost=valoresEnPostOrden.subList(0, posicionEnInOrden);
     List<K> clavesIzquierdaIn=clavesEnInOrden.subList(0, posicionEnInOrden);
     List<V> valorIzquierdaIN=valoresEnInOrden.subList(0, posicionEnInOrden);
     NodoBinario<K,V>ramaIzquieda=reconstruirConPostOrden(clavesIzquierdaIn, valorIzquierdaIN,
             clavezIzquierdaPost, valoreIzquierdaPost);
     //CONSTRUYENDO LA RAMA DERECHA***************
     List<K>clavesDerechaPost=clavesEnPostOrden.subList(posicionEnInOrden,clavesEnPostOrden.size()-1);
     List<V>valoresDerechaPost=valoresEnPostOrden.subList(posicionEnInOrden,valoresEnPostOrden.size()-1);
     List<K> clavesDerechaIn=clavesEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
     List<V> valoreDerechaIn=valoresEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
     NodoBinario<K,V> ramaDerecha=reconstruirConPostOrden(clavesDerechaIn, valoreDerechaIn, clavesDerechaPost, valoresDerechaPost);
     //CONSTRUYENDO LA RAIZ UNIENDO LA RAMA DERECHA E IZQUIERDA;
     NodoBinario<K,V> actual=new NodoBinario<>(clavePadrePostOrden,valorPadrePostOrden);
     actual.setHijoDerecho(ramaDerecha);
     actual.setHijoIzquierdo(ramaIzquieda); 
     
     return actual;
    }
    public NodoBinario<K,V> reconstruirConPostOrdenDos(List<K>clavesEnInOrden,List<V>valoresEnInOrden,List<K>clavesEnPostOrden,
            List<V>valoresEnPostOrden){
        
            if(clavesEnInOrden.isEmpty()){
                return (NodoBinario<K,V>)NodoBinario.nodoVacio();
            }
           int clavePadreEnPostOrden=clavesEnPostOrden.size()-1;
           K claveEnPostOrden=clavesEnPostOrden.get(clavePadreEnPostOrden);
           V valorEnPostOrden=valoresEnPostOrden.get(clavePadreEnPostOrden);
           int posicionEnInOrden=this.BuscarPosicionDeLaClave(clavesEnInOrden, claveEnPostOrden);
            
           //construir rama izquieda
           List<K>claveIzquiedasEnPostOrden=clavesEnPostOrden.subList(0,posicionEnInOrden);
           List<V>valoreIzquierdosEnPostOrden=valoresEnPostOrden.subList(0, posicionEnInOrden);
           List<K>clavesIzquierdasEnInOrden=clavesEnInOrden.subList(0, posicionEnInOrden);
           List<V>valoresIzquierdosEnInOrden=valoresEnInOrden.subList(0, posicionEnInOrden);
           NodoBinario<K,V>ramaIzquierda=reconstruirConPostOrdenDos(clavesIzquierdasEnInOrden, valoresIzquierdosEnInOrden,
                   claveIzquiedasEnPostOrden, valoreIzquierdosEnPostOrden);
          // construir rama derecha
          List<K>clavesDerechasEnPostOrden=clavesEnPostOrden.subList(posicionEnInOrden,clavesEnPostOrden.size()-1);
          List<V>valoresDerechosEnPostOrden=valoresEnPostOrden.subList(posicionEnInOrden, valoresEnPostOrden.size()-1);
          List<K>clavesDerechaEnInOrden=clavesEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
          List<V>valoresDerechosEnInOrden=valoresEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
          NodoBinario<K,V>ramaDerecha=reconstruirConPostOrdenDos(clavesDerechaEnInOrden, valoresDerechosEnInOrden,
                  clavesDerechasEnPostOrden, valoresDerechosEnPostOrden);
                   
                   
         // construir la raiz
         NodoBinario<K,V>actual=new NodoBinario<>(claveEnPostOrden,valorEnPostOrden);
         actual.setHijoDerecho(ramaDerecha);
         actual.setHijoIzquierdo(ramaIzquierda);
         
         
         return actual;
                   
                   
                   
            
    }
    public NodoBinario<K,V> reconstruirConPreOrdenDos(List<K>clavesEnInOrden,List<V>valoresEnInOrden,List<K>clavesEnPreOrden,
            List<V>valoresEnPreOrden){
        
        if(clavesEnInOrden.isEmpty()){
            return (NodoBinario<K,V>)NodoBinario.nodoVacio();
        }
        int posicionClaveEnPreOrden=0;
        K claveEnListaPreOrden=clavesEnPreOrden.get(posicionClaveEnPreOrden);
        V valorEnListaPreOrden=valoresEnPreOrden.get(posicionClaveEnPreOrden);
        int posicionEnInOrden=this.BuscarPosicionDeLaClave(clavesEnInOrden,claveEnListaPreOrden);

        //Construir la rama izquierda
        List<K>clavesIzquierdaEnPreOrden=clavesEnPreOrden.subList(1,posicionEnInOrden+1);        
        List<V>valoresIzquierdaEnPreOrden=valoresEnPreOrden.subList(1, posicionEnInOrden+1);
        List<K>clavesIzquierdaEnInOrden=clavesEnInOrden.subList(0, posicionEnInOrden);
        List<V>valoresIzquierdaEnInOrden=valoresEnInOrden.subList(0, posicionEnInOrden);
        NodoBinario<K,V>ramaIzquierda=reconstruirConPreOrdenDos(clavesIzquierdaEnInOrden, valoresIzquierdaEnInOrden, 
        clavesIzquierdaEnPreOrden, valoresIzquierdaEnPreOrden);
       
        //Costruir la rama derecha
       List<K>clavesDerechasEnPreOrden=clavesEnPreOrden.subList(posicionEnInOrden+1,clavesEnPreOrden.size());
       List<V>valoresDerechosEnPreOrden=valoresEnPreOrden.subList(posicionEnInOrden+1,valoresEnPreOrden.size());
       List<K>clavesDerechaEnInOrden=clavesEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
       List<V>valoreDerechosEnInOrden=valoresEnInOrden.subList(posicionEnInOrden+1,valoresEnInOrden.size());
       NodoBinario<K,V>ramaDerecha=reconstruirConPreOrdenDos(clavesDerechaEnInOrden, valoreDerechosEnInOrden,
               clavesDerechasEnPreOrden, valoresDerechosEnPreOrden);
        //construir la raiz
        
       NodoBinario<K,V>rama=new NodoBinario<>(claveEnListaPreOrden,valorEnListaPreOrden);
       rama.setHijoDerecho(ramaDerecha);
       rama.setHijoIzquierdo(ramaIzquierda);
        
        return rama;
    
    }
    public NodoBinario<K,V> reconstruirConPreOrden(List<K>clavesEnInOrden,List<V> valoresEnInOrden,List<K>
    clavesEnPreOrden,List<V> valoresEnPreOrden){
        if(clavesEnInOrden.isEmpty()){
            return(NodoBinario<K,V>) NodoBinario.nodoVacio();
        }
        int posicionPadrePreOrden=0;
        K clavePadrePreOrden=clavesEnPreOrden.get(posicionPadrePreOrden);
        V valorPadrePreOrden=valoresEnPreOrden.get(posicionPadrePreOrden);
        int posicionEnInOrden=BuscarPosicionDeLaClave(clavesEnInOrden, clavePadrePreOrden);
        //CONSTRUYENDO LA RAMA IZQUIERDA**********
        List<K>clavesIzquierdaEnInOrden=clavesEnInOrden.subList(0, posicionEnInOrden);
        List<V>valoresIzquierdaEnInOrden=valoresEnInOrden.subList(0, posicionEnInOrden);
        List<K>clavesIzquierdaEnPreOrden=clavesEnPreOrden.subList(1, posicionEnInOrden+1);
        List<V>valoresIzquierdaEnPreOrden=valoresEnPreOrden.subList(1, posicionEnInOrden+1);
        NodoBinario<K,V>ramaIzquierda=reconstruirConPreOrden(clavesIzquierdaEnInOrden,valoresIzquierdaEnInOrden , clavesIzquierdaEnPreOrden,
                valoresIzquierdaEnPreOrden);
        //CONSTRUYENDO LA RAMA DERECHA ***********
        List<K>clavesDerechaEnInOrden=clavesEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
        List<V>valoresDerechaEnInOrden=valoresEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
        List<K>clavesDerechaEnPreOrden=clavesEnPreOrden.subList(posicionEnInOrden+1,clavesEnPreOrden.size());
        List<V>valoresDerechaEnPreOrden=valoresEnPreOrden.subList(posicionEnInOrden+1,valoresEnPreOrden.size());
        NodoBinario<K,V>ramaDerecha=reconstruirConPreOrden(clavesDerechaEnInOrden, valoresDerechaEnInOrden,
                clavesDerechaEnPreOrden, valoresDerechaEnPreOrden);
        //CONSTRUYENDO LA RAIZ********************
        NodoBinario<K,V>actual=new NodoBinario<>(clavePadrePreOrden,valorPadrePreOrden);
        actual.setHijoDerecho(ramaDerecha);
        actual.setHijoIzquierdo(ramaIzquierda);
        
        return actual;
        
    }
    public NodoBinario<K,V> reconstruirConPostOrdenDo(List<K>clavesEnInOrden,List<V> valoresEnInOrden,List<K>
    clavesEnPostOrden,List<V> valoresEnPostOrden){
        
        if(clavesEnInOrden.isEmpty()){
            return (NodoBinario<K,V>)NodoBinario.nodoVacio();
        }
     int posicionPadrePostOrden=clavesEnPostOrden.size()-1;
     K clavePadrePostOrden=clavesEnPostOrden.get(posicionPadrePostOrden);
     V valorPadrePostOrden=valoresEnPostOrden.get(posicionPadrePostOrden);
     int posicionEnInOrden=this.BuscarPosicionDeLaClave(clavesEnInOrden, clavePadrePostOrden);
     //CONSTRUYENDO LA RAMA IZQUIERDA************
     List<K>clavezIzquierdaPost=clavesEnPostOrden.subList(0, posicionEnInOrden);
     List<V>valoreIzquierdaPost=valoresEnPostOrden.subList(0, posicionEnInOrden);
     List<K> clavesIzquierdaIn=clavesEnInOrden.subList(0, posicionEnInOrden);
     List<V> valorIzquierdaIN=valoresEnInOrden.subList(0, posicionEnInOrden);
     NodoBinario<K,V>ramaIzquieda=reconstruirConPostOrden(clavesIzquierdaIn, valorIzquierdaIN,
             clavezIzquierdaPost, valoreIzquierdaPost);
     //CONSTRUYENDO LA RAMA DERECHA***************
     List<K>clavesDerechaPost=clavesEnPostOrden.subList(posicionEnInOrden,clavesEnPostOrden.size()-1);
     List<V>valoresDerechaPost=valoresEnPostOrden.subList(posicionEnInOrden,valoresEnPostOrden.size()-1);
     List<K> clavesDerechaIn=clavesEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
     List<V> valoreDerechaIn=valoresEnInOrden.subList(posicionEnInOrden+1,clavesEnInOrden.size());
     NodoBinario<K,V> ramaDerecha=reconstruirConPostOrden(clavesDerechaIn, valoreDerechaIn, clavesDerechaPost, valoresDerechaPost);
     //CONSTRUYENDO LA RAIZ UNIENDO LA RAMA DERECHA E IZQUIERDA;
     NodoBinario<K,V> actual=new NodoBinario<>(clavePadrePostOrden,valorPadrePostOrden);
     actual.setHijoDerecho(ramaDerecha);
     actual.setHijoIzquierdo(ramaIzquieda); 
     
     return actual;
    }
    
    private int BuscarPosicionDeLaClave(List<K>listaDeClaves,K clave){
        
            for(int i=0;i<listaDeClaves.size();i++){
                K claveActual=listaDeClaves.get(i);
                    if(clave.compareTo(claveActual)==0){
                        return i;
                    }
            }
            return -1;
 
    }
    public int contarLosNodosCompletos(){
        return contarLosNodosCompletos(this.raiz);
    }
    private int contarLosNodosCompletos(NodoBinario<K,V>nodo){
        if(NodoBinario.esNodoVacio(nodo)){
            return 0;
        }
        int d=contarLosNodosCompletos(nodo.getHijoDerecho());
        int i=contarLosNodosCompletos(nodo.getHijoIzquierdo());
            if(nodo.esNodoCompleto()){
                return d+i+1;
            }
            return d+i;
        
    }
   
    public int contarLosHijosIzquierdos(){
        return contarLosHijosIzquierdos(this.raiz);
    }
    private int contarLosHijosIzquierdos(NodoBinario<K,V>nodo){
        if(NodoBinario.esNodoVacio(nodo)){
            return 0;
        }
        int cantidadPorIzquierda=contarLosHijosIzquierdos(nodo.getHijoIzquierdo());
        int cantidadPorDerecha=contarLosHijosIzquierdos(nodo.getHijoDerecho());
                if(!nodo.esVacioHijoIzquierdo()){
                    return cantidadPorIzquierda+cantidadPorDerecha+1;
                }
        return cantidadPorIzquierda+cantidadPorDerecha;
    }
    public int contarLosHijosDerechos(){
        return contarLosHijosDerechos(this.raiz);
    }
    private int contarLosHijosDerechos(NodoBinario<K,V> nodo){
        if(NodoBinario.esNodoVacio(nodo)){
            return 0;
        }
        int cantidadPorIzquierda=contarLosHijosDerechos(nodo.getHijoDerecho());
        int cantidadPorDerecha=contarLosHijosIzquierdos(nodo.getHijoIzquierdo());
            if(!nodo.esVacioHijoDerecho()){
               return cantidadPorIzquierda+cantidadPorDerecha+1; 
            }
        return cantidadPorIzquierda+cantidadPorDerecha;
    
    }
    public int cantidadDeNodosEnUnNivel(int nivel){
       Queue<K>nodosEnElNivel=this.sacarPorNiveles(nivel);
       return nodosEnElNivel.size();
    }
   
    public Queue<NodoBinario<K,V>> mostrarNodosEnUnNivel(int nivel){
        Queue<NodoBinario<K,V>>colaDeNodosEnNivel=new LinkedList<>();
            if(esArbolVacio()){
                return colaDeNodosEnNivel;
            }
            int nivelActual=0;
            colaDeNodosEnNivel.offer(raiz);
            nivelActual++;
               while(!colaDeNodosEnNivel.isEmpty() && nivelActual<=nivel){
                   nivelActual++;
                   int i=0;
                   int cantidadDeNodos=colaDeNodosEnNivel.size();
                    while(i<cantidadDeNodos){
                        
                           NodoBinario<K,V>nodoActual=colaDeNodosEnNivel.poll();
                            if(!nodoActual.esVacioHijoIzquierdo()){
                                colaDeNodosEnNivel.offer(nodoActual.getHijoIzquierdo());
                            }
                            if(!nodoActual.esVacioHijoDerecho()){
                                colaDeNodosEnNivel.offer(nodoActual.getHijoDerecho());
                            }
                        i++;
                    }
               }
            return colaDeNodosEnNivel;
    }
    public int cantidadDeNodosCompletosEnUnNivel(int nivel){
        if(esArbolVacio()){
            throw new IllegalArgumentException("El arbol esta vacio");
        }
        int cantidad=0;
        Queue<NodoBinario<K,V>>nodos=mostrarNodosEnUnNivel(nivel);
        NodoBinario<K,V>nodoActual;
            while(!nodos.isEmpty()){
                nodoActual=nodos.poll();
                    if(nodoActual.esNodoCompleto()){
                        cantidad++;
                    }
            }
        return cantidad;
        
    }
    public int cantidadDeNodosHojasEnUnNivel(int nivel){
        if(esArbolVacio()){
            throw new IllegalArgumentException("El arbol esta vacio");
        }
        int cantidad=0;
        Queue<NodoBinario<K,V>>nodos=mostrarNodosEnUnNivel(nivel);
        NodoBinario<K,V>nodoActual;
            while(!nodos.isEmpty()){
                nodoActual=nodos.poll();
                    if(nodoActual.esHoja()){
                        cantidad++;
                    }
            }
        return cantidad;
        
    }
    public NodoBinario<K,V>retornarElPadreDelNodo(K hijo){
        if(esArbolVacio() || raiz.getClave().compareTo(hijo)==0){
            return null;
        }
        NodoBinario<K,V>nodoAnterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        NodoBinario<K,V>nodoActual=this.raiz;
            while(!nodoActual.esHoja() && nodoActual.getClave().compareTo(hijo)!=0){
               nodoAnterior=nodoActual;
                if(hijo.compareTo(nodoActual.getClave())<0){
                    nodoActual=nodoActual.getHijoIzquierdo();
                }else if(hijo.compareTo(nodoActual.getClave())>0){
                    nodoActual=nodoActual.getHijoDerecho();
                }else{
                    return nodoAnterior;
                }
            }
            if(nodoActual.getClave().compareTo(hijo)==0){
                return nodoAnterior;
            }
            
            //SI SE LLEGA A ESTE PUNTO LA CLAVE NO SE ENCUENTRA EN EL ARBOL
            return null;
    }
    public Stack<K> recorridosHaciaLaClave(K clave){
        Stack<K>caminoAlNodo=new Stack<K>();
        if(esArbolVacio() || raiz.getClave().compareTo(clave)==0){
            return caminoAlNodo;
        }
        NodoBinario<K,V>nodoAnterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        NodoBinario<K,V>nodoActual=this.raiz;
            while(!NodoBinario.esNodoVacio(nodoActual)&& nodoActual.getClave().compareTo(clave)!=0){
                nodoAnterior=nodoActual;
                caminoAlNodo.push(nodoAnterior.getClave());
                    if(clave.compareTo(nodoActual.getClave())<0){
                        nodoActual=nodoActual.getHijoIzquierdo();
                    }else if(clave.compareTo(nodoActual.getClave())>0){
                        nodoActual=nodoActual.getHijoDerecho();
                    }
                    
            }
            if(NodoBinario.esNodoVacio(nodoActual)){
                caminoAlNodo.clear();
            }
        return caminoAlNodo;
    }
    public K padreMasCercanoEnComun(K claveUno,K claveDos){
        if(esArbolVacio()){
            throw new IllegalArgumentException("El arbol esta vacio");
        }
        Stack<K>recorridoUno=recorridosHaciaLaClave(claveUno);
        Stack<K>recorridoDos=recorridosHaciaLaClave(claveDos);
        
            while(!recorridoUno.isEmpty()){
                K primerClave=recorridoUno.pop();
                    if(recorridoDos.search(primerClave)>0){
                        return primerClave;
                    }
            }
        
        return null;
    }
    public int contarCuantasHojasHayAntesDelNivel(int nivel){
        Queue<NodoBinario<K,V>>colaNodos=new LinkedList<>();
            if(esArbolVacio() || nivel>this.nivel()+1){
                throw new IllegalArgumentException("el arbol no contiene ese nivel");
            }
            colaNodos.add(raiz);
            int nivelActual=0;
            int cantidadDeHojas=0;
            NodoBinario<K,V>nodoActual=(NodoBinario<K,V>)NodoBinario.nodoVacio();
                    while(!colaNodos.isEmpty() && nivelActual<nivel){
                        nivelActual++;
                        int cantidadDeNodos=colaNodos.size();
                        int i=0;
                        while(i<cantidadDeNodos){
                          nodoActual=colaNodos.poll();
                            if(nodoActual.esHoja()){
                                cantidadDeHojas++;
                            }
                           if(!nodoActual.esVacioHijoIzquierdo()){
                           
                               colaNodos.offer(nodoActual.getHijoIzquierdo());
                           }if(!nodoActual.esVacioHijoDerecho()){
                               colaNodos.offer(nodoActual.getHijoDerecho());
                           }
                           i++;
                        }
                    }
               return cantidadDeHojas;
    }
    public int contarCuantosNodosCompletosHayAntesDelNivel(int nivelAContar){
        if(esArbolVacio()|| nivelAContar>this.nivel()){
            throw new IllegalArgumentException("El arbol no tiene ese Nivel");
        }
        Queue<NodoBinario<K,V>>colaDeNodos=new LinkedList<>();
        int nivelActual=0;
        colaDeNodos.offer(raiz);
        int cantidadDeHijosCompletos=0;
            while(!colaDeNodos.isEmpty() && nivelActual<nivelAContar){
                 nivelActual++;
                 int cantidadDeNodos=colaDeNodos.size();
                 int i=0;
                 NodoBinario<K,V>nodoActual=(NodoBinario<K,V>)NodoBinario.nodoVacio();
                    while(i<cantidadDeNodos){
                        nodoActual=colaDeNodos.poll();
                                if(nodoActual.esNodoCompleto()){
                                    cantidadDeHijosCompletos++;
                                }
                            if(!nodoActual.esVacioHijoIzquierdo()){
                                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                            }if(!nodoActual.esVacioHijoDerecho()){
                                colaDeNodos.offer(nodoActual.getHijoDerecho());
                            }
                       i++;
                    }
            }
        return cantidadDeHijosCompletos;
    
    }
   
    public int cantidadDeHojasEnUnNivelRe(int nivel){
        return cantidadDeHojasEnUnNivelRe(this.raiz,nivel,0);
    }
    public int cantidadDeHojasEnUnNivelRe(NodoBinario<K,V>nodoActual,int nivel,int contador){
            if(NodoBinario.esNodoVacio(nodoActual)){
                return 0;
            }
            int izquierda=cantidadDeHojasEnUnNivelRe(nodoActual.getHijoIzquierdo(),nivel,contador+1);
            int derecha=cantidadDeHojasEnUnNivelRe(nodoActual.getHijoDerecho(),nivel,contador+1);
                if(nivel==contador){
                        if(nodoActual.esHoja()){
                    return izquierda +derecha + 1;
                    }
                }
            return izquierda +derecha ;
    }
    public boolean verificarSiTodosLosNodosEstanCompletoHastaUnNivel(int nivel){
        if(esArbolVacio() || nivel>this.nivel()+1){
            throw new IllegalArgumentException("El Arbol No Tiene Ese Nivel");
        }
        boolean sw=true;
        Queue<NodoBinario<K,V>>colaDeNodos=new LinkedList<>();
        int nivelActual=0;
        colaDeNodos.offer(this.raiz);
                while(!colaDeNodos.isEmpty() && nivelActual<nivel && sw){
                    nivelActual++;
                    int i=0;
                    int cantidadDeNodos=colaDeNodos.size();
                    NodoBinario<K,V>nodoActual=(NodoBinario<K,V>)NodoBinario.nodoVacio();
                        while(i<cantidadDeNodos){
                            nodoActual=colaDeNodos.poll();
                                if(!nodoActual.esNodoCompleto()){
                                    sw=false;
                                }
                            if(!nodoActual.esVacioHijoIzquierdo()){
                             colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                             
                            }if(!nodoActual.esVacioHijoDerecho()){
                                colaDeNodos.offer(nodoActual.getHijoDerecho());
                            }
                            i++;
                        }
                    
                }
                return sw;
    }
    
    public boolean esArbolLleno(){
        if(esArbolVacio()){
            return false;
        }
        if(verificarSiTodosLosNodosEstanCompletoHastaUnNivel(this.nivel())){
            return true;
        }
        return false;
    }
    
   
     
    public boolean balanceado(){
        return balanceado(this.raiz);
    }
    private boolean balanceado(NodoBinario<K,V>nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return true;
        }
        balanceado(nodoActual.getHijoDerecho());
        balanceado(nodoActual.getHijoIzquierdo());
        int alturaIz=this.altura(nodoActual.getHijoIzquierdo());
        int alturaDe=this.altura(nodoActual.getHijoDerecho());
        if((int)Math.abs(alturaIz-alturaDe)<=1){
            return true;
        }
        return false;
    }
    /**********************************************************************************************************/
   /****************************RESOLVIENDO PRACTICO SOBRE ARBOLES BINARIOS*************-*********************/
   /**********************************************************************************************************/ 
   

  /**********************************************************************************************************/
   /****************************RESOLVIENDO PRACTICO SOBRE ARBOLES BINARIOS*************-*********************/
   /**********************************************************************************************************/ 
 /*PREGUNTA 1: Implemente un metodo que reciba en listas de parametros las llaves y valoreden respectivamente y que recostruya el arbolbinario original. Su metodo no debe usar el metodo insertar\");s de los recorridos en "
               + " post orden e inorden respectivamente y que recostruya el arbolbinario original. Su metodo no debe usar el metodo insertar"
 */
 
 /*
 PREGUNTA 2: Para un arbol binario de busqueda implementar el recorrido en postorden iterativo 
 */

    public List<K> recorridoEnPostOrdenIterativo() {
        List<K>lista=new ArrayList<>();
        if(esArbolVacio()){
            return lista;
        }
        Stack<NodoBinario<K,V>>pilaNodos=new Stack<>();
        NodoBinario<K,V>actual=this.raiz;
        //el procesos inicial antes de iterar en la pila
        meterPilaParaPostOrden(pilaNodos,actual);
        //empezamos a iterar sobre la pila
            while(!pilaNodos.isEmpty()){
                actual=pilaNodos.pop();
                lista.add(actual.getClave());
                    if(!pilaNodos.isEmpty()){
                        NodoBinario<K,V>tope=pilaNodos.peek();
                            if(!tope.esVacioHijoDerecho() && (tope.getHijoDerecho() != actual)){
                                meterPilaParaPostOrden(pilaNodos,tope.getHijoDerecho());
                            }
                    }
            }
            return lista;
    }
    /**********************12*******************************************************************/
    public int cantidadDeHijosConInOrden(){
    if(esArbolVacio()){
        return 0;
    }
    int size=0;
    Stack<NodoBinario<K,V>>pila=new Stack<>();
    meterPilaEnInParaSize(pila,this.raiz);
        while(!pila.isEmpty()){
            NodoBinario<K,V>nodoActual=pila.pop();
            size++;
                if(!nodoActual.esVacioHijoDerecho()){
                    meterPilaEnInParaSize(pila,nodoActual.getHijoDerecho());
                }
        }
    
    return size;
    
}

private void meterPilaEnInParaSize(Stack<NodoBinario<K,V>>pila,NodoBinario<K,V>nodoActual){
    while(!NodoBinario.esNodoVacio(nodoActual)){
        pila.push(nodoActual);
        if(!nodoActual.esVacioHijoIzquierdo()){
            nodoActual=nodoActual.getHijoIzquierdo();
        }else{
            nodoActual=(NodoBinario<K,V>)NodoBinario.nodoVacio();
        }
    }

}

/***14*****************************/
public K predecesorInOrden(K clave){
     if(!this.contiene(clave)){
       throw new IllegalArgumentException("El nodo no existe en el arbol");
   }
   NodoBinario<K,V>nodo=precesorInOrdenAux(clave);
   if(NodoBinario.esNodoVacio(nodo)){
       return null;
   }
   return nodo.getClave();

}
private NodoBinario<K,V>precesorInOrdenAux(K clave){
    NodoBinario<K,V>auxiliar=this.raiz;
    
    boolean sw=false;    
        while(sw==false){
             K claveAuxiliar=auxiliar.getClave();
            if(clave.compareTo(claveAuxiliar)<0){
                auxiliar=auxiliar.getHijoIzquierdo();
            }else if(clave.compareTo(claveAuxiliar)>0){
                auxiliar=auxiliar.getHijoDerecho();
            }else{
                sw=true;
            }
        }
        NodoBinario<K,V>nodoAnterior=auxiliar;
        if(sw==true){
                if(!NodoBinario.esNodoVacio(auxiliar.getHijoIzquierdo())){
                    nodoAnterior=auxiliar;
                    auxiliar=auxiliar.getHijoIzquierdo();
                        while(!NodoBinario.esNodoVacio(auxiliar)){
                            nodoAnterior=auxiliar;
                            auxiliar=auxiliar.getHijoDerecho();
                        }
                    
                }else{
                    nodoAnterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
                }
        }
       return nodoAnterior;
}

public boolean verificarSiSonArbolesSimilares(ArbolBinarioBusqueda<K,V> arbol){
    return verificarSiSonArbolesSimilares(this.raiz,arbol.raiz);
 }
 private boolean verificarSiSonArbolesSimilares(NodoBinario<K,V>nodoActual1,NodoBinario<K,V>nodoActual2){
     
        if(NodoBinario.esNodoVacio(nodoActual1) && NodoBinario.esNodoVacio(nodoActual2)){
            return true;
        }
        boolean respuestaPorIzquierda=verificarSiSonArbolesSimilares(nodoActual1.getHijoIzquierdo(),nodoActual2.getHijoIzquierdo());
        boolean respuestaPorDerecha=verificarSiSonArbolesSimilares(nodoActual1.getHijoDerecho(),nodoActual2.getHijoDerecho());
        if(NodoBinario.esNodoVacio(nodoActual1) && !NodoBinario.esNodoVacio(nodoActual2)){
            return false;
        }
        if(!NodoBinario.esNodoVacio(nodoActual1) && NodoBinario.esNodoVacio(nodoActual2)){
         return false;
        }
        return respuestaPorIzquierda && respuestaPorDerecha;
 }
 
}

    

