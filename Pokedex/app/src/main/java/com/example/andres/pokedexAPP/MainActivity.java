package com.example.andres.pokedexAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.andres.pokedexAPP.Models.Pokemon;
import com.example.andres.pokedexAPP.Models.PokemonResponse;
import com.example.andres.pokedexAPP.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "POKEDEX";
    public static String urltopass;
    private Retrofit retrofit;
    private int Offset;
    private boolean ReadyToLoad;
    private Button button;

    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_activity);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        pokemonListAdapter = new PokemonListAdapter(this);
        button.setVisibility(View.INVISIBLE);
        recyclerView.setAdapter(pokemonListAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {

                    int visibleitemcount = layoutManager.getChildCount();
                    int totalitemcount = layoutManager.getItemCount();
                    int pastvisibleitems = layoutManager.findFirstVisibleItemPosition();

                    if (ReadyToLoad) {
                        if ((visibleitemcount + pastvisibleitems) >= totalitemcount) {
                            Log.i(TAG, "Reach the end.");

                            ReadyToLoad = false;
                            Offset += 20;
                            GetSearchData(Offset);
                        }
                    }

                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReadyToLoad = true;
        Offset = 0;

        GetSearchData(Offset);


    }

    private void GetSearchData(int Offset) {

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonResponse> PokemonResponseCall = service.GetPokemonList(20, Offset);
        PokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                ReadyToLoad = true;
                if (response.isSuccessful()) {
                    PokemonResponse pokemonResponse = response.body();
                    ArrayList<Pokemon> pokemonList = pokemonResponse.getResults();

                    pokemonListAdapter.addPokemonList(pokemonList);
                } else {

                    Log.e(TAG, "onResponse: " + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                ReadyToLoad = true;
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }
}
