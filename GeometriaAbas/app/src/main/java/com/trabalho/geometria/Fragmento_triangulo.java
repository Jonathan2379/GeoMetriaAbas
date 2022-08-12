package com.trabalho.geometria;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmento_triangulo extends Fragment {
    private EditText edt_base, edt_altura;
    private Button calcular;

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link Fragmento_triangulo#newInstance} factory method to
     * create an instance of this fragment.
     */

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public Fragmento_triangulo() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragmento_triangulo.
         */
        // TODO: Rename and change types and number of parameters
        public static Fragmento_triangulo newInstance(String param1, String param2) {
            Fragmento_triangulo fragment = new Fragmento_triangulo();
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
            View view =inflater.inflate(R.layout.fragmento_dois, container, false);

            edt_altura = view.findViewById(R.id.altura);
            edt_base = view.findViewById(R.id.base);
            calcular = view.findViewById(R.id.calcular);

            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(edt_altura.getText().toString().isEmpty() || edt_base.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    }else{

                        double altura, base;

                        altura = Double.parseDouble(edt_altura.getText().toString());
                        base = Double.parseDouble(edt_base.getText().toString());

                        double resultado =calculaArea(base,altura);

                        edt_altura.setText("");
                        edt_base.setText("");

                        AlertDialog.Builder janela = new AlertDialog.Builder(getContext(),R.style.dialog2);
                        janela.setTitle("Área do triângulo");
                        janela.setIcon(R.drawable.triangulo_preto_branco);

                        janela.setMessage("A área do triangulo é: " + String.valueOf(resultado));
                        janela.setNeutralButton("ok", null);
                        janela.show();
                    }

                }
            });

            return view;
        }

    private double calculaArea(double b, double a) {
        double area=(b * a) / 2;
        return area;
    }
}