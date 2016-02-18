package com.sandbox.runtime.js.serializers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sandbox.runtime.js.converters.NashornConverter;
import jdk.nashorn.internal.runtime.ScriptObject;

import java.io.IOException;

public class ScriptObjectSerializer extends StdSerializer<ScriptObject> {

    public ScriptObjectSerializer() {
        super(ScriptObject.class);
    }

    @Override
    public void serialize(ScriptObject value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonGenerationException {
        try {
            jgen.writeRaw(NashornConverter.instance().stringify(value));
        } catch (Exception e) {
            throw new JsonGenerationException(e);
        }
    }

}
