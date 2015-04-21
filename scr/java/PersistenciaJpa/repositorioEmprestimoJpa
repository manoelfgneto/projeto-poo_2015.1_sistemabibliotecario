package persistenciaJPA;

import Entidades.emprestimo;
import Entidades.livro;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import persistencia.RepositorioEmprestimo;

public class repositorioEmprestimoJpa implements RepositorioEmprestimo {

    @PersistenceContext(unitName = "ProjetoPOOPU")
    private EntityManager em;
    
    @Override
  
    public void inserir(emprestimo emprestimo) throws ErroInternoException {
        try {
            this.em.persist(emprestimo);
        } catch (IllegalArgumentException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (TransactionRequiredException e){
            throw new ErroInternoException(e.getMessage());
        } catch (EntityExistsException e) {
            throw new ErroInternoException(e.getMessage());
        }    
    }

    public emprestimo buscarPorCodigo(int codigo) throws ErroInternoException, ItemInexistenteException {
    try {
            emprestimo user;
            user = this.em.find(emprestimo.class, codigo);
            if (user == null) {
                throw new ItemInexistenteException("Emprestimo Inexistente!");
            }
            return user;
        } catch (IllegalArgumentException e) {
            throw new ErroInternoException(e.getMessage());
        }    
    }

    public livro buscarPorCodigoLivro(int codigo) throws ErroInternoException, ItemInexistenteException {
    try {
            livro user;
            user = this.em.find(livro.class, codigo);
            if (user == null) {
                throw new ItemInexistenteException("Livro nÃ£o encontrado!");
            }
            return user;
        } catch (IllegalArgumentException e) {
            throw new ErroInternoException(e.getMessage());
        }
    }

    public List<emprestimo> Listar() throws ErroInternoException, ItemInexistenteException {
        try {
            TypedQuery<emprestimo> query = this.em.createQuery("SELECT e FROM Usuario e", emprestimo.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e.getMessage());
        }
    }

    public void remover(int emprestimo) throws ErroInternoException, ItemInexistenteException {
        
    try {
            emprestimo user = buscarPorCodigo(emprestimo);
            this.em.remove(user);
        } catch (ErroInternoException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (ItemInexistenteException e){
            throw new ErroInternoException(e.getMessage());
        }
    }
    
}
