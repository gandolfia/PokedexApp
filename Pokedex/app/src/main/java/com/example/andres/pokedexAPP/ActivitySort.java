package com.example.andres.pokedexAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.andres.pokedexAPP.Models.Pokemon;
import com.example.andres.pokedexAPP.Models.PokemonResponse;
import com.example.andres.pokedexAPP.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivitySort extends AppCompatActivity {
    private static final String TAG = "SORT";
    private RecyclerView recyclerView;
    private PokemonTypeAdapter pokemonTypeAdapter;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);

        recyclerView = (RecyclerView) findViewById(R.id.PokemonTypeRecyclereView);
        pokemonTypeAdapter = new PokemonTypeAdapter(this);

        recyclerView.setAdapter(pokemonTypeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetData(0);


    }
    private void GetData(int Offset) {

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonResponse> PokemonResponseCall = service.GetPokemonType();
        PokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if(response.isSuccessful())
                {
                    PokemonResponse pokemonResponse = response.body();
                    ArrayList<Pokemon> pokemonList = pokemonResponse.getResults();

                    pokemonTypeAdapter.addPokemonList(pokemonList);
                }
                else
                {

                    Log.e(TAG, "onResponse: " + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });

    }
}
