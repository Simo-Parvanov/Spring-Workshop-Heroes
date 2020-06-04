package com.parvanov.springworkshopheroes.data.models;

import com.parvanov.springworkshopheroes.data.models.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Slot slot;
    @Column
    private int stamina;
    @Column
    private int strength;
    @Column
    private int attack;
    @Column
    private int defence;
    @ManyToOne
    private Hero heroes;
}
