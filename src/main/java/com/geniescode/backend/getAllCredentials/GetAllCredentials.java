package com.geniescode.backend.getAllCredentials;

import com.geniescode.backend.logIn.LogIn;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GetAllCredentials implements Supplier<List<LogIn>> {
    public List<LogIn> get() {
        String json = null;
        try {
            InputStream inputStream = Resources.getResource("credentials.json").openStream();
            json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return new Gson().fromJson(json, new TypeToken<ArrayList<LogIn>>() {
        }.getType());
    }
}
