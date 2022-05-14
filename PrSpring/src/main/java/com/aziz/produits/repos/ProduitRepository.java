package com.aziz.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aziz.produits.entities.Categorie;
import com.aziz.produits.entities.produit;
@Repository
public interface ProduitRepository extends JpaRepository<produit, Long> {
	List<produit> findByNomProduit(String nom);
	 List<produit> findByNomProduitContains(String nom);
	 @Query("select p from produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	 List<produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from produit p where p.categorie = ?1")
	 List<produit> findByCategorie (Categorie categorie);
	 List<produit> findByCategorieIdCat(Long id);
	 List<produit> findByOrderByNomProduitAsc();
	 @Query("select p from produit p order by p.nomProduit ASC, p.prixProduit DESC")
	 List<produit> trierProduitsNomsPrix();
}