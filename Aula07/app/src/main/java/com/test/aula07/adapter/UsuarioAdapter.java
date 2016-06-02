package com.test.aula07.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.aula07.R;
import com.test.aula07.model.Usuario;

import java.util.List;

public class UsuarioAdapter extends BaseAdapter {

    private List<Usuario> usuarios;
    private ViewHolder holder;
    private LayoutInflater mInflater;

    public UsuarioAdapter(Context context, List<Usuario> usuarios) {
        try {
            mInflater = LayoutInflater.from(context);
        } catch (Exception e) {}

        this.usuarios = usuarios;
    }

    static class ViewHolder{
        private TextView nomeUsuario;
        private TextView emailUsuario;
        private View corUsuario;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Usuario getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_list_usuario, parent, false);

            holder = new ViewHolder();
            holder.corUsuario = convertView.findViewById(R.id.list_view_cor);
            holder.nomeUsuario = (TextView) convertView.findViewById(R.id.list_text_nome);
            holder.emailUsuario = (TextView) convertView.findViewById(R.id.list_text_email);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Usuario usuario = usuarios.get(position);
        holder.corUsuario.setBackgroundColor(Color.parseColor(usuario.getCor()));
        holder.nomeUsuario.setText(usuario.getNome());
        holder.emailUsuario.setText(usuario.getEmail());

        return convertView;
    }
}
