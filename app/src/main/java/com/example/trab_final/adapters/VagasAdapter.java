package com.example.trab_final.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trab_final.R;
import com.example.trab_final.entities.Candidatura;

import java.util.List;

public class VagasAdapter extends ArrayAdapter<Candidatura> {
    private final Context context;

    public VagasAdapter(Context context, List<Candidatura> candidaturas) {
        super(context, 0, candidaturas);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_candidatura, parent, false);
        }

        Candidatura candidatura = getItem(position);

        ImageView imageViewFoto = listItemView.findViewById(R.id.imageViewFoto);
        TextView textViewNome = listItemView.findViewById(R.id.textViewNome);
        TextView textViewDescricao = listItemView.findViewById(R.id.textViewDescricao);
        TextView textViewSalario = listItemView.findViewById(R.id.textViewSalario);

        // Defina os valores nos elementos de layout com base no objeto Candidatura
//        Usuario usuario = AppDatabase.getDatabase(context).getUsuarioDao().getUserById(candidatura.getIdUsuario());
//        byte[] decodedString = Base64.decode(usuario.getFoto(), Base64.DEFAULT);
//        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//        imageViewFoto.setImageBitmap(decodedByte);
        textViewNome.setText(candidatura.getNome());
        textViewDescricao.setText(candidatura.getDescricao());
        textViewSalario.setText("Pretensão salarial: R$ " + candidatura.getSalario());


        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View popupView = LayoutInflater.from(context).inflate(R.layout.popup_candidatura, null);

                TextView popupTextViewNome = popupView.findViewById(R.id.popupTextViewNome);
                TextView popupTextViewDescricao = popupView.findViewById(R.id.popupTextViewDescricao);
                TextView popupTextViewSalario = popupView.findViewById(R.id.popupTextViewSalario);
                TextView popupTextViewEmail = popupView.findViewById(R.id.popupTextViewEmail);
                TextView popupTextViewTelefone = popupView.findViewById(R.id.popupTextViewTelefone);
                Button popupButtonFechar = popupView.findViewById(R.id.popupButtonFechar);

                popupTextViewNome.setText(candidatura.getNome());
                popupTextViewDescricao.setText("Descrição: " + candidatura.getDescricao());
                popupTextViewSalario.setText("Pretensão salarial: R$ " + candidatura.getSalario());
                popupTextViewEmail.setText("Email: " + candidatura.getEmail());
                popupTextViewTelefone.setText("Telefone: " + candidatura.getTelefone());
                builder.setView(popupView);

                final AlertDialog dialog = builder.create();
                dialog.show();

                popupButtonFechar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });


        return listItemView;
    }
}