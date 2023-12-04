package br.com.campuscultural.usuario.controller;

import jakarta.enterprise.context.RequestScoped;
import java.util.List;
import java.util.UUID;

import br.com.campuscultural.exception.LoginException;
import br.com.campuscultural.usuario.converter.UsuarioConverter;
import br.com.campuscultural.usuario.dto.LoginDto;
import br.com.campuscultural.usuario.dto.UsuarioDto;
import br.com.campuscultural.usuario.orm.Usuario;
import br.com.campuscultural.usuario.repository.UsuarioRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class UsuarioController {

    @Inject
    UsuarioConverter usuarioConverter;

    @Inject
    UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDto create(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioConverter.dtoToOrm(usuarioDto);

        usuarioRepository.persist(usuario);
        return usuarioConverter.ormToDto(usuario, usuarioDto);
    }

    public UsuarioDto retrieve(UUID uuid) {
        return usuarioConverter.ormToDto(usuarioRepository.findById(uuid));
    }

    public List<UsuarioDto> retrieveAll() {
        List<Usuario> usuarioList = usuarioRepository.listAll();
        return usuarioConverter.ormListToDtoList(usuarioList);
    }

    @Transactional
    public UsuarioDto update(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(UUID.fromString(usuarioDto.getIdUsuario()));

        usuarioConverter.dtoToOrm(usuarioDto, usuario);
        usuarioRepository.persist(usuario);
        return usuarioDto;
    }

    public UsuarioDto login(LoginDto loginDto) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(loginDto.getDsEmail(), loginDto.getSenha());
    
        if (usuario != null) {
            UsuarioDto usuarioDto = usuarioConverter.ormToDto(usuario);
            return usuarioDto;
        } else {
            throw new LoginException("Erro de login: Credenciais inválidas");
        }
    }
    
}
