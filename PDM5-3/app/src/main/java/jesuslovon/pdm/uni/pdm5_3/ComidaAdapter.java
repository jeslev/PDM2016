package jesuslovon.pdm.uni.pdm5_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by jeslev on 30/01/16.
 */
public class ComidaAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    private String[] ingredientes= { "arroz, pollo, culantro, papa","pan, gallina, aceite, arroz","lomo, papas, arroz, cebolla, tomate",
            "frijo, arroz, carne", "pescado, limon, aji, cebolla", ""};

    private String[] tiempos={"13","42","65","23","45","" };

    public ComidaAdapter(Context c, String[] val){
        super(c, R.layout.lista_item, val);
        context = c;
        values = val;
    }

    @Override
    public View getView(int pos, View conv, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );

        View v = inflater.inflate(R.layout.lista_item,parent,false);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView ingr = (TextView) v.findViewById(R.id.ingredientes);
        TextView tiempo = (TextView) v.findViewById(R.id.tiempo);

        name.setText(values[pos]);
        ingr.setText(ingredientes[pos]);
        tiempo.setText(tiempos[pos]);

        return v;
    }
}
