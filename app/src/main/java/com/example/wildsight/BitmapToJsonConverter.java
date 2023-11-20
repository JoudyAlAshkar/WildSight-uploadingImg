package com.example.wildsight;

import android.graphics.Bitmap;
import android.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

public class BitmapToJsonConverter {

    public String convertBitmapToJson(Bitmap bitmap) {
        // Convert Bitmap to Base64
        String encodedBitmap = convertBitmapToBase64(bitmap);

        // Create a JSON object and store the encoded string
        JSONObject json = new JSONObject();
        try {
            json.put("image", encodedBitmap);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Convert JSON object to string
        return json.toString();
    }

    private String convertBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArrayImage = baos.toByteArray();
        return Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
    }
}
