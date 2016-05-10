/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import com.dropbox.core.DbxException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;

/**
 *
 * @author NandaPC
 */
public class PersistenceTxtImpl implements PersistenceTxt {

    private File arquivo;

    public PersistenceTxtImpl() {
    }

    public boolean salvarTxt(String token, String nome, String email, Date data, String nomeGrupo, List<String> nomeUsu, String mensagem) {
        try {
            this.arquivo = new File(token + ".txt");
            if (!this.arquivo.exists()) {
                this.arquivo.createNewFile();
            }

            String dataS = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(data);

            BufferedWriter bf = new BufferedWriter(new PrintWriter(new FileWriter(arquivo, true)));
            bf.write(email + ";");
            bf.write(nome + ";");
            bf.write(dataS + ";");
            bf.write(nomeGrupo + ";");
            bf.write("{");
            for (int i = 0; i < nomeUsu.size(); i++) {
                if (i == nomeUsu.size() - 1) {
                    bf.write(nomeUsu.get(i) + "");
                } else {
                    bf.write(nomeUsu.get(i) + ",");
                }
            }
            bf.write("};");
            bf.write(mensagem);
            bf.newLine();
            bf.close();
            return true;

        } catch (IOException io) {
            System.out.println("Erro!");
        }

        return false;
    }

    @Override
    public boolean removeTxt(String token) {

//        if(this.arquivo.getName().equals(token)){
//            this.arquivo.delete();
//            return true;
//        }
        File[] arquivos = lerArquivo();
        for (int i = 0; i < arquivos.length; i++) {
            if (arquivos[i].getName().equals(token)) {
                arquivos[i].delete();
                return true;
            }
        }
        return false;
    }

    @Override
    public File[] lerArquivo() {
        File file = new File("D:\\ADS\\5 Periodo\\POD\\Projeto\\Pesistence");
        File[] arquivos = file.listFiles();

//        for (File fileTmp : arquivos) {
//            System.out.println(fileTmp.getName());
//        }
        return arquivos;

    }

    @Override
    public boolean salvar(String token, String email, Date data, String nomeGrupo, List<String> nomeUsu, String mensagem) throws RemoteException, DbxException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
