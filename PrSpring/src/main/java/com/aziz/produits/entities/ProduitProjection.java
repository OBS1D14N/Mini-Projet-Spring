package com.aziz.produits.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomProd", types = { produit.class })
public interface ProduitProjection {
public String getNomProduit();
}