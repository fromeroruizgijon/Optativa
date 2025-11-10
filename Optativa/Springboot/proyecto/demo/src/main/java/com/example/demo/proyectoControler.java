package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class proyectoControler {
    
    @RequestMapping("/index")
    public String mostrarInicio() {
        return "index";
    }
    
    @RequestMapping("/crearProyecto")
    public String mostrarFormularioP() {
        return "crearProyecto";
    }
    

    @RequestMapping("/insertarProyecto")
    public String insertarProyecto(@RequestParam("nombre")String nombre, @RequestParam("descripcion")String descripcion, HttpSession session, Model model) {
        boolean existe = false;
        Usuario usuario = (Usuario)session.getAttribute("usuarioLogeado");
        ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>) session.getAttribute("proyectos");
        if(proyectos == null){
            proyectos = new ArrayList<>();
        }
        for (Proyecto proyecto : proyectos) {
            if(proyecto.getNombre().equalsIgnoreCase(nombre)){
                existe = true;
            }
        }
        if(existe){
            model.addAttribute("error", "Ya existe un proyecto con ese nombre");
            return "crearProyecto";
        }
        Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, new ArrayList<>(), usuario);
        proyectos.add(nuevoProyecto);
        session.setAttribute("proyectos", proyectos);
        return "index";
    }
    @RequestMapping("/verProyecto")
    public String verProyecto(@RequestParam(name = "nombre")String nombreProyecto, HttpSession session, Model model) {
        Proyecto proyectoEncontrado = null;
        ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>) session.getAttribute("proyectos");
        if(proyectos == null){
            proyectos = new ArrayList<>();
        }

        for (Proyecto proyecto : proyectos) {
            if(proyecto.getNombre().equalsIgnoreCase(nombreProyecto)){
                proyectoEncontrado = proyecto;
            }
        }

        if(proyectoEncontrado != null){
            model.addAttribute("proyecto", proyectoEncontrado);
            return "proyecto";
        }else{
            model.addAttribute("error", "Proyecto no encontrado");
            return "index";
        }
    }
    
    @RequestMapping("/insertarTareaPrincipal")
    public String insertarTareaPrincipal(@RequestParam(name = "nombreProyecto")String nombreProyecto, @RequestParam(name = "titulo")String titulo, @RequestParam(name = "descripcion")String descripcion, @RequestParam(name = "prioridad")int prioridad, HttpSession session) {
        ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>) session.getAttribute("proyectos");
        if(proyectos == null){
            proyectos = new ArrayList<>();
        }
        Proyecto proyecto = null;
        for (Proyecto p : proyectos) {
            if(p.getNombre().equalsIgnoreCase(nombreProyecto)){
                proyecto = p;
            }
        }
        if(proyecto != null){
            TareaPrincipal tareaPrincipal = new TareaPrincipal(new ArrayList<>(), titulo, descripcion, false, prioridad, LocalDate.now());
            proyecto.insertarTarea(tareaPrincipal);
        }
        session.setAttribute("proyectos", proyectos);
        return "redirect:/verProyecto?nombre=" + nombreProyecto;
    }

    @RequestMapping("/insertarTareaSecundaria")
    public String insertarTareaSecundaria(@RequestParam(name = "nombreProyecto")String nombreProyecto,@RequestParam(name = "tituloPrincipal")String tituloPrincipal, @RequestParam(name = "tituloSecundaria")String tituloSecundaria, @RequestParam(name = "descripcion")String descripcion, @RequestParam(name = "prioridad")int prioridad, @RequestParam("categoria")String categoria, HttpSession session) {
        ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>)session.getAttribute("proyectos");
        if(proyectos == null){
            proyectos = new ArrayList<>();
        }
        Proyecto proyecto = null;
        for (Proyecto p : proyectos) {
            if(p.getNombre().equalsIgnoreCase(nombreProyecto)){
                proyecto = p;
            }
        }
        if(proyecto != null){
            TareaPrincipal tareaPrincipal = null;
            for (Tarea t : proyecto.getTareas()) {
                if(t instanceof TareaPrincipal && t.getTitulo().equalsIgnoreCase(tituloPrincipal)){
                    tareaPrincipal = (TareaPrincipal) t;
                }
            }
            if(tareaPrincipal != null){
                TareaSecundaria tareaSecundaria = new TareaSecundaria(categoria, tituloSecundaria, descripcion, false, prioridad, LocalDate.now());
                tareaPrincipal.insertarSubtarea(tareaSecundaria);
            }
        }
        session.setAttribute("proyectos", proyectos);
       return "redirect:/verProyecto?nombre=" + nombreProyecto;
    }
    
    @GetMapping("/proyecto/ordenarPrioridad")
    public String ordenarTareasPorPrioridad(@RequestParam("nombre") String nombreProyecto, HttpSession session, Model model) {
        ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>) session.getAttribute("proyectos");
        if(proyectos == null){
            proyectos = new ArrayList<>();
        }

        Proyecto proyecto = null;
        for (Proyecto p : proyectos) {
            if(p.getNombre().equalsIgnoreCase(nombreProyecto)){
                proyecto = p;
            }
        }

        if(proyecto != null){
            proyecto.getTareas().sort((t2, t1) -> t1.getPrioridad() - t2.getPrioridad());
            for(Tarea t : proyecto.getTareas()){
                if(t instanceof TareaPrincipal tareaPrincipal){
                    tareaPrincipal.getTareasSecundarias().sort(
                        (s1, s2) -> s1.getPrioridad() - s2.getPrioridad()
                    );
                }
            }
            model.addAttribute("proyecto", proyecto);
            return "proyecto";
        } else {
            model.addAttribute("error", "Proyecto no encontrado");
            return "index";
        }
    }

}
