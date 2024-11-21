package br.uniceub.rpg.controller;

import br.uniceub.rpg.comum.entity.Usuario;
import br.uniceub.rpg.service.CadastrarUsuarioService;
import br.uniceub.rpg.service.dto.UsuarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CadastroControllerTest {

    @Mock
    private CadastrarUsuarioService cadastrarUsuarioService;

    @InjectMocks
    private CadastroController cadastroController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void cadastrarUsuario() {
        Usuario usuario = new Usuario();
        when(cadastrarUsuarioService.cadastrar(any(UsuarioDTO.class))).thenReturn(usuario);

        ResponseEntity<Usuario> response = cadastroController.cadastrarUsuario(new UsuarioDTO());

        assertEquals(ResponseEntity.ok(usuario), response);
        verify(cadastrarUsuarioService, times(1)).cadastrar(any(UsuarioDTO.class));
    }

    @Test
    void logarUsuario() {
        Usuario usuario = new Usuario();
        when(cadastrarUsuarioService.login(anyString(), anyString())).thenReturn(usuario);

        ResponseEntity<Usuario> response = cadastroController.logarUsuario("usuario", "password");

        assertEquals(ResponseEntity.ok(usuario), response);
        verify(cadastrarUsuarioService, times(1)).login("usuario", "password");
    }

    @Test
    void buscarUsuario() {
        Usuario usuario = new Usuario();
        when(cadastrarUsuarioService.buscar(anyLong())).thenReturn(usuario);

        ResponseEntity<Usuario> response = cadastroController.buscarUsuario(1L);

        assertEquals(ResponseEntity.ok(usuario), response);
        verify(cadastrarUsuarioService, times(1)).buscar(1L);
    }

    @Test
    void editarUsuario() {
        Usuario usuario = new Usuario();
        when(cadastrarUsuarioService.editar(any(UsuarioDTO.class))).thenReturn(usuario);

        ResponseEntity<Usuario> response = cadastroController.editarUsuario(new UsuarioDTO());

        assertEquals(ResponseEntity.ok(usuario), response);
        verify(cadastrarUsuarioService, times(1)).editar(any(UsuarioDTO.class));
    }
}