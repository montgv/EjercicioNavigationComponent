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
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicionavigationcomponent.R;

public class InicioFragment extends Fragment {

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);
        final EditText edit1 = view.findViewById(R.id.edTexto);
        final EditText edit2 = view.findViewById(R.id.edNumero);
        final Button boton = view.findViewById(R.id.btSegundaPantalla);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "";
                Integer numero = 0;

                if (edit1.getText().toString().isEmpty() || edit2.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Debes introducir todos los valores de los campos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    texto = edit1.getText().toString();
                    numero = Integer.parseInt(edit2.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putString("texto", texto);
                    bundle.putInt("numero", numero);

                    navController.navigate(R.id.action_inicioFragment_to_segundoFragment, bundle);
                }
            }
        });
    }
}