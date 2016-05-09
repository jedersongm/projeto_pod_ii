/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import java.util.Date;
import java.util.List;

/**
 *
 * @author NandaPC
 */
public class PersistenceImpl implements Persistence<Object>{
    PersistenceTxtImpl persistence = null;
    PersistenceDropBox persistenceDropBox = null;

    @Override
    public boolean salvar(String token, String email,Date data, String nomeGrupo,List<String> nomeUsu, String mensagem){
        persistence.salvarTxt(token, token, email, data, nomeGrupo, nomeUsu, mensagem);
        persistenceDropBox.salvar(token, email, data, nomeGrupo, nomeUsu, mensagem);
        return true;
        
        }

    @Override
    public boolean remove(String token){
        persistence.removeTxt(token);
        return true;
        }

    @Override
    public void atualizar(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
