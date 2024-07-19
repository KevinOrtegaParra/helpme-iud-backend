package com.helpmeiud.helpmeiud_backend.services.ifaces;

import com.helpmeiud.helpmeiud_backend.dtos.usuarios.UsuarioRequestDTO;
import com.helpmeiud.helpmeiud_backend.dtos.usuarios.UsuarioRequestUpdateDTO;
import com.helpmeiud.helpmeiud_backend.dtos.usuarios.UsuarioResponseDTO;
import com.helpmeiud.helpmeiud_backend.exceptions.RestException;
import com.helpmeiud.helpmeiud_backend.models.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioResponseDTO> consultarTodos() throws RestException;

    UsuarioResponseDTO registrar(UsuarioRequestDTO usuarioRequestDTO)  throws RestException;

    UsuarioResponseDTO consultarPorID(Long id)  throws RestException;

    Usuario findByUsername(String username);

    UsuarioResponseDTO consultarPorUsername(Authentication authentication) throws RestException;

    UsuarioResponseDTO actualizar(UsuarioRequestUpdateDTO usuarioRequestUpdateDTO, Authentication authentication) throws RestException;

    UsuarioResponseDTO subirImagen(MultipartFile image, Authentication authentication) throws RestException;
    
    Resource obtenerImagen(String name) throws RestException;
}
