package br.com.campuscultural.usuario.orm;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.campuscultural.enumeration.TipoUsuarioEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends PanacheEntityBase {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "ulid")
    @Column(name = "id_usuario", nullable = false)
    @GenericGenerator(name = "ulid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID idUsuario;

    /**
     * Nome
     */
    @Column(name = "ds_nome")
    private String dsNome;

    /**
     * Sobrenome
     */
    @Column(name = "ds_sobrenome")
    private String dsSobrenome;

    /**
     * Email
     */
    @Column(name = "ds_email")
    private String dsEmail;

    /**
     * Senha
     */
    @Column(name = "senha")
    private String senha;

    /**
     * Tipo usuário
     */
    @Column(name = "tp_usuario")
    private TipoUsuarioEnum tpUsuario;

    /**
     * Imagem
     */
    @Column(name = "ds_imagem")
    private String dsImagem;

    /**
     * Descrição
     */
    @Column(name = "ds_usuario")
    private String dsUsuario;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDsNome() {
        return dsNome;
    }

    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public String getDsSobrenome() {
        return dsSobrenome;
    }

    public void setDsSobrenome(String dsSobrenome) {
        this.dsSobrenome = dsSobrenome;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuarioEnum getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(TipoUsuarioEnum tpUsuario) {
        this.tpUsuario = tpUsuario;
    }

    public String getDsImagem() {
        return dsImagem;
    }

    public void setDsImagem(String dsImagem) {
        this.dsImagem = dsImagem;
    }

    public String getDsUsuario() {
        return dsUsuario;
    }

    public void setDsUsuario(String dsUsuario) {
        this.dsUsuario = dsUsuario;
    }

    
    
}
