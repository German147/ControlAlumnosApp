package com.escalab.myexample.repository;

import com.escalab.myexample.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuRepository extends JpaRepository<Menu,Integer> {
}
