/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.gerenciador;

import com.dropbox.core.DbxException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import pod.persistence.Persistence;

/**
 *
 * @author NandaPC
 */
public interface Gerenciador extends Remote{
    

    public boolean salvar(String token, String email,Date data, String nomeGrupo,List<String> nomeUsu, String mensagem) 
            throws RemoteException, IOException;
       
}
    