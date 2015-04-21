package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class usuario implements Serializable{
    
    private List <emprestimo> quantL;
    private List <emprestimo> codigoEmp;
    private String nome;
    private String email;
    private String senha;
    private String fone;
    private String campus;
    private int quantE;
    private int codigo2;

    public usuario() {
    }

    public usuario(List<emprestimo> quantL, List<emprestimo> codigoEmp, String nome, String email, String senha, String fone, String campus, int quantE, int codigo2) {
        this.quantL = quantL;
        this.codigoEmp = codigoEmp;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.fone = fone;
        this.campus = campus;
        this.quantE = quantE;
        this.codigo2 = codigo2;
    }

    public List<emprestimo> getQuantL() {
        return quantL;
    }

    public void setQuantL(List<emprestimo> quantL) {
        this.quantL = quantL;
    }

    public List<emprestimo> getCodigoEmp() {
        return codigoEmp;
    }

    public void setCodigoEmp(List<emprestimo> codigoEmp) {
        this.codigoEmp = codigoEmp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public int getQuantE() {
        return quantE;
    }

    public void setQuantE(int quantE) {
        this.quantE = quantE;
    }

    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getCodigo2() {
        return codigo2;
    }

    public void setCodigo2(int codigo2) {
        this.codigo2 = codigo2;
    }

    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final usuario other = (usuario) obj;
        if (this.quantL != other.quantL && (this.quantL == null || !this.quantL.equals(other.quantL))) {
            return false;
        }
        if (this.codigoEmp != other.codigoEmp && (this.codigoEmp == null || !this.codigoEmp.equals(other.codigoEmp))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if ((this.fone == null) ? (other.fone != null) : !this.fone.equals(other.fone)) {
            return false;
        }
        if ((this.campus == null) ? (other.campus != null) : !this.campus.equals(other.campus)) {
            return false;
        }
        if (this.quantE != other.quantE) {
            return false;
        }
        if (this.codigo2 != other.codigo2) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "usuario{" + "quantL=" + quantL + ", codigoEmp=" + codigoEmp + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", fone=" + fone + ", campus=" + campus + ", quantE=" + quantE + ", codigo2=" + codigo2 + '}';
    }

    

    
}
