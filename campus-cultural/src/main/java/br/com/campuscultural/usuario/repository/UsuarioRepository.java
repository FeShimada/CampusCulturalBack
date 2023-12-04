package br.com.campuscultural.usuario.repository;

import java.util.UUID;

import br.com.campuscultural.usuario.orm.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.NoResultException;

@RequestScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    public Usuario findById(UUID uuid) {
        return Usuario.findById(uuid);
    }

    public Usuario findByEmailAndSenha(String email, String senha) {
        try {
            return find("dsEmail = ?1 and senha = ?2", email, senha).singleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
