package Util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Model.Automovel;

public class JSonFacade {

	public static String listToJSon(ArrayList<Automovel> lista) {

		JSONArray vetor = new JSONArray();
		String vetorw = "";
		for (Automovel automovel: lista) {

			JSONObject object = new JSONObject();

			try {
				
				object.put("nome", automovel.getModelo());
				object.put("imgVeiculo", "1");
				String valor = "" + automovel.getValorKm();
				object.put("valor", valor);//valor);
				object.put("placa", automovel.getPlaca());
				object.put("cor", "Branco");
				//object.put("pais", automovel.getPais());
				vetor.put(object);
				vetorw += vetor.toString();
				
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
			System.out.println(vetor.toString());
			System.out.println(vetorw);
		return vetor.toString();

	}

}