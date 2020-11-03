package tads.eaj.br.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JogoController {

    JogoService service;

    @Autowired
    public void setService(JogoService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String getHome(Model model) {
        List<Jogo> jogoList = service.findAll();
        model.addAttribute(jogoList);
        return "home";
    }

    @RequestMapping("/cadastrar")
    public  String getCadastrar(Model model){
        var j = new Jogo();
        model.addAttribute("novoJogo", j);
        return "cadastrar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvar(@ModelAttribute Jogo jogo){
        service.save(jogo);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView getEditar(@PathVariable (name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView( "editar");
        Jogo j = service.getById(id);
        modelAndView.addObject("jogo", j );
        return modelAndView;
    }
    @RequestMapping("/deletar/{id}")
    public String doDelete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }

}
