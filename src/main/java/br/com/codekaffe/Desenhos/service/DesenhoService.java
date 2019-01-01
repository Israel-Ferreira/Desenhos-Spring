package br.com.codekaffe.Desenhos.service;

import br.com.codekaffe.Desenhos.models.Desenho;
import br.com.codekaffe.Desenhos.repository.DesenhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesenhoService {
    @Autowired
    private DesenhoRepository desenhoRepository;

    public void salvarDesenho(Desenho desenho){
        desenhoRepository.save(desenho);
    }

    public  void deletarDesenho(String id){
        desenhoRepository.deleteById(id);
    }


    public void updateDesenho(String id, Desenho desenho){
        Desenho desenhoVelho = desenhoRepository.getDesenhoById(id);
        desenhoVelho.setNomeDoDesenho(desenho.getNomeDoDesenho());
        desenhoVelho.setProdutora(desenho.getProdutora());
        desenhoVelho.setRating(desenho.getRating());
        desenhoVelho.setQtdeTemporadas(desenho.getQtdeTemporadas());
        desenhoRepository.save(desenhoVelho);
    }

    public List<Desenho> getAllDesenhos(){
        return desenhoRepository.getDesenhos();
    }

    public Desenho getDesenhoById(String id){
        return desenhoRepository.getDesenhoById(id);
    }


    public List<Desenho> searchCartoonName(String cartoonName){
        List<Desenho> desenhos = desenhoRepository.getDesenhos();
        return desenhos.stream().filter(des -> des.getNomeDoDesenho().contains(cartoonName)).collect(Collectors.toList());
    }

}
