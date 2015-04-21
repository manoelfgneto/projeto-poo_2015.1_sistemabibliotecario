package persistenciaJPA;

import Entidades.emprestimo;
import Entidades.usuario;
import exceÃ§Ãµes.ErroInternoException;
import exceÃ§Ãµes.ItemInexistenteException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import persistencia.RepositorioUsuario;


public class repositorioUsuarioJpa implements RepositorioUsuario{

    @PersistenceContext(unitName = "ProjetoPOOPU")
    private EntityManager em;
    
    public void inserir(usuario usuario) throws ErroInternoException {
    try {
            this.em.persist(usuario);
        } catch (IllegalArgumentException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (TransactionRequiredException e){
            throw new ErroInternoException(e.getMessage());
        } catch (EntityExistsException e) {
            throw new ErroInternoException(e.getMessage());
        }    
    }

    public usuario buscarPorEmail(String email) throws ErroInternoException, ItemInexistenteException {
    try {
            TypedQuery<usuario> query = this.em.createQuery("SELECT u FROM usuario u WHERE u.email=:email", usuario.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new ErroInternoException(e.getMessage());
        }    
    
    }

    public void atualizar(usuario usuario) throws ErroInternoException, ItemInexistenteException {
    try {
            usuario = buscarPorEmail(usuario.getEmail());
            this.em.merge(usuario);
        } catch (ErroInternoException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (ItemInexistenteException e){
            throw new ErroInternoException(e.getMessage());
        }    
    }

    public void remover(String email) throws ErroInternoException, ItemInexistenteException {
    try {
            usuario user = buscarPorEmail(email);
            this.em.remove(user);
        } catch (ErroInternoException e) {
            throw new ErroInternoException(e.getMessage());
        } catch (ItemInexistenteException e){
            throw new ErroInternoException(e.getMessage());
        }    
    }

    public List<emprestimo> buscarPorTitulo(String tituloE) throws ErroInternoException, ItemInexistenteException {
        try {
            TypedQuery<emprestimo> query = this.em.createQuery("SELECT e FROM emprestimo e", emprestimo.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e.getMessage());
        }
    }
    
}
