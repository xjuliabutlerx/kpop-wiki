package net.kpop.wiki.model;

import lombok.Data;

@Data
public class Band {
    private Integer id;

    private String bandName;
    private String label;
    private Integer memberCount;
    private Integer debutYear;
}