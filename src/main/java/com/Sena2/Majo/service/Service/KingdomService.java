package com.Sena2.Majo.service.Service;

import java.util.List;

import com.Sena2.Majo.dto.KingdomDto;
import com.Sena2.Majo.dto.response.KingdomResponseDto;


public interface KingdomService {

List<KingdomResponseDto>findAll ();   // trae toda la losta de reino por DTO

KingdomResponseDto findById (int id); 

List<KingdomResponseDto>filterByName(String name); 
    
KingdomResponseDto save (KingdomDto K); 

KingdomResponseDto update (int id, KingdomDto K);

void delete (int id);  

}