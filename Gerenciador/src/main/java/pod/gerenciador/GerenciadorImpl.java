/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.gerenciador;

import com.dropbox.core.DbxException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pod.persistence.Persistence;

/**
 *
 * @author NandaPC
 */
public class GerenciadorImpl implements Gerenciador{

    Persistence persistence;
    @Override
    public boolean salvar(String token, String email, Date data, String nomeGrupo, List<String> nomeUsu, String mensagem) throws RemoteException, IOException {
        try {
            persistence.salvar(token, email, data, nomeGrupo, nomeUsu, mensagem);
        } catch (DbxException ex) {
            Logger.getLogger(GerenciadorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
