/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NandaPC
 */
public interface PersistenceDropBox extends Remote{

    boolean salvar(String token, String email,Date data, String nomeGrupo,List<String> nomeUsu, String mensagem);
}
