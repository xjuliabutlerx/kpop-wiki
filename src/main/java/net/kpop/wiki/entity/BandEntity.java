package net.kpop.wiki.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
public class BandEntity {
    @PrimaryKey
    private Integer id;

    private String bandName;
    private String label;
    private Integer memberCount;
    private Integer debutYear;
}
