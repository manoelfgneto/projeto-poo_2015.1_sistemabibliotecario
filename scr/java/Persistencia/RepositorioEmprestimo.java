package persistencia;

import Entidades.emprestimo;
import Entidades.livro;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

public interface RepositorioEmprestimo extends Serializable{
    
    public void inserir(emprestimo emprestimo) throws ErroInternoException;

    public emprestimo buscarPorCodigo(int codigo) throws ErroInternoException, ItemInexistenteException;
    
    public livro buscarPorCodigoLivro(int codigo) throws ErroInternoException, ItemInexistenteException;
    
    public List<emprestimo> Listar() throws ErroInternoException, ItemInexistenteException;

    public void remover(int emprestimo) throws ErroInternoException, ItemInexistenteException;
}
