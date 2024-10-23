package br.com.screenmatchfrases.service;

import br.com.screenmatchfrases.model.Frase;
import br.com.screenmatchfrases.model.FraseDTO;
import br.com.screenmatchfrases.repository.FraseRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepositoty repositoty;

    public FraseDTO obterFraseAleatoria(){
        Frase frase = repositoty.buscaFraseAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }

}
