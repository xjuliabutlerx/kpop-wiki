package net.kpop.wiki.service;

import net.kpop.wiki.entity.BandEntity;
import net.kpop.wiki.model.Band;
import net.kpop.wiki.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;

    public Flux<Band> getAllBands() {
        return bandRepository.findAll().map(b -> {
            Band band = new Band();
            band.setId(b.getId());
            band.setBandName(b.getBandName());
            band.setLabel(b.getLabel());
            band.setMemberCount(b.getMemberCount());
            band.setDebutYear(b.getDebutYear());
            return band;
        });
    }

    public Mono<Band> saveBand(Band band){
        BandEntity b = new BandEntity();
        b.setId(band.getId());
        b.setBandName(band.getBandName());
        b.setLabel(band.getLabel());
        b.setMemberCount(band.getMemberCount());
        b.setDebutYear(band.getDebutYear());
        return bandRepository.save(b).map(b1 -> {
            Band bandA = new Band();
            bandA.setId(b1.getId());
            bandA.setBandName(b1.getBandName());
            bandA.setLabel(b1.getLabel());
            bandA.setMemberCount(b1.getMemberCount());
            bandA.setDebutYear(b1.getDebutYear());
            return bandA;
        });
    }

    public Mono<Void> deleteBand(Integer id){
        return bandRepository.deleteById(id);
    }

    public Mono<Void> clearBands(){
        return bandRepository.deleteAll();
    }

    public Mono<Band> update(Mono<Band> band) {

        return band
                .flatMap((b) -> bandRepository.findById(b.getId())
                        .flatMap(bandA -> {
                            bandA.setBandName(b.getBandName());
                            bandA.setLabel(b.getLabel());
                            bandA.setMemberCount(b.getMemberCount());
                            bandA.setDebutYear(b.getDebutYear());
                            return bandRepository.save(bandA);

                        }).map(updatedItem -> {
                            Band bandA = new Band();
                            bandA.setId(updatedItem.getId());
                            bandA.setBandName(updatedItem.getBandName());
                            bandA.setLabel(updatedItem.getLabel());
                            bandA.setMemberCount(updatedItem.getMemberCount());
                            bandA.setDebutYear(updatedItem.getDebutYear());
                            return bandA;
                        }));
    }
}
