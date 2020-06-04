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
@Table(name = "heroes")
public class Hero extends BaseEntity{
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private int level;
    @Column
    private int stamina;
    @Column
    private int strength;
    @Column
    private int attack;
    @Column
    private int defence;
    @OneToMany
    private List<Item> inventory;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}

