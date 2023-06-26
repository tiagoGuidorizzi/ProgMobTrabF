package com.example.trab_final.adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trab_final.R;
import com.example.trab_final.database.AppDatabase;
import com.example.trab_final.entities.Candidatura;

import java.util.List;

public class MinhasCandidaturasAdapter extends ArrayAdapter<Candidatura> {
    private final Fragment fragment;
    private final AppDatabase db;

    public MinhasCandidaturasAdapter(Fragment fragment, List<Candidatura> candidaturas) {
        super(fragment.getContext(), 0, candidaturas);
        this.fragment = fragment;
        this.db = AppDatabase.getDatabase(fragment.getContext().getApplicationContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(fragment.getContext()).inflate(R.layout.list_item_minhas_candidaturas, parent, false);
        }

        Candidatura candidatura = getItem(position);

        ImageView imageViewFoto = listItemView.findViewById(R.id.imageViewFoto);
        TextView textViewNome = listItemView.findViewById(R.id.textViewNome);
        TextView textViewDescricao = listItemView.findViewById(R.id.textViewDescricao);
        TextView textViewSalario = listItemView.findViewById(R.id.textViewSalario);

        Button editar = listItemView.findViewById(R.id.buttonEditar);
        Button excluir = listItemView.findViewById(R.id.buttonExcluir);

        editar.setOnClickListener(view1 -> {
            final Bundle bundle = new Bundle();
            bundle.putString("id", String.valueOf(this.getItem(position).getId()));
            System.out.println(bundle);
            NavHostFragment.findNavController(this.fragment).navigate(R.id.action_minhasCandidaturasFragment_to_editarCandidaturaFragment, bundle);
        });

        excluir.setOnClickListener(view -> {
            new AlertDialog.Builder(this.fragment.getContext()).setTitle("Excluir").setMessage("Tem certeza que deseja excluir?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db.getCandidaturaDao().delete(getItem(position));
                            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                            parentFragmentManager.beginTransaction().detach(fragment).commit();
                            parentFragmentManager.beginTransaction().attach(fragment).commit();
                        }
                    }).setNegativeButton("Não", null).show();
        });


//        // Defina os valores nos elementos de layout com base no objeto Candidatura
//        Usuario usuario = AppDatabase.getDatabase(context).getUsuarioDao().getUserById(candidatura.getIdUsuario());
//        byte[] decodedString = Base64.decode(usuario.getFoto(), Base64.DEFAULT);
//        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//        imageViewFoto.setImageBitmap(decodedByte);
//        textViewNome.setText(candidatura.getNome());
//        textViewDescricao.setText(candidatura.getDescricao());
//        textViewSalario.setText("Pretensão salarial: R$ " + candidatura.getSalario());

        textViewNome.setText(candidatura.getNome());
        textViewDescricao.setText(candidatura.getDescricao());
        textViewSalario.setText("Pretensão salarial: R$ " + candidatura.getSalario());
        Log.d("a", "teste");
        return listItemView;
    }
}