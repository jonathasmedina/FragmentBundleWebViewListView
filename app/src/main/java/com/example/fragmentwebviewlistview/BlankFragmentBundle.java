package com.example.fragmentwebviewlistview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentBundle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentBundle extends Fragment {

    WebView webView;
    String url_;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentBundle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentBundle.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentBundle newInstance(String param1, String param2) {
        BlankFragmentBundle fragment = new BlankFragmentBundle();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blank_bundle, container, false);

        //Recebendo conte??do do Bundle
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            url_ = bundle.getString("url"); //acesso pela key.
        }

        //Configurando o webView
        webView = view.findViewById(R.id.webViewBundle);

        //receber a entidade de configura????o
        WebSettings ws = webView.getSettings();

        //setar valores JavaScript e Zoom;
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        //acessar a URL
        webView.loadUrl(url_);

        webView.setWebViewClient(new WebViewClient());


        return view;
    }
}