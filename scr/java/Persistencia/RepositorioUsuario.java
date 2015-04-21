package persistencia;

import Entidades.emprestimo;
import Entidades.usuario;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

public interface RepositorioUsuario extends Serializable{
    
    public void inserir(usuario usuario) throws ErroInternoException;

    public usuario buscarPorEmail(String email) throws ErroInternoException, ItemInexistenteException;

    public void atualizar(usuario usuario) throws ErroInternoException, ItemInexistenteException;

    public void remover(String email) throws ErroInternoException, ItemInexistenteException;
    
    public List<emprestimo> buscarPorTitulo(String tituloE) throws ErroInternoException, ItemInexistenteException;
}
