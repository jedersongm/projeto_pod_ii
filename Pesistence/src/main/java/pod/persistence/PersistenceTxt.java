/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NandaPC
 */
public interface PersistenceTxt {

    boolean salvarTxt(String token, String nome, String email,Date data, String nomeGrupo,List<String> nomeUsu, String mensagem);
    boolean removeTxt(String token);
    File[] lerArquivo();
    
}
