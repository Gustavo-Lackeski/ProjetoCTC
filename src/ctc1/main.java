
package ctc1;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        boolean b;
        int r;
        grupo g = new grupo("table 8.txt");
        b = g.isGrupo();
        if (b == true){
            for(r = 1; r <= g.gete().length() ; r++)
                if ((g.gete().length())% r == 0)
                 g.combinationUtil(g.gete(), new char[r], 0, g.gete().length() - 1, 0, r);
        }
        g.getm(); //so para teste ignorar
        //g.getSubGrupos() : retorna ArrayList<String> que contem todos os subgrupos
    }
    
}
