package com.test.aula06;

import android.content.Context;
import android.content.SharedPreferences;

public class InfoUsuarioPreference {

    private static final String PREF_NAME = "InfoUsuario";

    final SharedPreferences pref;
    final SharedPreferences.Editor editor;

    private static InfoUsuarioPreference ourInstance = null;

    public static InfoUsuarioPreference getInstance(Context context) {
        if(ourInstance == null) {
            ourInstance = new InfoUsuarioPreference(context);
        }

        return ourInstance;
    }

    private InfoUsuarioPreference(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.apply();
    }

    public void setAceitou(boolean aceitou) {
        editor.putBoolean("aceitou", aceitou);
        editor.commit();
    }

    public boolean getAceitou() {
        return pref.getBoolean("aceitou", false);
    }

    public void setEmail(String email) {
        editor.putString("email", email);
        editor.commit();
    }

    public String getEmail() {
        return pref.getString("email", "Email nao cadastrado");
    }
}
