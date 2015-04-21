package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class livro implements Serializable {
    private List<emprestimo> codigoEmp; 
    private String titulo;
    private String genero;
    private String status;
    private int quantidade;
    private String autor;
    private String campus;
    private int codigo;

    public livro() {
    }

    public livro(List <emprestimo> codigoEmp, String titulo, String genero, String status, int quantidade, String autor, String campus, int codigo) {
        this.codigoEmp = codigoEmp;
        this.titulo = titulo;
        this.genero = genero;
        this.status = status;
        this.quantidade = quantidade;
        this.autor = autor;
        this.campus = campus;
        this.codigo = codigo;
    }

    public List<emprestimo> getCodigoEmp() {
        return codigoEmp;
    }

    public void setCodigoEmp(List<emprestimo> codigoEmp) {
        this.codigoEmp = codigoEmp;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final livro other = (livro) obj;
        if (this.codigoEmp != other.codigoEmp && (this.codigoEmp == null || !this.codigoEmp.equals(other.codigoEmp))) {
            return false;
        }
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        if ((this.genero == null) ? (other.genero != null) : !this.genero.equals(other.genero)) {
            return false;
        }
        if ((this.status == null) ? (other.status != null) : !this.status.equals(other.status)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if ((this.autor == null) ? (other.autor != null) : !this.autor.equals(other.autor)) {
            return false;
        }
        if ((this.campus == null) ? (other.campus != null) : !this.campus.equals(other.campus)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "livro{" + "codigoEmp=" + codigoEmp + ", titulo=" + titulo + ", genero=" + genero + ", status=" + status + ", quantidade=" + quantidade + ", autor=" + autor + ", campus=" + campus + ", codigo=" + codigo + '}';
    }

    
    
    
}
