
package ctc1;

import java.util.ArrayList;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean b, c;
        c = false;
        grupo g = new grupo("table 5.txt");
        b = g.isGrupo();
        if (b == true)
            c = g.isSubgrupo("1de");
        g.gete();
        g.getm();
      //  int r = 3;
     //   g.combinationUtil(g.gete(), new char[r], 0, g.gete().length() - 1, 0, r);
    }
    
}
