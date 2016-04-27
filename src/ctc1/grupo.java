
package ctc1;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class grupo {
    private char m[][];
    private ArrayList<Character> elementos;
    public grupo(String filename){
        elementos = new ArrayList();
        int i,j, lenght;
        File file = new File(filename);
        try {
            String aux;
            FileReader reader = new FileReader(file);            
            BufferedReader br = new BufferedReader(reader);
            try {
                //ler a primeira linha
                aux = br.readLine();
                lenght = aux.length();                
                m = new char[lenght][lenght];
                for (i = 0; i<lenght;i++){
                    m[0][i] = aux.charAt(i);
                    elementos.add(aux.charAt(i));
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
        //verifica as linhas        
        int i,j, lenght;
        ArrayList<Character> aux = new ArrayList();
        lenght = elementos.size();
        //verifica as linhas
        for(i = 0; i<lenght; i++){
            for(j = 0; j<lenght; j++){               
                if (elementos.contains(m[i][j]) == false)
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
                if (elementos.contains(m[i][j]) == false)
                    return false;
                if (aux.contains(m[i][j]) == true)
                    return false;
                aux.add(m[i][j]);
            }
            aux.clear();
        }
        return true;
    }
    public char[][] getm(){
        return m;
    }
    public ArrayList gete(){
        return elementos;
    }
}
