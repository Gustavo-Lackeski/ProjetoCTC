
package ctc1;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class grupo {
    private char m[][];
    private String elementos;
    private ArrayList<String> subgrupos;
    public grupo(String filename){
        elementos = "";
        subgrupos = new ArrayList<String>();
        int i,j, lenght;
        File file = new File(filename);
        try {
            String aux;
            FileReader reader = new FileReader(file);            
            BufferedReader br = new BufferedReader(reader);
            try {
                //ler a primeira linha
                elementos = br.readLine();
                lenght = elementos.length();                
                m = new char[lenght][lenght];
                for (i = 0; i<lenght;i++){
                    m[0][i] = elementos.charAt(i);
                }
                //ler o resto
                for(i = 1; i < lenght; i++){
                    aux = br.readLine();
                    for(j = 0; j <lenght; j++){                        
                        m[i][j] = aux.charAt(j);
                    }     
                }
                           
            }
            catch (IOException ex) {
                Logger.getLogger(grupo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try { 
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(grupo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        }
        
        
    }
    //construtor que le o arquivo em monta a tabela
    public boolean isGrupo() {       
        int i,j, lenght;
        ArrayList<Character> aux = new ArrayList();
        lenght = elementos.length();
        //verifica as linhas
        for(i = 0; i<lenght; i++){
            for(j = 0; j<lenght; j++){                
                if (elementos.indexOf(m[i][j]) == -1)
                    return false;
                if (aux.contains(m[i][j]) == true)
                    return false;
                aux.add(m[i][j]);
            }
            aux.clear();
        }
        //verifica as colunas
        aux.clear();        
        for(j = 0; i<lenght; i++){
            for(i = 0; j<lenght; j++){               
                if (elementos.indexOf(m[i][j]) == -1)
                    return false;
                if (aux.contains(m[i][j]) == true)
                    return false;
                aux.add(m[i][j]);
            }
            aux.clear();
        }
        return true;
    }
    //verifica se a string subgrupo contem um subgrupo
    public boolean isSubgrupo(String subgrupo){
        int i,j, lenght;
        ArrayList<Character> aux = new ArrayList();
        lenght = elementos.length();
        //verifica as linhas
        for(i = 0; i<lenght; i++)
            if (subgrupo.indexOf(m[i][0]) != -1 )
                for(j = 0; j<lenght; j++)
                    if (subgrupo.indexOf(m[0][j]) != -1)
                        if (subgrupo.indexOf(m[i][j]) == -1)
                            return false;         
        return true;        
    }
    //encontra as combinacoes de elementos, r a r
    //futuramente: verificar se eh subgrupo
    //BASEADO EM: http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
    public void combinationUtil(String elementos, char data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {               
               if(this.isSubgrupo(String.copyValueOf(data)))
                   subgrupos.add(String.copyValueOf(data));
               return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = elementos.charAt(i);
            combinationUtil(elementos, data, i+1, end, index+1, r);
        }
    }
    public char[][] getm(){
        return m;
    }
    public String gete(){
        return elementos;
    }
    public ArrayList<String> getSubGrupos(){
        return subgrupos;
    }
}
