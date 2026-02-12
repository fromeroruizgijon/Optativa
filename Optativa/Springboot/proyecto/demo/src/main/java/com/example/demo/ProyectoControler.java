package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class ProyectoControler {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;
    
    @RequestMapping("/")
    public String mostrarInicio(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(usuario == null){
            return "redirect:/login";
        }
        List<Proyecto> misProyectos = proyectoRepository.findByCreador(usuario);
        model.addAttribute("listaProyectos", misProyectos);
        return "index";
    }
    
    @RequestMapping("/crearProyecto")
    public String mostrarFormularioP() {
        return "crearProyecto";
    }
    

    // Modifica ligeramente tu método existente 'insertarProyecto' para aceptar un ID
    @PostMapping("/guardarProyecto") // Cambia la acción del form a esta
    public String guardarProyecto(@RequestParam(name="id", required=false) Long id,
                                  @RequestParam("nombre") String nombre, 
                                  @RequestParam("descripcion") String descripcion, 
                                  HttpSession session) {
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Proyecto proyecto;

        if (id != null) {
            // EDICIÓN: Buscamos el existente y actualizamos datos
            proyecto = proyectoRepository.findById(id).orElse(new Proyecto());
            proyecto.setNombre(nombre);
            proyecto.setDescripcion(descripcion);
        } else {
            // CREACIÓN: Nuevo objeto
            proyecto = new Proyecto(nombre, descripcion, usuario);
        }
        
        proyectoRepository.save(proyecto); // .save() sirve para crear Y para actualizar
        return "redirect:/";
    }
    @RequestMapping("/verProyecto")
    public String verProyecto(@RequestParam(name = "nombre")String nombreProyecto, HttpSession session, Model model) {
       Proyecto proyectoEncontrado = proyectoRepository.findByNombre(nombreProyecto);

       if(proyectoEncontrado != null){
        model.addAttribute("proyecto", proyectoEncontrado);
        return "proyecto";
       }else{
        return "redirect:/";
       }
    }
    
    @RequestMapping("/insertarTareaPrincipal")
    public String insertarTareaPrincipal(@RequestParam(name = "nombreProyecto")String nombreProyecto, @RequestParam(name = "titulo")String titulo, @RequestParam(name = "descripcion")String descripcion, @RequestParam(name = "prioridad")int prioridad) {
        Proyecto proyecto = proyectoRepository.findByNombre(nombreProyecto);

        if(proyecto != null){
            TareaPrincipal tareaPrincipal = new TareaPrincipal(titulo, descripcion, false, prioridad, LocalDate.now());
            proyecto.insertarTarea(tareaPrincipal);
            proyectoRepository.save(proyecto);
        }
        return "redirect:/verProyecto?nombre=" + nombreProyecto;
    }

    @RequestMapping("/insertarTareaSecundaria")
    public String insertarTareaSecundaria(@RequestParam(name = "nombreProyecto")String nombreProyecto,@RequestParam(name = "tituloPrincipal")String tituloPrincipal, @RequestParam(name = "tituloSecundaria")String tituloSecundaria, @RequestParam(name = "descripcion")String descripcion, @RequestParam(name = "prioridad")int prioridad, @RequestParam("categoria")String categoria) {
        Proyecto proyecto = proyectoRepository.findByNombre(nombreProyecto);
        if(proyecto != null){
            for (Tarea t : proyecto.getTareas()) {
                if(t instanceof TareaPrincipal && t.getTitulo().equalsIgnoreCase(tituloPrincipal)){
                    TareaPrincipal tareaPrincipal = (TareaPrincipal) t;
                    TareaSecundaria tareaSecundaria = new TareaSecundaria(categoria, tituloSecundaria, descripcion, false, prioridad, LocalDate.now());
                    tareaPrincipal.insertarSubtarea(tareaSecundaria);
                    proyectoRepository.save(proyecto);
                }
            }
        }
        return "redirect:/verProyecto?nombre=" + nombreProyecto;
    }
    
    @GetMapping("/proyecto/ordenarPrioridad")
    public String ordenarTareasPorPrioridad (@RequestParam("nombre") String nombreProyecto, Model model) {
        Proyecto proyecto = proyectoRepository.findByNombre(nombreProyecto);
        if(proyecto != null){
            proyecto.getTareas().sort((t2, t1) -> t1.getPrioridad() - t2.getPrioridad());

            for (Tarea t  : proyecto.getTareas()) {
                if(t instanceof TareaPrincipal tareaPrincipal){
                    tareaPrincipal.getTareasSecundarias().sort((s2, s1) -> s1.getPrioridad() - s2.getPrioridad());
                }
            }
            model.addAttribute("proyecto", proyecto);
            return "proyecto";
        }else{
            return "redirect:/";
        }
    }
    @RequestMapping("/cambiarEstadoTarea")
    public String cambiarEstadoTarea(@RequestParam("nombreProyecto")String nombreProyecto, @RequestParam("tituloTarea")String tituloTarea,@RequestParam(value = "estado", required = false)Boolean estado) {
        Proyecto proyecto = proyectoRepository.findByNombre(nombreProyecto);
        if(proyecto != null){
            for ( Tarea tarea : proyecto.getTareas()) {
                if(tarea.getTitulo().equalsIgnoreCase(tituloTarea)){
                    tarea.setEstado(estado != null);
                }
            }
            proyectoRepository.save(proyecto);
        }
        return "redirect:/verProyecto?nombre=" + nombreProyecto;
    }
    @GetMapping("/borrarProyecto")
    public String borrarProyecto(@RequestParam("id") Long id) {
        proyectoRepository.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/editarProyecto")
    public String editarProyecto(@RequestParam("id") Long id, Model model) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        model.addAttribute("proyecto", proyecto);
        return "crearProyecto";
    }

    @GetMapping("/borrarTarea")
        public String borrarTarea(@RequestParam("id") Long id, @RequestParam("nombreProyecto") String nombreProyecto) {
            tareaRepository.deleteById(id);
            return "redirect:/verProyecto?nombre=" + nombreProyecto;
        }
    @GetMapping("/descargarPdf")
    public void descargarPdf(@RequestParam("id") Long id, jakarta.servlet.http.HttpServletResponse response) throws java.io.IOException {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        
        if(proyecto != null){
            response.setContentType("application/pdf");
            // Esta línea hace que el navegador te pregunte dónde guardar el archivo
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=proyecto_" + proyecto.getNombre() + ".pdf";
            response.setHeader(headerKey, headerValue);
            
            pdfService.exportarProyecto(response, proyecto);
        }
    }

}
