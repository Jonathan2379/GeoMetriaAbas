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

public class Fragmento_trapezio extends Fragment {
    private EditText edt_baseMenor, edt_baseMaior, edt_altura;
    private Button calcular;

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link Fragmento_trapezio#newInstance} factory method to
     * create an instance of this fragment.
     */

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public Fragmento_trapezio() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragmento_trapezio.
         */
        // TODO: Rename and change types and number of parameters
        public static Fragmento_trapezio newInstance(String param1, String param2) {
            Fragmento_trapezio fragment = new Fragmento_trapezio();
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
            View view =inflater.inflate(R.layout.fragmento_tres, container, false);

            edt_altura = view.findViewById(R.id.alturaTrapezio);
            edt_baseMaior = view.findViewById(R.id.baseMaior);
            edt_baseMenor = view.findViewById(R.id.baseMenor);
            calcular = view.findViewById(R.id.calcular);

            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(edt_altura.getText().toString().isEmpty() || edt_baseMaior.getText().toString().isEmpty() || edt_baseMenor.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    }else{
                        try{
                            double baseMenor, baseMaior, altura;

                            altura = Double.parseDouble(edt_altura.getText().toString());
                            baseMaior = Double.parseDouble(edt_baseMaior.getText().toString());
                            baseMenor = Double.parseDouble(edt_baseMenor.getText().toString());

                            double resultado = calculaArea(baseMaior,baseMenor,altura);

                            edt_altura.setText("");
                            edt_baseMaior.setText("");
                            edt_baseMenor.setText("");

                            AlertDialog.Builder janela = new AlertDialog.Builder(getContext(),R.style.dialog3);
                            janela.setTitle("Área do trapezio");
                            janela.setIcon(R.drawable.trapezio_preto_branco);

                            janela.setMessage("A área do trapezio é: " + String.valueOf(resultado));
                            janela.setNeutralButton("ok", null);
                            janela.show();
                        }catch (NumberFormatException e){
                            Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            return view;
        }

    private double calculaArea(double baseMaior, double baseMenor, double altura) {
        double area=((baseMaior + baseMenor) * altura) / 2;
        return area;
    }
}
