package com.escalab.myexample.service.serviceImpl;

import com.escalab.myexample.entity.Menu;
import com.escalab.myexample.exceptions.MenuNotFoundException;
import com.escalab.myexample.repository.IMenuRepository;
import com.escalab.myexample.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IMenuRepository iMenuRepository;

    @Override
    public Menu create(Menu menu) {
        return iMenuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu, Integer id) {
        Menu updatedMenu = new Menu();
        if (id != null && id > 0) {
            Optional<Menu> menuOptional = iMenuRepository.findById(id);
            if (menuOptional.isPresent()) {
                menu.setIdMenu(id);
                updatedMenu = iMenuRepository.save(menu);
            } else {
                throw new MenuNotFoundException("El numero de Id del menu No Existe");
            }
        }
        return updatedMenu;
    }

    @Override
    public List<Menu> findAll() {
        return iMenuRepository.findAll();
    }

    @Override
    public Menu findById(Integer id) {
        Optional<Menu> menu = iMenuRepository.findById(id);
        if (menu.isPresent()) {
            return menu.get();
        } else {
            throw new MenuNotFoundException("El menu no fue existe");
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer id) {
        Optional<Menu> menu = iMenuRepository.findById(id);
        if (menu.isPresent()) {
            iMenuRepository.delete(menu.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new MenuNotFoundException("El Usuario no fue encontrado");
        }
    }

    @Override
    public List<Menu> listarElMenuDeUsuarioPorNombre(String name) {
        /**
         * este codigo se implementara una vez realizado el front*/

//        List<MenuController> menus = new ArrayList<>();
//        iMenuRepository.listarMenuPorUsuario(name).forEach(names->{
//            MenuController newMenu = new MenuController();
//            newMenu.setIdMenu(Integer.parseInt(String.valueOf(names[0])));
//            newMenu.setIcono(String.valueOf(names[1]));
//            newMenu.setNombre(String.valueOf(names[2]));
//            newMenu.setUrl(String.valueOf(names[3]));
//
//            menus.add(newMenu);
//        });
//        return menus;
        return null;
    }
}
