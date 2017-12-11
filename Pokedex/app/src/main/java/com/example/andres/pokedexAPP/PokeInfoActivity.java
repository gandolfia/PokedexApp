package com.example.andres.pokedexAPP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.andres.pokedexAPP.Models.EvolutionChain;
import com.example.andres.pokedexAPP.Models.EvolutionChainResponse;
import com.example.andres.pokedexAPP.Models.EvolutionDetails;
import com.example.andres.pokedexAPP.Models.PokedexEntry;
import com.example.andres.pokedexAPP.Models.PokedexEntryResponse;
import com.example.andres.pokedexAPP.Models.Pokemon;
import com.example.andres.pokedexAPP.Models.PokemonCompleteInfo;
import com.example.andres.pokedexAPP.Models.PokemonStatsResponse;
import com.example.andres.pokedexAPP.Models.PokemonTypes;
import com.example.andres.pokedexAPP.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeInfoActivity extends AppCompatActivity {
    private String UrlToGetInfo, PokemonEvolutionId;
    private String TAG = "PokeInfoActivity";
    private Retrofit retrofit;
    private TextView pokemonName, hp, attack, defence, spAttack, spDef, speed,
            height, weight, PokedexEntryTView;
    private ImageView pokemonphoto, pokemonshiny, pokemontype1, pokemontype2, evolution1, evolution2, evolution3;
    private ProgressBar speedBar, spDefBar, spAttBar, defenceBar, attackBar, HPBar;
    int Speed, SPD, SPA, DEF, ATT, HP;
    String POKEMON_NAME;
    ProgressBar pbarspinne1, pbarspinne2, pbarspinne3, pbarspinne4;
    int Type1 ;
    int Type2;
    int size, PokemonColor ;
    float Height ;
    float Weight ;
    int EvolutionId;
    int HighestValue = 0;
    String pokeid, pokeid1, pokeid2;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_info);
        PokemonEvolutionId = "1";
        /*ProgressDialog dialog = new ProgressDialog(this); // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Loading. Please wait...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();*/
        pbarspinne1 = (ProgressBar) findViewById(R.id.progressBar2);
        pbarspinne2 = (ProgressBar) findViewById(R.id.progressBar3);
        pbarspinne3 = (ProgressBar) findViewById(R.id.progressBar4);
        pbarspinne4 = (ProgressBar) findViewById(R.id.progressBar5);


        UrlToGetInfo = getIntent().getStringExtra("com.example.andres.pokedex.EXTRA_URL");
        pokemonName = (TextView) findViewById(R.id.PNametextView);
        pokemonName.setText(getIntent().getStringExtra("POKEMON_NAME").toUpperCase());
        hp = (TextView) findViewById(R.id.HPtextView);
        attack = (TextView) findViewById(R.id.AttacktextView);
        defence = (TextView) findViewById(R.id.DefencetextView);
        spAttack = (TextView) findViewById(R.id.SpAtextView);
        spDef = (TextView) findViewById(R.id.SpDtextView);
        speed = (TextView) findViewById(R.id.SpeedtextView);
        weight = (TextView) findViewById(R.id.WeighttextView);
        height = (TextView) findViewById(R.id.HeighttextView);
        PokedexEntryTView = (TextView) findViewById(R.id.PokedexEntrytextView);
        pokemonphoto = (ImageView) findViewById(R.id.InfoPokeimageView);
        pokemonshiny = (ImageView) findViewById(R.id.InfoPokeShinyimageView);
        pokemontype1 = (ImageView) findViewById(R.id.PokemonType1);
        pokemontype2 = (ImageView) findViewById(R.id.PokemonType2);
        evolution1 = (ImageView) findViewById(R.id.Evolution1imageView);
        evolution2 = (ImageView) findViewById(R.id.Evolution2imageView);
        evolution3 = (ImageView) findViewById(R.id.Evolution3imageView);
        speedBar = (ProgressBar) findViewById(R.id.SpdBar);
        spDefBar = (ProgressBar) findViewById(R.id.SpdfBar);
        spAttBar = (ProgressBar) findViewById(R.id.SpAttBar);
        defenceBar = (ProgressBar) findViewById(R.id.DefBar);
        attackBar = (ProgressBar) findViewById(R.id.AttBar);
        HPBar = (ProgressBar) findViewById(R.id.HpBar);
        //pokemonName.setText(UrlToGetInfo);

        Glide.with(PokeInfoActivity.this)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ UrlToGetInfo + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokemonphoto);
        Glide.with(PokeInfoActivity.this)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+ UrlToGetInfo + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokemonshiny);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetData();

      //  GetEvolutionLine();
    }

    private void DisplayInfo() {
        switch (Type1)
        {
            case 1: pokemontype1.setImageResource(R.drawable.pokemontype_normal);
                break;
            case 2: pokemontype1.setImageResource(R.drawable.pokemontype_fighting);
                break;
            case 3: pokemontype1.setImageResource(R.drawable.pokemontype_flying);
                break;
            case 4: pokemontype1.setImageResource(R.drawable.pokemontype_poison);
                break;
            case 5: pokemontype1.setImageResource(R.drawable.pokemontype_ground);
                break;
            case 6: pokemontype1.setImageResource(R.drawable.pokemontype_rock);
                break;
            case 7: pokemontype1.setImageResource(R.drawable.pokemontype_bug);
                break;
            case 8: pokemontype1.setImageResource(R.drawable.pokemontype_ghost);
                break;
            case 9: pokemontype1.setImageResource(R.drawable.pokemontype_steel);
                break;
            case 10: pokemontype1.setImageResource(R.drawable.pokemontype_fire);
                break;
            case 11: pokemontype1.setImageResource(R.drawable.pokemontype_water);
                break;
            case 12: pokemontype1.setImageResource(R.drawable.pokemontype_grass);
                break;
            case 13: pokemontype1.setImageResource(R.drawable.pokemontype_electric);
                break;
            case 14: pokemontype1.setImageResource(R.drawable.pokemontype_psychic);
                break;
            case 15: pokemontype1.setImageResource(R.drawable.pokemontype_ice);
                break;
            case 16: pokemontype1.setImageResource(R.drawable.pokemontype_dragon);
                break;
            case 17: pokemontype1.setImageResource(R.drawable.pokemontype_dark);
                break;
            case 18: pokemontype1.setImageResource(R.drawable.pokemontype_fairy);
                break;
        }

        pbarspinne1.setVisibility(View.GONE);
        if(size > 1)
        {
            switch (Type1)
            {
                case 1: pokemontype2.setImageResource(R.drawable.pokemontype_normal);
                    break;
                case 2: pokemontype2.setImageResource(R.drawable.pokemontype_fighting);
                    break;
                case 3: pokemontype2.setImageResource(R.drawable.pokemontype_flying);
                    break;
                case 4: pokemontype2.setImageResource(R.drawable.pokemontype_poison);
                    break;
                case 5: pokemontype2.setImageResource(R.drawable.pokemontype_ground);
                    break;
                case 6: pokemontype2.setImageResource(R.drawable.pokemontype_rock);
                    break;
                case 7: pokemontype2.setImageResource(R.drawable.pokemontype_bug);
                    break;
                case 8: pokemontype2.setImageResource(R.drawable.pokemontype_ghost);
                    break;
                case 9: pokemontype2.setImageResource(R.drawable.pokemontype_steel);
                    break;
                case 10: pokemontype2.setImageResource(R.drawable.pokemontype_fire);
                    break;
                case 11: pokemontype2.setImageResource(R.drawable.pokemontype_water);
                    break;
                case 12: pokemontype2.setImageResource(R.drawable.pokemontype_grass);
                    break;
                case 13: pokemontype2.setImageResource(R.drawable.pokemontype_electric);
                    break;
                case 14: pokemontype2.setImageResource(R.drawable.pokemontype_psychic);
                    break;
                case 15: pokemontype2.setImageResource(R.drawable.pokemontype_ice);
                    break;
                case 16: pokemontype2.setImageResource(R.drawable.pokemontype_dragon);
                    break;
                case 17: pokemontype2.setImageResource(R.drawable.pokemontype_dark);
                    break;
                case 18: pokemontype2.setImageResource(R.drawable.pokemontype_fairy);
                    break;
            }
            switch (Type2)
            {
                case 1: pokemontype1.setImageResource(R.drawable.pokemontype_normal);
                    break;
                case 2: pokemontype1.setImageResource(R.drawable.pokemontype_fighting);
                    break;
                case 3: pokemontype1.setImageResource(R.drawable.pokemontype_flying);
                    break;
                case 4: pokemontype1.setImageResource(R.drawable.pokemontype_poison);
                    break;
                case 5: pokemontype1.setImageResource(R.drawable.pokemontype_ground);
                    break;
                case 6: pokemontype1.setImageResource(R.drawable.pokemontype_rock);
                    break;
                case 7: pokemontype1.setImageResource(R.drawable.pokemontype_bug);
                    break;
                case 8: pokemontype1.setImageResource(R.drawable.pokemontype_ghost);
                    break;
                case 9: pokemontype1.setImageResource(R.drawable.pokemontype_steel);
                    break;
                case 10: pokemontype1.setImageResource(R.drawable.pokemontype_fire);
                    break;
                case 11: pokemontype1.setImageResource(R.drawable.pokemontype_water);
                    break;
                case 12: pokemontype1.setImageResource(R.drawable.pokemontype_grass);
                    break;
                case 13: pokemontype1.setImageResource(R.drawable.pokemontype_electric);
                    break;
                case 14: pokemontype1.setImageResource(R.drawable.pokemontype_psychic);
                    break;
                case 15: pokemontype1.setImageResource(R.drawable.pokemontype_ice);
                    break;
                case 16: pokemontype1.setImageResource(R.drawable.pokemontype_dragon);
                    break;
                case 17: pokemontype1.setImageResource(R.drawable.pokemontype_dark);
                    break;
                case 18: pokemontype1.setImageResource(R.drawable.pokemontype_fairy);
                    break;
            }
        }


        String stupid = Float.toString(Height);
        speedBar.setMax(HighestValue);
        spDefBar.setMax(HighestValue);
        spAttBar.setMax(HighestValue);
        attackBar.setMax(HighestValue);
        defenceBar.setMax(HighestValue);

        HPBar.setMax(HighestValue);
        speedBar.setProgress(Speed);
        speedBar.setVisibility(View.VISIBLE);
        spDefBar.setProgress(SPD);
        spDefBar.setVisibility(View.VISIBLE);
        spAttBar.setProgress(SPA);
        spAttBar.setVisibility(View.VISIBLE);
        attackBar.setProgress(ATT);
        attackBar.setVisibility(View.VISIBLE);
        defenceBar.setProgress(DEF);
        defenceBar.setVisibility(View.VISIBLE);
        HPBar.setProgress(HP);
        HPBar.setVisibility(View.VISIBLE);
        weight.setText("Weight: " + Float.toString(Weight) + " kg");
        weight.setVisibility(View.VISIBLE);
        height.setText("Height: " + Float.toString(Height) + " m");
        height.setVisibility(View.VISIBLE);
        pbarspinne3.setVisibility(View.GONE);
        speed.setText("Speed: " + Speed);
        speed.setVisibility(View.VISIBLE);
        spDef.setText("SpDef: " + SPD);
        spDef.setVisibility(View.VISIBLE);
        spAttack.setText("SpAtt: " + SPA);
        spAttack.setVisibility(View.VISIBLE);
        defence.setText("Defence: " + DEF);
        defence.setVisibility(View.VISIBLE);
        attack.setText("Attack: " + ATT);
        attack.setVisibility(View.VISIBLE);
        hp.setText("HP: " + HP);
        hp.setVisibility(View.VISIBLE);
        pbarspinne4.setVisibility(View.GONE);


    }

    private void GetData() {
        PokeapiService service = retrofit.create(PokeapiService.class);
        //Call<PokemonInfo> PokemonInfoCall = service.GetPokemonInfo();
        Call<PokemonCompleteInfo> PokemonInfoResponseCall = service.GetPokemonInfo(UrlToGetInfo);
        PokemonInfoResponseCall.enqueue(new Callback<PokemonCompleteInfo>() {
            @Override
            public void onResponse(Call<PokemonCompleteInfo> call, Response<PokemonCompleteInfo> response) {
                if(response.isSuccessful())
                {
                    PokemonCompleteInfo pokemonResponse = response.body();


                    ArrayList<PokemonStatsResponse> pokemonstatsr = pokemonResponse.getStats();
                    ArrayList<PokemonTypes> pokemontype = pokemonResponse.getTypes();

                    for (int i = 0; i < pokemonstatsr.size(); i++)
                    {
                           if(HighestValue < pokemonstatsr.get(i).getBase_stat())
                        {
                            HighestValue = pokemonstatsr.get(i).getBase_stat();
                        }
                    }

                    Speed = (pokemonstatsr.get(0).getBase_stat());
                    SPD = (pokemonstatsr.get(1).getBase_stat());
                    SPA = (pokemonstatsr.get(2).getBase_stat());
                    DEF = (pokemonstatsr.get(3).getBase_stat());
                    ATT = (pokemonstatsr.get(4).getBase_stat());
                    HP =  (pokemonstatsr.get(5).getBase_stat());
                    Height = pokemonResponse.getHeight() * .1f;
                    Weight = pokemonResponse.getWeight() * .1f;
                    Type1 = pokemontype.get(0).getType().getNumber();
                    size = pokemontype.size();
                    if(pokemontype.size() > 1)
                        Type2 = pokemontype.get(1).getType().getNumber();

                    DisplayInfo();


                    //pokemonListAdapter.addPokemonList(pokemonList);

                }
                else
                {

                    Log.e(TAG, "onResponse: " + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokemonCompleteInfo> call, Throwable t) {

            }
        });
        Call<PokedexEntryResponse> PokemonEntryResponseCall = service.GetPokedexEntry(UrlToGetInfo);
        PokemonEntryResponseCall.enqueue(new Callback<PokedexEntryResponse>() {
            @Override
            public void onResponse(Call<PokedexEntryResponse> call, Response<PokedexEntryResponse> response) {
                PokedexEntryResponse pokedexEntryResponse = response.body();
                EvolutionDetails evolutionDetails = pokedexEntryResponse.getEvolution_chain();

                 EvolutionId = evolutionDetails.getNumber();
                ArrayList<PokedexEntry> pokedexentries = pokedexEntryResponse.getFlavor_text_entries();
                String PokedexEntryText = "PokedexEntry";
                for (int i = 0; i < pokedexentries.size(); i++)
                {
                    if(pokedexentries.get(i).getLanguague().getName().equals("en"))
                    {
                        PokedexEntryText = pokedexentries.get(i).getFlavor_text();
                        break;
                    }
                }
                PokemonColor = pokedexEntryResponse.getColor().getNumber();
                PokedexEntryTView.setText(PokedexEntryText);
                PokedexEntryTView.setVisibility(View.VISIBLE);
                pbarspinne2.setVisibility(View.GONE);
                PokemonEvolutionId = Integer.toString(EvolutionId);

                GetEvolutionLine();

            }

            @Override
            public void onFailure(Call<PokedexEntryResponse> call, Throwable t) {

            }
        });

    }

    public void GetEvolutionLine()
    {
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<EvolutionChainResponse> evolutionChainResponseCall = service.GetEvolutionChain(PokemonEvolutionId);
        evolutionChainResponseCall.enqueue(new Callback<EvolutionChainResponse>() {
            @Override
            public void onResponse(Call<EvolutionChainResponse> call, Response<EvolutionChainResponse> response) {
                EvolutionChainResponse evolutionChainResponse = response.body();
                EvolutionChain evolutionChain = evolutionChainResponse.getChain();
                ArrayList<EvolutionChain> ActualEvoChain = new ArrayList<EvolutionChain>();
                ArrayList<Integer> EvoId = new ArrayList<Integer>();
                Pokemon species = evolutionChain.getSpecies();
                count = 1;
                ArrayList<String> evolutionnames = new ArrayList<String>();
                evolutionnames.add(evolutionChain.getSpecies().getName());
                EvoId.add(evolutionChain.getSpecies().getNumber());
                ArrayList<ArrayList<EvolutionChain>> evolutions = new ArrayList<ArrayList<EvolutionChain>>();
                if(evolutionChain.getEvolves_to().size() > 0)
                {
                    evolutionnames.add(evolutionChain.getEvolves_to().get(0).getSpecies().getName());
                    EvoId.add(evolutionChain.getEvolves_to().get(0).getSpecies().getNumber());
                    count++;
                    if(evolutionChain.getEvolves_to().get(0).getEvolves_to().size() > 0)
                    {
                        evolutionnames.add(evolutionChain.getEvolves_to().get(0).getEvolves_to().get(0).getSpecies().getName());
                        EvoId.add(evolutionChain.getEvolves_to().get(0).getEvolves_to().get(0).getSpecies().getNumber());
                        count++;
                    }
                }
                evolution2.setVisibility(View.GONE);
                evolution3.setVisibility(View.GONE);
                pokeid = EvoId.get(0).toString();
                if(count > 1)
                {
                    pokeid1 = EvoId.get(1).toString();
                    evolution2.setVisibility(View.VISIBLE);
                    if(count == 3)
                    {
                        pokeid2 = EvoId.get(2).toString();
                        evolution3.setVisibility(View.VISIBLE);
                    }

                }
                DisplayInfo2();

            }

            @Override
            public void onFailure(Call<EvolutionChainResponse> call, Throwable t) {
                Log.e(TAG, "onResponse: failure");

            }
        });
    }

    private void DisplayInfo2() {
        Glide.with(PokeInfoActivity.this)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ pokeid + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(evolution1);
        if(count > 1) {
            Glide.with(PokeInfoActivity.this)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokeid1 + ".png")
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(evolution2);
            if (count > 2) {
                Glide.with(PokeInfoActivity.this)
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokeid2 + ".png")
                        .centerCrop()
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(evolution3);
            }
        }
    }


}
