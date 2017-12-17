package com.example.andres.pokedexAPP;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import  android.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.andres.pokedexAPP.Models.Pokemon;
import com.example.andres.pokedexAPP.Models.PokemonSort;
import com.example.andres.pokedexAPP.Models.PokemonResponse;
import com.example.andres.pokedexAPP.Models.PokemonTypeList;
import com.example.andres.pokedexAPP.Models.PokemonTypeListResponse;
import com.example.andres.pokedexAPP.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmptyACtivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";
    public static String urltopass;
    private Retrofit retrofit;
    private int Offset;
    private boolean ReadyToLoad, sort;
    private Button button;
    private String id;
    String[] PokemonTypes = {"All Types","Normal", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", "Steel", "Fire", "Water",
    "Grass", "Electric", "Psychic", "Ice", "Dragon", "Dark", "Fairy"};
    private Spinner spinner;
    ConstraintLayout view;
    public static String PokemonTypeId = "200";
    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_activity);
/*        int colors[] = { 0xff255779, 0xffa6c0cd };

        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors);
        view = (ConstraintLayout) findViewById(R.id.ListConstraintLayout);

        view.setBackgroundDrawable(gradientDrawable);*/
        sort = true;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        pokemonListAdapter = new PokemonListAdapter(this);

        button = (Button) findViewById(R.id.BUTTON);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sort) {
                    //GetSearchData(0);
                    sort = false;
                }
                else {
                    GetData(802);
                    pokemonListAdapter.Clear();
                    sort = true;
                }
            }
        });
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setEnabled(true);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, PokemonTypes);
        spinner.setAdapter(adapter);

        recyclerView.setAdapter(pokemonListAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0)
                {

                    int visibleitemcount = layoutManager.getChildCount();
                    int totalitemcount = layoutManager.getItemCount();
                    int pastvisibleitems = layoutManager.findFirstVisibleItemPosition();

                    if(ReadyToLoad)
                    {
                        if ((visibleitemcount + pastvisibleitems) >= totalitemcount){
                            Log.i(TAG, "Reach the end.");

                            ReadyToLoad = false;
                            Offset +=20;
                            GetData(Offset);
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
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0: GetData(802);
                        break;
                    case 1:
                        pokemonListAdapter.Clear();
                        GetPokemonTypeData("1");
                        break;
                    case 2: pokemonListAdapter.Clear();
                        GetPokemonTypeData("2");
                        break;
                    case 3: pokemonListAdapter.Clear();
                        GetPokemonTypeData("3");
                        break;
                    case 4: pokemonListAdapter.Clear();
                        GetPokemonTypeData("4");
                        break;
                    case 5: pokemonListAdapter.Clear();
                        GetPokemonTypeData("5");
                        break;
                    case 6: pokemonListAdapter.Clear();
                        GetPokemonTypeData("6");
                        break;
                    case 7: pokemonListAdapter.Clear();
                        GetPokemonTypeData("7");
                        break;
                    case 8: pokemonListAdapter.Clear();
                        GetPokemonTypeData("8");
                        break;
                    case 9: pokemonListAdapter.Clear();
                        GetPokemonTypeData("9");
                        break;
                    case 10: pokemonListAdapter.Clear();
                        GetPokemonTypeData("10");
                        break;
                    case 11: pokemonListAdapter.Clear();
                        GetPokemonTypeData("11");
                        break;
                    case 12: pokemonListAdapter.Clear();
                        GetPokemonTypeData("12");
                        break;
                    case 13: pokemonListAdapter.Clear();
                        GetPokemonTypeData("13");
                        break;
                    case 14: pokemonListAdapter.Clear();
                        GetPokemonTypeData("14");
                        break;
                    case 15: pokemonListAdapter.Clear();
                        GetPokemonTypeData("15");
                        break;
                    case 16: pokemonListAdapter.Clear();
                        GetPokemonTypeData("16");
                        break;
                    case 17: pokemonListAdapter.Clear();
                        GetPokemonTypeData("17");
                        break;
                    case 18: pokemonListAdapter.Clear();
                        GetPokemonTypeData("18");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void GetPokemonTypeData(String id) {

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonTypeListResponse> PokemonResponseCall = service.GetPokemonSearchList(id);
        PokemonResponseCall.enqueue(new Callback<PokemonTypeListResponse>() {
            @Override
            public void onResponse(Call<PokemonTypeListResponse> call, Response<PokemonTypeListResponse> response) {
                if (response.isSuccessful()) {
                    PokemonTypeListResponse pokemonResponse = response.body();
                    ArrayList<PokemonTypeList> pokemonList = pokemonResponse.getPokemon();
                    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
                    for (int i = 0; i < pokemonList.size(); i++) {

                        pokemons.add(pokemonList.get(i).getPokemon());
                    }

                    pokemonListAdapter.Clear();
                    pokemonListAdapter.addPokemonList(pokemons);
                }
                else {

                    Log.e(TAG, "onResponse: " + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokemonTypeListResponse> call, Throwable t) {

                int i;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                pokemonListAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pokemonListAdapter.filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void GetData(int Offset) {

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonResponse> PokemonResponseCall = service.GetPokemonList(802/*, Offset*/);
        PokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                ReadyToLoad = true;
                if(response.isSuccessful())
                {
                    PokemonResponse pokemonResponse = response.body();
                    ArrayList<Pokemon> pokemonList = pokemonResponse.getResults();


                    pokemonListAdapter.addPokemonList(pokemonList);
                }
                else
                {

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
   /* private void GetSearchData(int Offset) {

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonSort> PokemonResponseCall = service.GetPokemonSearchList(802/*, Offset);
        PokemonResponseCall.enqueue(new Callback<PokemonSort>() {
            @Override
            public void onResponse(Call<PokemonSort> call, Response<PokemonSort> response) {
                ReadyToLoad = true;
                if(response.isSuccessful())
                {
                    PokemonSort pokemonResponse = response.body();
                    ArrayList<Pokemon> pokemonList = pokemonResponse.getPokemon_species();

                    pokemonListAdapter.Clear();

                    pokemonListAdapter.addPokemonList(pokemonList);
                }
                else
                {

                    Log.e(TAG, "onResponse: " + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokemonSort> call, Throwable t) {
                ReadyToLoad = true;
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });

    }*/
}
