package net.kpop.wiki.controller;

import net.kpop.wiki.model.Band;
import net.kpop.wiki.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BandController {
    @Autowired
    private BandService bandService;

    @PostMapping("/band")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Band> createBand(@RequestBody Band band){
        return bandService.saveBand(band);
    }

    @GetMapping("/listBands")
    public Flux<Band> getAllBands(){
        return bandService.getAllBands();
    }

    @DeleteMapping("/band/{id}")
    public Mono<Void> deleteBand(@PathVariable Integer id){
        return bandService.deleteBand(id);
    }

    @DeleteMapping("/clearBands")
    public Mono<Void> clear(){
        return bandService.clearBands();
    }

    @PutMapping("/band/{id}")
    public Mono<Band> updateBand(@RequestBody Band band){
        return bandService.update(Mono.just(band));
    }
}
