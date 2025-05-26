package com.aluracursos.screenmatch.service;
import okhttp3.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;

public class ConsultaHuggingFaceHelsinki {
    private static final Dotenv dotenv = Dotenv.load();

    public static String obtenerTraduccion(String texto){
        OkHttpClient client = new OkHttpClient();

        String API_KEY = dotenv.get("HUGGINGFACE_API_KEY");
        String model = "Helsinki-NLP/opus-mt-en-es";
        String inputText = texto;

        String json = "{\"inputs\": \"" + inputText + "\"}";

        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url("https://api-inference.huggingface.co/models/" + model)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String responseBody = response.body().string();

            // Elimina el translation_text que aparece al inicio del resultado de la traduccion
            int start = responseBody.indexOf("\"translation_text\":\"") + "\"translation_text\":\"".length();
            int end = responseBody.indexOf("\"", start);
            String traduccion = responseBody.substring(start, end);

            return traduccion;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
