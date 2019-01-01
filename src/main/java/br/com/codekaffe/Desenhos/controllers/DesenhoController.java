package br.com.codekaffe.Desenhos.controllers;

import br.com.codekaffe.Desenhos.models.Desenho;
import br.com.codekaffe.Desenhos.service.DesenhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DesenhoController {
    @Autowired
    private DesenhoService desenhoService;

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/desenhos")
    public List<Desenho> getAll(){
        return desenhoService.getAllDesenhos();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/desenhos/{id}")
    public Desenho getById(@Valid @PathVariable String id){
        return desenhoService.getDesenhoById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/desenhos/search")
    public List<Desenho> searchDesenhos(@Valid @RequestParam String nomeDesenho ){
        return desenhoService.searchCartoonName(nomeDesenho);
    }

    @RequestMapping(method = RequestMethod.POST, value="/api/v1/desenhos/newDesenho")
    public String adicionarDesenho(@Valid @RequestBody Desenho desenho){
        desenhoService.salvarDesenho(desenho);
        return  "Desenho Adicionado com sucesso";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/desenhos/{id}")
    public  String deletarDesenho(@Valid @PathVariable  String id){
        desenhoService.deletarDesenho(id);
        return "Desenho Deletado com Sucesso";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/desenhos/{id}")
    public String atualizarDesenho(@Valid @PathVariable String id, @Valid @RequestBody Desenho desenho){
        desenhoService.updateDesenho(id,desenho);
        return "Desenho Atualizado com sucesso";
    }
}
