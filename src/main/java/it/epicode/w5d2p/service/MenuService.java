package it.epicode.w5d2p.service;

import it.epicode.w5d2p.bean.Item;
import it.epicode.w5d2p.bean.Menu;
import it.epicode.w5d2p.repository.ItemRepository;
import it.epicode.w5d2p.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public void salvaMenu(Menu menu){
        menuRepository.save(menu);
    }

    public Menu cercaMenuPerId(int id){
        return menuRepository.findById(id).get();
    }

    public List<Menu> cercaTuttiIMenu(){
        return menuRepository.findAll();
    }

    public void cancellaMenuPerId(int id){
        menuRepository.deleteById(id);
    }
}
