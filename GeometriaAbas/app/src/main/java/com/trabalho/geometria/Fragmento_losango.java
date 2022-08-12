package com.trabalho.geometria;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Fragmento_losango extends Fragment {
    public EditText edt_diagonalMaior, edt_diaginalMenor;
    public Button calcular;

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link Fragmento_losango#newInstance} factory method to
     * create an instance of this fragment.
     */

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragmento_losango() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento_losango.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento_losango newInstance(String param1, String param2) {
        Fragmento_losango fragment = new Fragmento_losango();
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

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_um, container, false);

        edt_diagonalMaior = view.findViewById(R.id.diagonalMaior);
        edt_diaginalMenor = view.findViewById(R.id.diagonalMenor);
        calcular = view.findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edt_diagonalMaior.getText().toString().isEmpty() || edt_diaginalMenor.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    double diagonalMenor, diagonalMaior;

                    diagonalMaior = Double.parseDouble(edt_diagonalMaior.getText().toString());
                    diagonalMenor = Double.parseDouble(edt_diaginalMenor.getText().toString());

                    double resultado = calculaArea(diagonalMaior,diagonalMenor);

                    edt_diagonalMaior.setText("");
                    edt_diaginalMenor.setText("");

                    AlertDialog.Builder janela = new AlertDialog.Builder(getContext(), R.style.dialog1);
                    janela.setTitle("Área do losango");
                    janela.setIcon(R.drawable.losango_preto_branco);

                    janela.setMessage("A área do losango é: " + String.valueOf(resultado));
                    janela.setNeutralButton("ok", null);
                    janela.show();
                }
            }
        });
        return view;
    }

    private double calculaArea(double diagonalMaior, double diagonalMenor) {
        double area= (diagonalMaior * diagonalMenor) / 2;
        return area;
    }
}