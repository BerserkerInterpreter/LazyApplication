package com.lazyloading.json.adaptador;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class AdaptadorJSON<T> extends TypeAdapter<T>{

	@Override
	public T read(JsonReader jsonReader) throws IOException {
		return null;
	}

	@Override	
	public void write(JsonWriter jsonWriter, T elemento) throws IOException {
		if(elemento == null) {
			jsonWriter.nullValue();
			return;
		}
		jsonWriter.value(elemento.toString());
	}
}
