/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.Arboles;

/**
 *
 * @author dell
 */
public class NodoBinario<K,V> {
    

    private K clave;
    private V valor;
    private NodoBinario<K,V> hijoDerecho;
    private NodoBinario<K,V> hijoIzquierdo;
    
    
    
    public NodoBinario(){
        
    }
    public NodoBinario(K clave,V valor){
        this.clave=clave;
        this.valor=valor;
        this.hijoDerecho=null;
        this.hijoIzquierdo=null;
        
    }
    public void setValor(V valor){
        this.valor=valor;
    }
    public void setClave(K clave){
        this.clave=clave;
    }
    public K getClave(){
        return this.clave;
    }
    public V getValor(){
        return this.valor;
        
    }
    public NodoBinario<K,V> getHijoDerecho(){
        return this.hijoDerecho;
    }
    public NodoBinario<K,V> getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }
    public boolean IncompletoPorDerecha(){
        return this.esVacioHijoDerecho()&&!this.esVacioHijoIzquierdo();
    }
    public void setHijoDerecho(NodoBinario<K,V> hi){
        this.hijoDerecho=hi;
    }
    public void setHijoIzquierdo(NodoBinario<K,V> hd){
        this.hijoIzquierdo=hd;
    }
    public boolean esVacioHijoIzquierdo(){
        return NodoBinario.esNodoVacio(this.getHijoIzquierdo());
    }
    public boolean esVacioHijoDerecho(){
        return NodoBinario.esNodoVacio(this.getHijoDerecho());
    }
    public static boolean esNodoVacio(NodoBinario nodo){
            return nodo==NodoBinario.nodoVacio();
    }
    public static NodoBinario<?,?> nodoVacio(){
        return null;
    }
    public boolean esNodoCompleto(){
        return !this.esVacioHijoDerecho()&& 
                !this.esVacioHijoIzquierdo();
    }
    public boolean esHoja(){
        return this.esVacioHijoDerecho()&& 
                this.esVacioHijoIzquierdo();
    }
    public boolean esIncompletoPorDerecha(){
        return esVacioHijoDerecho()&&!esVacioHijoIzquierdo();
    }
    
}

