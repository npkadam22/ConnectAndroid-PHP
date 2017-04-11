package justnk.nk.ineocard.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Niraj on 7/26/2016.
 */
public class json {

    public static String[][] getdata(String strJson,String oname,String[] childs)
    {
        String[][] data = new String[5][50];
        JSONObject jsonResponse;

        try {

            /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
            jsonResponse = new JSONObject(strJson);

            /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
            /*******  Returns null otherwise.  *******/
            JSONArray jsonMainNode = jsonResponse.optJSONArray(oname);

            /*********** Process each JSON Node ************/

            int lengthJsonArr = jsonMainNode.length();

            for(int i=0; i < lengthJsonArr; i++)
            {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                /******* Fetch node values **********/
            for(int j=0;j<childs.length;j++)
            {
                data[i][j]       = jsonChildNode.optString(childs[j]).toString();

            }



                //Log.i("JSON parse", song_name);
            }

            /************ Show Output on screen/activity **********/


        } catch (JSONException e) {

            e.printStackTrace();

        }

        return data;
    }
}
