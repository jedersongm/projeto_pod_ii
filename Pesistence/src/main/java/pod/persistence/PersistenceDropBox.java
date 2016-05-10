/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import com.dropbox.core.DbxException;
import com.dropbox.core.v1.DbxEntry;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NandaPC
 */
public interface PersistenceDropBox extends Persistence{

    @Override
    boolean salvar(String token, String email,Date data, String nomeGrupo,List<String> nomeUsu, String mensagem)throws RemoteException, IOException, DbxException;
    void  list(String folder) throws DbxException, RemoteException;
    @Override
    boolean remove(String token) throws RemoteException;
    @Override
    void atualizar(String t) throws RemoteException;
    @Override
    void buscar() throws RemoteException;
}
