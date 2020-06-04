package com.parvanov.springworkshopheroes.data.repositories;

import com.parvanov.springworkshopheroes.data.models.Hero;
import com.parvanov.springworkshopheroes.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByHeroes(Hero hero);
}
