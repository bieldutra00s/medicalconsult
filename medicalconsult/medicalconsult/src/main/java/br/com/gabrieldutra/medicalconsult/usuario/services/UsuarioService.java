package br.com.gabrieldutra.medicalconsult.usuario.services;

import br.com.gabrieldutra.medicalconsult.usuario.domain.Usuario;
import br.com.gabrieldutra.medicalconsult.usuario.repositories.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuário não encontrado", id));

    }

    public void deleteUsuario(Long id) {
        Usuario usuario = buscarUsuario(id);
        usuarioRepository.delete(usuario);
    }
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = buscarUsuario(id);

        usuarioExistente = usuarioAtualizado;
        return usuarioRepository.save(usuarioExistente);
    }
}
