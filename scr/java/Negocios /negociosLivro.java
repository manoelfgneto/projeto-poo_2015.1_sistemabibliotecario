package negocios;

import Entidades.emprestimo;
import Entidades.livro;
import exceÃ§Ãµes.EmprestimoAssociadoException;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemExistenteException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.RepositorioEmprestimo;
import persistencia.RepositorioLivro;
import persistencia.RepositorioUsuario;

public class negociosLivro implements Serializable {

    //private RepositorioUsuario usuarios;
    private RepositorioLivro livros;
    //private RepositorioEmprestimo emprestimos;

    private RepositorioEmprestimo repEmprestimo;
    private RepositorioUsuario repUsuario;

    public negociosLivro() {
    }

    public void inserir(livro livro) throws ErroInternoException, ItemExistenteException {
        try {
            this.livros.buscarPorCodigoLivro(livro.getCodigo());
            throw new ItemExistenteException("Livro jÃ¡ Cadastrado!");
        } catch (ItemInexistenteException e) {
            this.livros.inserir(livro);
        } catch (ErroInternoException ex) {
            throw new ErroInternoException(ex.getMessage());
        }
    }

    public livro buscarPorCodigoLivro(int codigo) throws ErroInternoException, ItemInexistenteException {
        return this.livros.buscarPorCodigoLivro(codigo);
    }

    public void atualizar(livro livro) throws ErroInternoException, ItemInexistenteException {
        livro user = this.buscarPorCodigoLivro(livro.getCodigo());
        this.livros.atualizar(user);
    }

    public void remover(int codigo) throws ErroInternoException, ItemInexistenteException, EmprestimoAssociadoException {
        try {
            livro l = this.buscarPorCodigoLivro(codigo);
            livro l2 = this.repEmprestimo.buscarPorCodigoLivro(l.getCodigo());
            throw new EmprestimoAssociadoException();

        } catch (ItemInexistenteException iie) {
            this.livros.remover(codigo);
        }
    }

    public List<livro> listar() throws ErroInternoException, ItemInexistenteException {
        return this.livros.listar();

    }
}
