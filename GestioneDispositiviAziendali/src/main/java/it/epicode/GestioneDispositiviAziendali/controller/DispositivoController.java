package it.epicode.GestioneDispositiviAziendali.controller;
import it.epicode.GestioneDispositiviAziendali.model.Dispositivo;
import it.epicode.GestioneDispositiviAziendali.model.DispositivoRequest;
import it.epicode.GestioneDispositiviAziendali.model.StatoDispositivo;
import it.epicode.GestioneDispositiviAziendali.model.TipoDispositivo;
import it.epicode.GestioneDispositiviAziendali.service.DispositivoService;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;




@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping
    public ResponseEntity getAllDispositivi(Pageable pageable) {

        try {
            return ResponseEntity.ok(dispositivoService.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createDispositivo(@RequestBody DispositivoRequest dispositivo) {
        try {
            return ResponseEntity.ok(dispositivoService.save(dispositivo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/{id}/connect/{dipendente_id}")
    public ResponseEntity connectDispositivo(@PathVariable Long id, @PathVariable Long dipendente_id) {
        try {
            return ResponseEntity.ok(dispositivoService.connectDispositivo(dipendente_id, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}













































//import it.epicode.GestioneDispositiviAziendali.exception.NotFoundException;
//import it.epicode.GestioneDispositiviAziendali.model.CustomResponse;
//import it.epicode.GestioneDispositiviAziendali.model.DispositivoRequest;
//import it.epicode.GestioneDispositiviAziendali.service.DispositivoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.data.domain.Pageable;
//
//
//
//
//@RestController
//@RequestMapping("/dispositivi")
//public class DispositivoController {
//
//    @Autowired
//    private DispositivoService dispositivoService;
//
//    @GetMapping("/all")
//    public ResponseEntity<CustomResponse> getAll(Pageable pageable) {
//        try {
//            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.getAll(pageable), HttpStatus.OK);
//        } catch (Exception e) {
//            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CustomResponse> getDispositivoById(@PathVariable("id") Long id) {
//        try {
//            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.getDispositivoById(id), HttpStatus.OK);
//        } catch (Exception e) {
//            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PostMapping("/add")
//    public ResponseEntity<CustomResponse> addDispositivo(@Validated @RequestBody DispositivoRequest dispositivoRequest, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return CustomResponse.error(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
//        }
//        try {
//            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.save(dispositivoRequest), HttpStatus.OK);
//        } catch (Exception e) {
//            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CustomResponse> updateDispositivo(@PathVariable("id") Long id, @Validated @RequestBody DispositivoRequest dispositivoRequest, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return CustomResponse.error(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
//        }
//        try {
//            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.updateDispositivo(id, dispositivoRequest), HttpStatus.OK);
//        } catch (Exception e) {
//            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<CustomResponse> deleteDispositivo(@PathVariable("id")Long id) {
//        try {
//            dispositivoService.deleteById(id);
//            return CustomResponse.emptyResponse("Dispositivo con id=" + id + " cancellato", HttpStatus.OK);
//        } catch (Exception e) {
//            return CustomResponse.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}



















//    @GetMapping
//    public ResponseEntity getAllDispositivi(Pageable pageable) {

//        try {
//            return ResponseEntity.ok(dispositivoService.findAll((java.awt.print.Pageable) pageable));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity createDispositivo(@RequestBody DispositivoRequest dispositivo) {
//        try {
//            return ResponseEntity.ok(dispositivoService.save(dispositivo));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
//        dispositivoService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//
//    @PostMapping("/{id}/connect/{dipendente_id}")
//    //crea metodo connetti dispositivo
//    public ResponseEntity connectDispositivo(@PathVariable Long id, @PathVariable Long dipendente_id) {
//        try {
//            return ResponseEntity.ok(dispositivoService.connectDispositivo(id, dipendente_id));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//



