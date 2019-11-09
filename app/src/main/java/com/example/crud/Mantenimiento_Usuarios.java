package com.example.crud;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class Mantenimiento_Usuarios {

    private ProgressDialog pd;

    //Función de Log-In
    public void verificarSesion(final Context context, final String email, final String password){
    pd = new ProgressDialog(context);
    pd.setMessage("Verificando los datos en el servidor. \nEspere un momento...");
    pd.show();

    String url = Config.urlLogin;
    StringRequest stringRequest = new StringRequest(Request.Method.POST,
            url,
            new Response.Listener<String>() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @SuppressLint("ResourceType")
                @Override
                public void onResponse(String response) {

                    if(response.equals("0")) {
                        pd.show();
                        Toast.makeText(context, "Usuario no encontrado. Verifique su datos.", Toast.LENGTH_SHORT).show();

                    }else{

                        try {

                            JSONArray jsonArray = new JSONArray(response);
                            String id = jsonArray.getJSONObject(0).getString("id");
                            String nombres = jsonArray.getJSONObject(0).getString("nombres");
                            String apellidos = jsonArray.getJSONObject(0).getString("apellidos");
                            String email = jsonArray.getJSONObject(0).getString("email");
                            String password = jsonArray.getJSONObject(0).getString("password");
                            String tipo = jsonArray.getJSONObject(0).getString("tipo");
                            String pregunta = jsonArray.getJSONObject(0).getString("pregunta");
                            String respuesta = jsonArray.getJSONObject(0).getString("respuesta");

                            Toast.makeText(context, "Usuario Encontrado: \n"+
                                    nombres + " " + apellidos, Toast.LENGTH_SHORT).show();

                            if(tipo.equals("1")){

                                Intent intent = new Intent(context, MainActivity.class);
                                intent.putExtra("senal", "5");
                                intent.putExtra("id", id);
                                intent.putExtra("nombres", nombres);
                                intent.putExtra("apellidos", apellidos);
                                intent.putExtra("email", email);
                                intent.putExtra("password", password);
                                intent.putExtra("tipo", tipo);
                                intent.putExtra("pregunta", pregunta);
                                intent.putExtra("respuesta", respuesta);
                                context.startActivity(intent);

                            }else if(tipo.equals("0")){

                            }else if(tipo.equals("2")){

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    pd.hide();

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(error != null){
                        Toast.makeText(context, "Algo salió mal. Revise su acceso a Internet y sus conexiones.", Toast.LENGTH_LONG).show();
                        pd.hide();
                    }
                }
            }) {

        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> map = new HashMap<String, String>();
            map.put("email", email);
            map.put("clave", password);
            return map;
        }

    };

    MySingleton.getInstance(context).addToRequestQueue(stringRequest);

 }


 //by Prof. Gámez López.
 //Fecha: 05/11/2019.

}
