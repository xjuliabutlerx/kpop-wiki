package net.kpop.wiki.repository;

import net.kpop.wiki.entity.BandEntity;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends ReactiveCassandraRepository<BandEntity, Integer> {
}
