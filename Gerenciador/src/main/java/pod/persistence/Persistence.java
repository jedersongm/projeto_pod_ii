/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import com.dropbox.core.DbxException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NandaPC
 * @param <T>
 */
public interface Persistence extends Remote{
    boolean salvar(String token, String email,Date data, String nomeGrupo,List<String> nomeUsu, String mensagem)throws RemoteException, DbxException, IOException;
    boolean remove(String token);
    void atualizar(String t);
    void buscar();
    
}
