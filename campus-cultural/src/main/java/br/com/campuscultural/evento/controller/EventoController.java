package br.com.campuscultural.evento.controller;

import jakarta.enterprise.context.RequestScoped;
import java.util.List;
import java.util.UUID;

import br.com.campuscultural.evento.converter.EventoConverter;
import br.com.campuscultural.evento.dto.EventoDto;
import br.com.campuscultural.evento.orm.Evento;
import br.com.campuscultural.evento.repository.EventoRepository;
import br.com.campuscultural.usuario.orm.Usuario;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class EventoController {

    @Inject
    EventoConverter eventoConverter;

    @Inject
    EventoRepository eventoRepository;

    @Transactional
    public EventoDto create(EventoDto eventoDto) {
        Evento evento = eventoConverter.dtoToOrm(eventoDto);

        Usuario usuario = Usuario.findById(UUID.fromString(eventoDto.getUsuario().getIdUsuario()));
        evento.setUsuario(usuario);

        eventoRepository.persist(evento);
        return eventoConverter.ormToDto(evento, eventoDto);
    }

    public EventoDto retrieve(UUID uuid) {
        return eventoConverter.ormToDto(eventoRepository.findById(uuid));
    }

    public List<EventoDto> retrieveAll() {
        List<Evento> eventoList = eventoRepository.listAll();
        return eventoConverter.ormListToDtoList(eventoList);
    }

    @Transactional
    public EventoDto update(EventoDto eventoDto) {
        Evento evento = eventoRepository.findById(UUID.fromString(eventoDto.getIdEvento()));

        Usuario usuario = Usuario.findById(UUID.fromString(eventoDto.getUsuario().getIdUsuario()));
        evento.setUsuario(usuario);

        eventoConverter.dtoToOrm(eventoDto, evento);
        eventoRepository.persist(evento);
        return eventoDto;
    }

    public List<EventoDto> retrieveByUserId(UUID idUsuario) {
        Usuario usuario = Usuario.findById(idUsuario);
        List<Evento> eventoList = eventoRepository.listByUser(usuario);
        return eventoConverter.ormListToDtoList(eventoList);
    }
}
