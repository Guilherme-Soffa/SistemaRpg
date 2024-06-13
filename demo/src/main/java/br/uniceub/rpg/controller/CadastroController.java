package br.uniceub.rpg.controller;


import br.uniceub.rpg.comum.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import br.uniceub.rpg.service.CadastrarUsuarioService;
import br.uniceub.rpg.service.dto.UsuarioDTO;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class CadastroController {


    private final CadastrarUsuarioService cadastrarUsuarioService;

    @PostMapping("cadastrar-usuario")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok(this.cadastrarUsuarioService.cadastrar(usuario));
    };

    @GetMapping("login-usuario/{usuario}/{password}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Usuario> logarUsuario(@PathVariable("usuario") String usuario, @PathVariable("password") String password){
        return ResponseEntity.ok(this.cadastrarUsuarioService.login(usuario, password));
    };
    @GetMapping("usuario/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.cadastrarUsuarioService.buscar(id));
    };
}