package br.com.campuscultural.usuario.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.campuscultural.enumeration.TipoUsuarioEnum;
import br.com.campuscultural.usuario.dto.UsuarioDto;
import br.com.campuscultural.usuario.orm.Usuario;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UsuarioConverter {

    public Usuario dtoToOrm(UsuarioDto dto, Usuario orm) {

        if(dto.getIdUsuario() != null) {
            orm.setIdUsuario(UUID.fromString(dto.getIdUsuario()));
        }
        orm.setDsNome(dto.getDsNome());
        orm.setDsSobrenome(dto.getDsSobrenome());
        orm.setDsEmail(dto.getDsEmail());
        orm.setSenha(dto.getSenha());
        orm.setTpUsuario(TipoUsuarioEnum.values()[dto.getTpUsuario()]);
        orm.setDsImagem(dto.getDsImagem());
        orm.setDsUsuario(dto.getDsUsuario());

        return orm;
    }

    public Usuario dtoToOrm(UsuarioDto dto) {
        return dtoToOrm(dto, new Usuario());
    }

    public UsuarioDto ormToDto(Usuario orm, UsuarioDto dto) {
        dto.setIdUsuario(String.valueOf(orm.getIdUsuario()));
        dto.setDsNome(orm.getDsNome());
        dto.setDsSobrenome(orm.getDsSobrenome());
        dto.setDsEmail(orm.getDsEmail());
        dto.setSenha(orm.getSenha());
        dto.setTpUsuario(orm.getTpUsuario().ordinal());
        dto.setDsImagem(orm.getDsImagem());
        dto.setDsUsuario(orm.getDsUsuario());
        return dto;
    }

    public UsuarioDto ormToDto(Usuario orm) {
        return ormToDto(orm, new UsuarioDto());
    }

    public List<Usuario> dtoListToOrmList(List<UsuarioDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<UsuarioDto> ormListToDtoList(List<Usuario> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}
