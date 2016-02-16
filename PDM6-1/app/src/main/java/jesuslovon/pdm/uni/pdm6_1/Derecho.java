package jesuslovon.pdm.uni.pdm6_1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Derecho extends Fragment {


    View rootView;
    TextView txt;

    public Derecho() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_derecho, container,false);
        txt = (TextView) rootView.findViewById(R.id.text1);

        // Inflate the layout for this fragment
        return rootView;
    }

    public void obtenerMensaje(String mensaje){
        txt.setText(mensaje);

    }

}
