package persistenciaJPA;

import Entidades.livro;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import persistencia.RepositorioLivro;

public class repositorioLivroJpa implements RepositorioLivro {

    @PersistenceContext(unitName = "ProjetoPOOPU")
    private EntityManager em;
    
    public void inserir(livro livro) throws ErroInternoException {
    try {
            this.em.persist(livro);
        } catch (IllegalArgumentException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (TransactionRequiredException e){
            throw new ErroInternoException(e.getMessage());
        } catch (EntityExistsException e) {
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

    public void atualizar(livro livro) throws ErroInternoException, ItemInexistenteException {
        try {
            livro = buscarPorCodigoLivro(livro.getCodigo());
            this.em.merge(livro);
        } catch (ErroInternoException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (ItemInexistenteException e){
            throw new ErroInternoException(e.getMessage());
        }
    }

    public void remover(int codigo) throws ErroInternoException, ItemInexistenteException {
        try {
            livro user = buscarPorCodigoLivro(codigo);
            this.em.remove(user);
        } catch (ErroInternoException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (ItemInexistenteException e){
            throw new ErroInternoException(e.getMessage());
        }
    }

    public List<livro> listar() throws ErroInternoException, ItemInexistenteException {
           try {
            TypedQuery<livro> query = this.em.createQuery("SELECT l FROM Livro l", livro.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e.getMessage());
        }
    }

    
}
