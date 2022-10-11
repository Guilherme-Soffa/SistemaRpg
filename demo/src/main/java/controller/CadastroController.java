package controller;


import comum.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import service.CadastrarUsuarioService;
import service.dto.UsuarioDTO;

@RestController
@RequestMapping("/api/cadastrar/")
@RequiredArgsConstructor
public class CadastroController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @PostMapping("usuario")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok(this.cadastrarUsuarioService.cadastrar(usuario));
    };


}