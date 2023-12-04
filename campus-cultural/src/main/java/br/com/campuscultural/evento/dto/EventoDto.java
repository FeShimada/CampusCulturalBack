package br.com.campuscultural.evento.dto;

import java.util.Date;

import br.com.campuscultural.usuario.dto.UsuarioDto;

public class EventoDto {
    
    /**
     * id
     */
    private String idEvento;

    /**
     * professor
     */
    private UsuarioDto usuario;

    /**
     * Título
     */
    private String dsTitulo;

    /**
     * Imagem
     */
    private String dsImagem;

    /**
     * Situação
     */
    private Integer snPublicado;

    /**
     * Data
     */
    private Date dtEvento;

    /**
     * Descrição
     */
    private String dsEvento;

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public String getDsTitulo() {
        return dsTitulo;
    }

    public void setDsTitulo(String dsTitulo) {
        this.dsTitulo = dsTitulo;
    }

    public String getDsImagem() {
        return dsImagem;
    }

    public void setDsImagem(String dsImagem) {
        this.dsImagem = dsImagem;
    }

    public Integer getSnPublicado() {
        return snPublicado;
    }

    public void setSnPublicado(Integer snPublicado) {
        this.snPublicado = snPublicado;
    }

    public Date getDtEvento() {
        return dtEvento;
    }

    public void setDtEvento(Date dtEvento) {
        this.dtEvento = dtEvento;
    }

    public String getDsEvento() {
        return dsEvento;
    }

    public void setDsEvento(String dsEvento) {
        this.dsEvento = dsEvento;
    }
    
}
