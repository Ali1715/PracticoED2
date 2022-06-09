/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.Arboles;

/**
 *
 * @author dell
 */
public class ExcepcionOrdenInvalido extends Exception{

    /**
     * Creates a new instance of <code>EXcepcionOrdenInvalido</code> without
     * detail message.
     */
    public ExcepcionOrdenInvalido() {
          this("Orden invalida");
    }

    /**
     * Constructs an instance of <code>EXcepcionOrdenInvalido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionOrdenInvalido(String msg) {
      //  super(msg);
    }
}
