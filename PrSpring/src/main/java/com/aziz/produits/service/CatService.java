package com.aziz.produits.service;

import java.util.List;

import com.aziz.produits.entities.Categorie;


public interface CatService {

    List <Categorie> findAll();
    
    Categorie saveCategorie(Categorie c);
    Categorie updateCategorie(Categorie c);
    void deleteCategorie(Categorie c);
     void deleteCategorieById(Long id);
     Categorie getCategorie (Long idCat);

}