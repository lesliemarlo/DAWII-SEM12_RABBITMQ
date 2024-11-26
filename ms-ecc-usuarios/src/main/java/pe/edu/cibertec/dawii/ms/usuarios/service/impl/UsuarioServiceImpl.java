package pe.edu.cibertec.dawii.ms.usuarios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ms.usuarios.model.Usuario;
import pe.edu.cibertec.dawii.ms.usuarios.repository.UsuarioRepository;
import pe.edu.cibertec.dawii.ms.usuarios.rmq.Notificacion;
import pe.edu.cibertec.dawii.ms.usuarios.rmq.NotificacionSender;
import pe.edu.cibertec.dawii.ms.usuarios.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	NotificacionSender notificacionSender;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> obtenerTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> obtenerUsuarioPorId(Long idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}

	@Override
	public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		//registro sìncrono, depende de la BD
		Usuario usuarioRegistrado = usuarioRepository.save(usuario);
		
		//registro asìncrono -- dispara y olvida
		Notificacion notificacion =Notificacion.builder()
				.asunto("Usuario creado con èxito")
				.contenido("Su usuario fue creado con éxito...")
				.email(usuario.getEmail())
				.build();
		notificacionSender.enviarNotificacion(notificacion);
		return usuarioRegistrado;
	}
	
	@Override
	public Optional<Usuario> actualizarUsuario(Usuario usuario, Long idUsuario) {
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(idUsuario);
		return usuarioEncontrado.map(usuarioExistente -> {
			usuarioExistente.setNombre(usuario.getNombre());
			usuarioExistente.setApellidos(usuario.getApellidos());
			usuarioExistente.setEmail(usuario.getEmail());
			return usuarioRepository.save(usuarioExistente);
		});
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		/*
		 * Optional<Usuario> usuarioEliminar = usuarioRepository.findById(idUsuario);
		 * if(usuarioEliminar.isPresent()) {
		 * usuarioRepository.delete(usuarioEliminar.get()); }
		 */
		usuarioRepository.deleteById(idUsuario);
	}

}
