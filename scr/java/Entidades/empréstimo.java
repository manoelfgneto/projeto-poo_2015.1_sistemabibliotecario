package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

public class emprestimo implements Serializable {
   private List <usuario> codigoUsu;
   private List <livro> codigoLiv;
   private Date data_empre;
   private Date data_devolucao;
   private int quant;
   private int codigo;

    public emprestimo() {
    }

    public emprestimo(List <livro> codigoLiv, List<usuario> codigoUsu, Date data_empre, Date data_devolucao, int quant, int codigo) {
        this.codigoLiv = codigoLiv;
        this.codigoUsu = codigoUsu;
        this.data_empre = data_empre;
        this.data_devolucao = data_devolucao;
        this.quant = quant;
        this.codigo = codigo;
    }

    
    public List<livro> getCodigoLiv() {
        return codigoLiv;
    }

    public void setCodigoLiv(List<livro> codigoLiv) {
        this.codigoLiv = codigoLiv;
    }

    
    public List<usuario> getCodigoUsu() {
        return codigoUsu;
    }

    
    public void setCodigoUsu(List<usuario> codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getData_empre() {
        return data_empre;
    }

    public void setData_empre(Date data_empre) {
        this.data_empre = data_empre;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final emprestimo other = (emprestimo) obj;
        if (this.codigoUsu != other.codigoUsu && (this.codigoUsu == null || !this.codigoUsu.equals(other.codigoUsu))) {
            return false;
        }
        if (this.codigoLiv != other.codigoLiv && (this.codigoLiv == null || !this.codigoLiv.equals(other.codigoLiv))) {
            return false;
        }
        if (this.data_empre != other.data_empre && (this.data_empre == null || !this.data_empre.equals(other.data_empre))) {
            return false;
        }
        if (this.data_devolucao != other.data_devolucao && (this.data_devolucao == null || !this.data_devolucao.equals(other.data_devolucao))) {
            return false;
        }
        if (this.quant != other.quant) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "emprestimo{" + "codigoUsu=" + codigoUsu + ", codigoLiv=" + codigoLiv + ", data_empre=" + data_empre + ", data_devolucao=" + data_devolucao + ", quant=" + quant + ", codigo=" + codigo + '}';
    }

    
   
}
