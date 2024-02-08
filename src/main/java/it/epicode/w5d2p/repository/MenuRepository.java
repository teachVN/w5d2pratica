package it.epicode.w5d2p.repository;

import it.epicode.w5d2p.bean.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
