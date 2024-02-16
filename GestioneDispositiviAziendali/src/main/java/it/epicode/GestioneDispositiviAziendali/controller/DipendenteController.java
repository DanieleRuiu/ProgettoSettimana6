package it.epicode.GestioneDispositiviAziendali.controller;

import it.epicode.GestioneDispositiviAziendali.model.CustomResponse;
import it.epicode.GestioneDispositiviAziendali.model.DipendenteRequest;
import it.epicode.GestioneDispositiviAziendali.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/dipendenti")
    public ResponseEntity<CustomResponse> getAll(Pageable pageable){

        try {
            return CustomResponse.success(HttpStatus.OK.toString(), dipendenteService.findAll(pageable), HttpStatus.OK);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/dipendenti/{id}")
    public ResponseEntity<CustomResponse> getPersonaById(@PathVariable int id){

        try {
            return CustomResponse.success(HttpStatus.OK.toString(), dipendenteService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/dipendenti")
    public ResponseEntity<CustomResponse> save(@RequestBody @Validated DipendenteRequest dipendenteRequest, BindingResult bindingResult)  {
        if(bindingResult.hasErrors()){
            return CustomResponse.error(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);

        }

        try{
            return CustomResponse.success(HttpStatus.OK.toString(), dipendenteService.save(dipendenteRequest), HttpStatus.OK);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/dipendenti/{id}")
    public ResponseEntity<CustomResponse> updateDipendente(@PathVariable Long id, @RequestBody @Validated DipendenteRequest dipendenteRequest , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return CustomResponse.error(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        try {
            return CustomResponse.success(HttpStatus.OK.toString(), dipendenteService.updateDipendente(id ,dipendenteRequest), HttpStatus.OK);
        } catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/dipendenti/{id}")
    public ResponseEntity<CustomResponse> deleteDipendente(@PathVariable Long id){

        try{
            dipendenteService.deleteById(id);
            return CustomResponse.emptyResponse("Dipendente con id=" + id + " cancellata", HttpStatus.OK);
        }    catch (Exception e){
            return CustomResponse.error(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}












