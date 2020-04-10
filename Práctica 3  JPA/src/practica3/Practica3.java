/**
 *
 * @author rachelcrosa
 */
package practica3;

import javax.persistence.Persistence;

public class Practica3{
    public static void main(String[] main){
        Persistence.generateSchema("practica3PU", null);
    }
}
