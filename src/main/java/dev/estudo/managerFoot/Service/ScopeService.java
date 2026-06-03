package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.exception.ResourceNotFoundException;
import dev.estudo.managerFoot.Entity.Scope;
import dev.estudo.managerFoot.Repository.ScopeRepository;
import org.springframework.stereotype.Service;

@Service
public class ScopeService {

    private final ScopeRepository scopeRepository;

    public ScopeService(ScopeRepository scopeRepository) {
        this.scopeRepository = scopeRepository;
    }

    public Scope findById(Long id){
        return scopeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Scope not found for id: "+id));
    }
}
