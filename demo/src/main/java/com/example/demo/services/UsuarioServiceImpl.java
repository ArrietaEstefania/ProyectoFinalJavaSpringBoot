package com.example.demo.services;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {
    @Autowired
    private UsuarioRepository UsuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        UsuarioRepository = usuarioRepository;
    }
}
