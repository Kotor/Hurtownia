package com.example.hurtownia;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ListAdapter extends ArrayAdapter<String> {

	public static ArrayList<ModelZamowienie> listaZamowien;
    private final Context context;
    private final int rowResourceId;
    private ArrayList<String> zamowienia = new ArrayList<String>();

    public int getCount () {
    	return zamowienia.size();
    }
    
    public String getItem(int position) {
    	return zamowienia.get(position);
    }
    
    public void refreshData() {
    	new RequestTask().execute("http://www.ap.mtnorton.nazwa.pl/apps/get.php?api_klucz=9e2cd46cce7937a488647744ef5afb");
    }
    
    public ListAdapter(Context context, int textViewResourceId, String[] objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.rowResourceId = textViewResourceId;
        refreshData();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(rowResourceId, parent, false);
        return rowView;
    }  
    
    class RequestTask extends AsyncTask<String, String, String>{
    	@Override
        protected String doInBackground(String... uri) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            String responseString = null;
            try {
                response = httpclient.execute(new HttpGet(uri[0]));
                StatusLine statusLine = response.getStatusLine();
                if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    out.close();
                    responseString = out.toString();
                } else{
                    //Closes the connection.
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (ClientProtocolException e) {
                //TODO Handle problems..
            } catch (IOException e) {
                //TODO Handle problems..
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            zamowienia.add(result);
            notifyDataSetChanged();            
        }
    }

    public static ModelZamowienie getZamowienie(String result) throws JSONException  {
    	ModelZamowienie zamowienie = new ModelZamowienie();
		JSONObject jObj = new JSONObject(result);
		
		zamowienie.id = jObj.getInt("id");
		zamowienie.numer = jObj.getInt("numer");
		zamowienie.zamawiajacy = jObj.getInt("zamawiajacy");
		zamowienie.klient = jObj.getString("klient");

		JSONObject jArr = jObj.getJSONObject("towar");
		ModelTowar towar = new ModelTowar();
		towar.id = jArr.getInt("id");
		towar.idTowar = jArr.getInt("idTowar");
		towar.ilosc = jArr.getInt("ilosc");
		towar.palety = jArr.getInt("palety");
		towar.nazwaTowar = jArr.getString("nazwaTowar");
		zamowienie.listaTowarow.add(towar);
		listaZamowien.add(zamowienie);
		return zamowienie;
	}    
}