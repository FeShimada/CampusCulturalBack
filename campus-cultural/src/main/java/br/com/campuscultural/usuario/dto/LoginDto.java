package br.com.campuscultural.usuario.dto;

public class LoginDto {

    /**
     * Senha
     */
    private String senha;

     /**
     * Email
     */
    private String dsEmail;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }
    
}
