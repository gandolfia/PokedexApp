package com.example.andres.pokedexAPP.pokeapi;

import com.example.andres.pokedexAPP.Models.EvolutionChainResponse;
import com.example.andres.pokedexAPP.Models.PokedexEntryResponse;
import com.example.andres.pokedexAPP.Models.PokemonSort;
import com.example.andres.pokedexAPP.Models.PokemonCompleteInfo;
import com.example.andres.pokedexAPP.Models.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Andres on 11/13/2017.
 */

public interface PokeapiService {



    @GET("pokemon")
    Call<PokemonResponse> GetPokemonList(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<PokemonCompleteInfo> GetPokemonInfo(@Path("id") String id);

    @GET("pokemon-color/5")
    Call<PokemonSort> GetPokemonSearchList(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon-species/{id}")
    Call<PokedexEntryResponse> GetPokedexEntry(@Path("id") String id);

    @GET("evolution-chain/{pokemonevolutionid}")
    Call<EvolutionChainResponse> GetEvolutionChain(@Path("pokemonevolutionid") String id);
}
