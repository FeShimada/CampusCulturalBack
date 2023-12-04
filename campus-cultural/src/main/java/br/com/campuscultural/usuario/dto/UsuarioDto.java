package br.com.campuscultural.usuario.dto;

public class UsuarioDto {
    
    /**
     * id
     */
    private String idUsuario;

    /**
     * Nome
     */
    private String dsNome;

    /**
     * Sobrenome
     */
    private String dsSobrenome;

    /**
     * Email
     */
    private String dsEmail;

    /**
     * Senha
     */
    private String senha;

    /**
     * Tipo usuário
     */
    private Integer tpUsuario;

    /**
     * Imagem
     */
    private String dsImagem;

    /**
     * Descrição
     */
    private String dsUsuario;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
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

    public Integer getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(Integer tpUsuario) {
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
