package negocios;

import Entidades.emprestimo;
import Entidades.livro;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemExistenteException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.io.Serializable;
import java.util.List;
import persistencia.RepositorioEmprestimo;
import persistencia.RepositorioLivro;
import persistencia.RepositorioUsuario;

public class negociosEmprestimo implements Serializable {
    private RepositorioLivro livro;
    private RepositorioUsuario usuario;    
    private RepositorioEmprestimo emprestimo;

    public negociosEmprestimo() {
    }
    
    public void inserir(emprestimo emprestimo) throws ErroInternoException, ItemExistenteException {
        try {
            this.emprestimo.buscarPorCodigoLivro(emprestimo.getCodigo());
            throw new ItemExistenteException("Emprestimo jÃ¡ existente!");
        } catch (ItemInexistenteException e) {
            this.emprestimo.inserir(emprestimo);
        } catch (ErroInternoException ex) {
            throw new ErroInternoException(ex.getMessage());
        }
    }
    
   public emprestimo buscarPorCodigo(int codigo) throws ErroInternoException, ItemInexistenteException{
        return this.emprestimo.buscarPorCodigo(codigo);
    }
    
    public livro buscarPorCodigoLivro(int codigo) throws ErroInternoException, ItemInexistenteException {
        return this.livro.buscarPorCodigoLivro(codigo);
    }
    
    public List<livro> Listar() throws ErroInternoException, ItemInexistenteException {
        return this.livro.listar();        
    }

    public void remover(int codigo) throws ErroInternoException, ItemInexistenteException, ErroInternoException {

        livro liv = this.livro.buscarPorCodigoLivro(codigo);
    }
}
