package br.com.campuscultural.evento.repository;

import java.util.List;
import java.util.UUID;

import br.com.campuscultural.evento.orm.Evento;
import br.com.campuscultural.usuario.orm.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class EventoRepository implements PanacheRepository<Evento> {
    public Evento findById(UUID uuid) {
        return Evento.findById(uuid);
    }

    public List<Evento> listByUser(Usuario usuario) {
        return find("usuario", usuario).list();
    }
}
