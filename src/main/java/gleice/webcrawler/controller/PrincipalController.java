/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gleice.webcrawler.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
    
    @Autowired
    private PesquisadorService pesquisador;
   
    @RequestMapping("/principal")
    public String principal(){
        return "principal";
    }
    
    @RequestMapping("/buscar")
    public String buscar(String reds, Model model) throws IOException{
        
        model.addAttribute("lista", pesquisador.quebraString(reds));
        return "buscar";
    }
    
    
}

