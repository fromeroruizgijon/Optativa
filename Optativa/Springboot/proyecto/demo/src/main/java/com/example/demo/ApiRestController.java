package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // --- GET: Listar todos (Ya lo tenías) ---
    @GetMapping("/proyectos")
    public List<Proyecto> listarProyectos() {
        return proyectoRepository.findAll();
    }
    
    // --- GET: Buscar por patrón (Ya lo tenías) ---
    @GetMapping("/proyectos/buscar")
    public List<Proyecto> buscarProyectos(@RequestParam String texto) {
        List<Proyecto> todos = proyectoRepository.findAll();
        return todos.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(texto.toLowerCase()))
                .toList();
    }

    // --- POST: Crear un nuevo proyecto ---
    // @RequestBody convierte el JSON que envías desde Swagger a un objeto Java
    @PostMapping("/proyectos")
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        // Guardamos el proyecto tal cual viene
        return proyectoRepository.save(proyecto);
    }

    // --- PUT: Modificar un proyecto existente ---
    // @PathVariable pilla el número de la URL (/api/proyectos/5)
    @PutMapping("/proyectos/{id}")
    public Proyecto actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyectoDatosNuevos) {
        // 1. Buscamos si existe el proyecto con ese ID
        Proyecto proyectoExistente = proyectoRepository.findById(id).orElse(null);
        
        if (proyectoExistente != null) {
            // 2. Actualizamos solo los campos que queremos cambiar
            proyectoExistente.setNombre(proyectoDatosNuevos.getNombre());
            proyectoExistente.setDescripcion(proyectoDatosNuevos.getDescripcion());
            
            // 3. Guardamos los cambios
            return proyectoRepository.save(proyectoExistente);
        }
        return null; // O podrías lanzar una excepción si no existe
    }

    // --- DELETE: Borrar un proyecto ---
    @DeleteMapping("/proyectos/{id}")
    public String borrarProyecto(@PathVariable Long id) {
        // Verificamos si existe antes de borrar para evitar errores
        if (proyectoRepository.existsById(id)) {
            proyectoRepository.deleteById(id);
            return "Proyecto eliminado correctamente";
        }
        return "El proyecto no existe";
    }
}