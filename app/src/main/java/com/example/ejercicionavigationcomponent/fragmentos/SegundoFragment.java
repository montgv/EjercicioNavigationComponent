package com.example.ejercicionavigationcomponent.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicionavigationcomponent.R;

public class SegundoFragment extends Fragment {

    public SegundoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        final TextView txt1 = view.findViewById(R.id.txtTexto);
        final TextView txt2 = view.findViewById(R.id.txtNumero);
        final Button boton = view.findViewById(R.id.btPantallaFinal);

        txt1.setText(getArguments().getString("texto"));
        txt2.setText(String.valueOf(getArguments().getInt("numero")));

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_segundoFragment_to_finalFragment);
            }
        });
    }
}