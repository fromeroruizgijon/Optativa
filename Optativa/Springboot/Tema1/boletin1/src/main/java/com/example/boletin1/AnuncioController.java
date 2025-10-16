

@Controller
public class AnuncioController{

    @GetMapping("/anuncio.html")
    public String metodo(){
        return "anuncio";

    }
}
