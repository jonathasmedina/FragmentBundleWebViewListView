package com.example.fragmentwebviewlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    FragmentManager fragmentManager;
    ListView listView;
    String[] SITES = new String[] {"Site: Ead IFMS.com", "Site: GitHub.com", "Site: StackOverflow.com"};
    ArrayAdapter<String> meuArrayAdapter;

    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView1);

        meuArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, SITES);

        listView.setAdapter(meuArrayAdapter);

        fragmentManager = getSupportFragmentManager();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Solução 1: criar diferentes fragments
//                switch (i){
//                    case 0:
//                        fragmentManager.beginTransaction().add(R.id.frameLayout1,
//                                new BlankFragment()).commit();
//                        break;
//                    case 1:
//                        fragmentManager.beginTransaction().add(R.id.frameLayout1,
//                                new BlankFragment2()).commit();
//                        break;
//                    case 2:
//                        fragmentManager.beginTransaction().add(R.id.frameLayout1,
//                                new BlankFragment3()).commit();
//                        break;
//                }

                //Solução 2: Um único fragment, utilizando Bundle
                BlankFragmentBundle blankFragmentBundle = new BlankFragmentBundle();

                switch (i) {
                    case 0:
                        url = "https://ead.ifms.edu.br/";
                        break;
                    case 1:
                        url = "https://github.com/";
                        break;
                    case 2:
                        url = "https://pt.stackoverflow.com/";
                        break;
                }

                Bundle bundle = new Bundle();
                bundle.putString("url", url); //key e value (apelido e valor ou variável)
                blankFragmentBundle.setArguments(bundle);

                fragmentManager.beginTransaction().add(R.id.frameLayout1,blankFragmentBundle).commit();
            }
        });
    }
}