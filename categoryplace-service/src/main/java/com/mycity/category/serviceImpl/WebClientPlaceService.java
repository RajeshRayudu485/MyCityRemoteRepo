package com.mycity.category.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mycity.shared.placedto.PlaceCategoryDTO;
import com.mycity.shared.placedto.PlaceDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientPlaceService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    
    private static final String PLACE_SERVICE = "PLACE-SERVICE";  
    private static final String PLACE_FETCH_PATH = "/place/placeby/categories";  
    
    
    public Flux<PlaceCategoryDTO> fetchPlaceCategories() {
    	
    	System.err.println("category to place service for getting category");
        return webClientBuilder.baseUrl("lb://" + PLACE_SERVICE)  
            .build()
            .get()
            .uri(PLACE_FETCH_PATH) 
            .retrieve()
            .bodyToFlux(PlaceCategoryDTO.class);
    }

    public Mono<List<PlaceDTO>> getPlacesByCategoryId(String categoryId) {
        return webClientBuilder.baseUrl("lb://" + PLACE_SERVICE)
            .build()
            .get()
            .uri("/place/bycategory/" + categoryId)
            .retrieve()
            .bodyToFlux(PlaceDTO.class)
            .collectList();
    }

}
