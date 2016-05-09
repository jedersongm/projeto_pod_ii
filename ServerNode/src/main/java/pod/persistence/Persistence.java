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
 * @param <T>
 */
public interface Persistence<T> extends Remote{
    void salvar(String token, String email,Date data, String nomeGrupo,List<String> nomeUsu, String mensagem);
    void remove(T t);
    void atualizar(T t);
    List<T> buscar();
    
}
