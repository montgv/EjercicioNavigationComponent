package com.example.ejercicionavigationcomponent.fragmentos;

import android.annotation.SuppressLint;
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

//Creamos la clase SegundoFragmento que extiende de Fragment que representa una interfaz particular
// que se ejecuta dentro de un Activity
public class SegundoFragment extends Fragment {

    public SegundoFragment() {
        // Required empty public constructor
    }

    //Método llamado para que el fragmento cree una instancia de su vista de interfaz de usuario
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false);
    }

    //Indica que se debe ignorar las advertencias específicas
    @SuppressLint("SetTextI18n")
    //Método que se llama justo después que el anterior, haya regresado, pero antes de que se haya
    //restaurado cualquier estado guardado en la vista
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Declaramos las siguientes variables de cada componente para que encuentre ese componente
        //en la vista
        final NavController navController = Navigation.findNavController(view);
        final TextView txt1 = view.findViewById(R.id.txtTexto);
        final TextView txt2 = view.findViewById(R.id.txtNumero);
        final Button boton = view.findViewById(R.id.btPantallaFinal);

        //Asignamos a las variables TextView que muestren los datos que hemos mandado con bundle de
        //la otra activity
        txt1.setText("El texto es: " + getArguments().getString("texto"));
        txt2.setText("El número es: " + String.valueOf(getArguments().getInt("numero")));

        //Definimos un escuchador mediante el método setOnClickListener que esta asociado al boton
        //con su vista, cuando se pulsa el botón, navegamos a un destino desde el gráfico de
        //navegación actual
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_segundoFragment_to_finalFragment);
            }
        });
    }
}