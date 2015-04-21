package persistencia;

import Entidades.emprestimo;
import Entidades.livro;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

public interface RepositorioLivro extends Serializable {
  
    public void inserir(livro livro) throws ErroInternoException;

    public livro buscarPorCodigoLivro(int codigo) throws ErroInternoException, ItemInexistenteException;

    public void atualizar(livro livro) throws ErroInternoException, ItemInexistenteException;

    public void remover(int codigo) throws ErroInternoException, ItemInexistenteException;
    
    public List<livro> listar() throws ErroInternoException, ItemInexistenteException;

    
}
