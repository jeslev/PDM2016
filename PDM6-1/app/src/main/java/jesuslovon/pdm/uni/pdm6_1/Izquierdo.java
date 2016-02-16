package jesuslovon.pdm.uni.pdm6_1;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Izquierdo extends Fragment {

    View rootView;
    Button boton;
    EditText campo;

    enviarMensaje EM;

    public Izquierdo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_izquierdo,container,false);
        campo = (EditText) rootView.findViewById(R.id.editText);
        boton = (Button) rootView.findViewById(R.id.boton1);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje;
                mensaje = campo.getText().toString();
                Log.d("Bug","mensaje: "+mensaje);
                EM.enviarDatos(mensaje);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public void onAttach(Context context){
        super.onAttach(getActivity());
        try{
            EM = (enviarMensaje) getActivity();
        }catch (ClassCastException ex){
            throw new ClassCastException ("Necesitas implementar mensaje");
        }

    }

}
