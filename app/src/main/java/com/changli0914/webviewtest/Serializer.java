package com.changli0914.webviewtest;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;

/**
 * Created by jtrang on 16/02/16.
 */
public class Serializer {

    public static byte[] serialize(Object obj) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            ObjectOutput store = new ObjectOutputStream(output);
            store.writeObject(obj);
            store.close();

            // Get the bytes of the serialized object
            byte[] ret = output.toByteArray();
            Log.d("ret", ret.toString());
            return (ret);
        } catch(IOException ioe) {
            Log.e("Error : ", " In serialize(Object); (Serializer.java) ", ioe);

            return (null);
        }
    }

    public static Object deserialize(byte[] str) {
        try {
            ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(str));
            Object object = input.readObject();
            input.close();
            Log.d("Obj is : ", object.toString());
            return object;
        } catch(ClassNotFoundException except) {
            Log.e("Error : ", "In Deserialize(String); (Serializer.java) -- Class not found error", except);

            return null;
        } catch(IOException ioe) {
            Log.e("Error", "In Deserialize(String); (Serializer.java) -- IO error", ioe);

            return null;
        }
    }

}
