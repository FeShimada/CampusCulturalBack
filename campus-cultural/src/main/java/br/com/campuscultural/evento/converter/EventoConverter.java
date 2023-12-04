package br.com.campuscultural.evento.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.campuscultural.enumeration.SimNaoEnum;
import br.com.campuscultural.evento.dto.EventoDto;
import br.com.campuscultural.evento.orm.Evento;
import br.com.campuscultural.usuario.converter.UsuarioConverter;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class EventoConverter {

    @Inject
    UsuarioConverter usuarioConverter;

    public Evento dtoToOrm(EventoDto dto, Evento orm) {

        if(dto.getIdEvento() != null) {
            orm.setIdEvento(UUID.fromString(dto.getIdEvento()));
        }
        orm.setDsTitulo(dto.getDsTitulo());
        orm.setDtEvento(dto.getDtEvento());
        orm.setSnPublicado(SimNaoEnum.values()[dto.getSnPublicado()]);
        orm.setDsImagem(dto.getDsImagem());
        orm.setDsEvento(dto.getDsEvento());

        return orm;
    }

    public Evento dtoToOrm(EventoDto dto) {
        return dtoToOrm(dto, new Evento());
    }

    public EventoDto ormToDto(Evento orm, EventoDto dto) {
        dto.setIdEvento(String.valueOf(orm.getIdEvento()));
        dto.setDsTitulo(orm.getDsTitulo());
        dto.setDtEvento(orm.getDtEvento());
        dto.setSnPublicado(orm.getSnPublicado().ordinal());
        dto.setDsImagem(orm.getDsImagem());
        dto.setDsEvento(orm.getDsEvento());
        dto.setUsuario(usuarioConverter.ormToDto(orm.getUsuario()));
        return dto;
    }

    public EventoDto ormToDto(Evento orm) {
        return ormToDto(orm, new EventoDto());
    }

    public List<Evento> dtoListToOrmList(List<EventoDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<EventoDto> ormListToDtoList(List<Evento> ormList) {
        if (ormList == null) return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}
