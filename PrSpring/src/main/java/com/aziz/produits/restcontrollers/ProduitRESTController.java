package com.aziz.produits.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.produits.entities.produit;
import com.aziz.produits.service.ProduitService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
@Autowired
ProduitService produitService;
@RequestMapping(method = RequestMethod.GET)
public List<produit> getAllProduits() {
return produitService.getAllProduits();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public produit getProduitById(@PathVariable("id") Long id) {
return produitService.getProduit(id);
 }
@RequestMapping(method = RequestMethod.POST)
public produit createProduit(@RequestBody produit produit) {
return produitService.saveProduit(produit);
}
@RequestMapping(method = RequestMethod.PUT)
public produit updateProduit(@RequestBody produit produit) {
return produitService.updateProduit(produit);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteProduit(@PathVariable("id") Long id)
{
produitService.deleteProduitById(id);
}
@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
public List<produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
return produitService.findByCategorieIdCat(idCat);
}
}
