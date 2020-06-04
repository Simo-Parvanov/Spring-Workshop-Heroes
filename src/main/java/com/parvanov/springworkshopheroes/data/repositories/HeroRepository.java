package com.parvanov.springworkshopheroes.data.repositories;

import com.parvanov.springworkshopheroes.data.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Long> {
    Hero findHeroByName(String name);
}
