/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.Arboles;

/**
 *
 * @author dell
 */
import java.util.List;


public interface IArbolBusqueda <K extends Comparable<K>,V>{
    
    void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException;
    V eliminar(K claveAEliminar)throws NullPointerException, ExcepcionClaveNoExiste;
    V buscar(K claveABuscar) throws NullPointerException;
    boolean contiene(K claveABuscar) throws NullPointerException;
    int size();
    int altura();
    void vaciar();
    boolean esArbolVacio();
    
    List<K> recorridoPorNiveles();
    List<K> recorridoEnPreOrden();
    List<K> recorridoEnInOrden();
    List<K> recorridoEnPostOrden();
   
    
}
