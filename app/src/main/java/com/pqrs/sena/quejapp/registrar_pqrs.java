package com.pqrs.sena.quejapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class registrar_pqrs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_pqrs);
        WebServiceManager WebService = new WebServiceManager();
        HashMap miHashRegional = new HashMap<String,String>();
        miHashRegional.put("tabla", "regional");
        miHashRegional.put("campos", "*");
        JSONObject miJsonRegional=WebService.ConsultarDatos(miHashRegional);
        try {
            Toast.makeText(getApplicationContext(),miJsonRegional.get("mensaje").toString(),Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.mi_menu_registrar, m);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mItem){
        switch(mItem.getItemId()){
            case R.id.mi_item_menu_login:
                enviarMensajeToast("uno",Toast.LENGTH_SHORT);
                cambiarActividad(MainActivity.class);
                break;
            case R.id.mi_item_menu_registrar:
                enviarMensajeToast("Ya estas aqui", Toast.LENGTH_SHORT);

                break;
            case R.id.mi_item_menu_buscar:
                enviarMensajeToast("tres",Toast.LENGTH_SHORT);
                cambiarActividad(activity_buscar_pqrs.class);
                break;
            case R.id.mi_item_menu_registro:
                enviarMensajeToast("tres",Toast.LENGTH_SHORT);
                cambiarActividad(registro_usuario.class);
                break;
            default:
                enviarMensajeToast("No es un item valido ",Toast.LENGTH_SHORT);
                break;
        }
        return true;
    }
    /*Funcion para enviar mensajes de tipoToast*/
    public void enviarMensajeToast(String msn,int tiempoDuracion){
        Toast.makeText(getApplicationContext(),msn,tiempoDuracion).show();
    }
    /*Funcion para enviar a otra actividad*/
    public void cambiarActividad(Class<?> clDestino){
        startActivity(new Intent(getApplicationContext(),clDestino));
    }


}

