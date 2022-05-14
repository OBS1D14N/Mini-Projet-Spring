package com.aziz.produits;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.aziz.produits.entities.Categorie;
import com.aziz.produits.entities.produit;
import com.aziz.produits.repos.ProduitRepository;
import com.aziz.produits.service.ProduitService;
@SpringBootTest
class ProduitsApplicationTests {
@Autowired
private ProduitRepository produitRepository;

@Autowired
private ProduitService produitService;

@Test
public void testCreateProduit() {
produit prod = new produit("PC Dell",2200.500,new Date());
produitRepository.save(prod);
}
@Test
public void testFindProduit()
{
produit p = produitRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdateProduit()
{
produit p = produitRepository.findById(1L).get();
p.setPrixProduit(1000.0);
produitRepository.save(p);
}
@Test
public void testDeleteProduit()
{
produitRepository.deleteById(1L);;
}
 
@Test
public void testListerTousProduits()
{
List<produit> prods = produitRepository.findAll();
for (produit p : prods)
{
System.out.println(p);
}
}
@Test
public void testFindByNomProduitContains()
{
Page<produit> prods = produitService.getAllProduitsParPage(0,2);
System.out.println(prods.getSize());
System.out.println(prods.getTotalElements());
System.out.println(prods.getTotalPages());
prods.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (produit p : prods.getContent()
{
System.out.println(p);
} */
}
@Test
public void testFindByNomProduit()
{
List<produit> prods = produitRepository.findByNomProduit("Clavier");
for (produit p : prods)
{
System.out.println(p);
}
}
@Test
public void findByNomProduitContains()
{
List<produit> prods=produitRepository.findByNomProduitContains("P");
for (produit p : prods)
{
System.out.println(p);
} }
@Test
public void testfindByNomPrix()
{
List<produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
for (produit p : prods)
{
System.out.println(p);
}
}

@Test
public void testfindByCategorie()
{
Categorie cat = new Categorie();
cat.setIdCat(1L);
List<produit> prods = produitRepository.findByCategorie(cat);
for (produit p : prods)
{
System.out.println(p);
}
}
@Test
public void findByCategorieIdCat()
{
List<produit> prods = produitRepository.findByCategorieIdCat(1L);
for (produit p : prods)
{
System.out.println(p);
}
 }
@Test
public void testfindByOrderByNomProduitAsc()
{
List<produit> prods = 
produitRepository.findByOrderByNomProduitAsc();
for (produit p : prods)
{
System.out.println(p);
}
}
@Test
public void testTrierProduitsNomsPrix()
{
List<produit> prods = produitRepository.trierProduitsNomsPrix();
for (produit p : prods)
{
System.out.println(p);
}
}
}
