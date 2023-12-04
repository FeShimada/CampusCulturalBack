package br.com.campuscultural.evento.orm;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.campuscultural.enumeration.SimNaoEnum;
import br.com.campuscultural.usuario.orm.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento extends PanacheEntityBase {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "ulid")
    @Column(name = "id_evento", nullable = false)
    @GenericGenerator(name = "ulid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID idEvento;

    /**
     * professor
     */
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne()
    private Usuario usuario;

    /**
     * Título
     */
    @Column(name = "ds_titulo")
    private String dsTitulo;

    /**
     * Imagem
     */
    @Column(name = "ds_imagem")
    private String dsImagem;

    /**
     * Situação
     */
    @Column(name = "sn_publicado")
    private SimNaoEnum snPublicado;

    /**
     * Data
     */
    @Column(name = "dt_evento")
    private Date dtEvento;

    /**
     * Descrição
     */
    @Column(name = "ds_evento")
    private String dsEvento;

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDsTitulo() {
        return dsTitulo;
    }

    public void setDsTitulo(String dsTitulo) {
        this.dsTitulo = dsTitulo;
    }

    public SimNaoEnum getSnPublicado() {
        return snPublicado;
    }

    public void setSnPublicado(SimNaoEnum snPublicado) {
        this.snPublicado = snPublicado;
    }

    public Date getDtEvento() {
        return dtEvento;
    }

    public void setDtEvento(Date dtEvento) {
        this.dtEvento = dtEvento;
    }

    public String getDsImagem() {
        return dsImagem;
    }

    public void setDsImagem(String dsImagem) {
        this.dsImagem = dsImagem;
    }

    public String getDsEvento() {
        return dsEvento;
    }

    public void setDsEvento(String dsEvento) {
        this.dsEvento = dsEvento;
    }
    
}
