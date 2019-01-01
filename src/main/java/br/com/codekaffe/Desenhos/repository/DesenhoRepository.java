package br.com.codekaffe.Desenhos.repository;

import br.com.codekaffe.Desenhos.models.Desenho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DesenhoRepository extends MongoRepository<Desenho,String> {
    @Query("{}")
    List<Desenho> getDesenhos();

    Desenho getDesenhoById(String id);

}
