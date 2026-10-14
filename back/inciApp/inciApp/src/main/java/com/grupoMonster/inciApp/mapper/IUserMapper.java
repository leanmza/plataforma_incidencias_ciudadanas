package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.response.UsuarioResponseDTO;
import com.grupoMonster.inciApp.model.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    Usuario toUsuario (UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseDTO toUsuarioResponse (Usuario usuario);

    List<UsuarioResponseDTO> toListUsuarioResponse (List<Usuario> usuarios);

}
