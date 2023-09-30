package med.voil.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voil.api.Topicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository topicosRepository;
    @PostMapping
    public void registarTopico(@RequestBody @Valid DatosregistroTopicos datosregistroTopicos){
        System.out.println(datosregistroTopicos.curso());
        topicosRepository.save(new Topicos(datosregistroTopicos));
    }

    @GetMapping
    public Page<Topicos> listadoTopicos(@PageableDefault() Pageable paginacion){
        return  topicosRepository.findAll(paginacion);
    }

    @GetMapping("/{id}")
    public Optional<Topicos> getByIdTopicos(@PathVariable Long id){
        return topicosRepository.findById(id);
    }

    @PutMapping
    @Transactional
    public void actualizaTopico(@RequestBody @Valid ActualizaTopico actualizatopico){
        Topicos topicos = topicosRepository.getReferenceById(actualizatopico.id());
        topicos.actualizarDatos(actualizatopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topicos topico = topicosRepository.getReferenceById(id);
        topicosRepository.delete(topico);
    }
}
