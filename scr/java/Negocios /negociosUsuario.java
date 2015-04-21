package negocios;

import Entidades.emprestimo;
import Entidades.usuario;
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

public class negociosUsuario implements Serializable {

    private RepositorioUsuario usuarios;
    //private RepositorioLivro livros;
    //private RepositorioEmprestimo emprestimos;

    public negociosUsuario() {
    }

    public void inserir(usuario usuario) throws ErroInternoException, ItemExistenteException {
        try {
            this.usuarios.buscarPorEmail(usuario.getEmail());
            throw new ItemExistenteException("Usuario jÃ¡ Cadastrado!");
        } catch (ItemInexistenteException e) {
            this.usuarios.inserir(usuario);
        } catch (ErroInternoException ex) {
            throw new ErroInternoException(ex.getMessage());
        }
    }
    
    public usuario buscarPorEmail(String email) throws ErroInternoException, ItemInexistenteException {
        return this.usuarios.buscarPorEmail(email);
    }
    
    public void atualizar(usuario usuario) throws ErroInternoException, ItemInexistenteException {
        usuario user = this.buscarPorEmail(usuario.getEmail());
        this.usuarios.atualizar(user);
    }

    public void remover(String email) throws ErroInternoException, ItemInexistenteException {

        usuario user = this.usuarios.buscarPorEmail(email);
        }
 
//    public List <emprestimo> buscarPorTitulo (String tituloE) throws ErroInternoException, ItemInexistenteException {
//        return this.usuarios.buscarPorTitulo(tituloE);
//    }
}
