/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.Arboles;

/**
 *
 * @author dell
 */
public class ExcepcionClaveNoExiste extends Exception {

    /**
     * Creates a new instance of <code>ExceptionClaveNoExiste</code> without
     * detail message.
     */
    public ExcepcionClaveNoExiste() {
          this("Clave no existe en el arbol");
    }

    /**
     * Constructs an instance of <code>ExceptionClaveNoExiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionClaveNoExiste(String msg) {
       // super(msg);
    }
}
