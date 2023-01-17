package hololivemodplus.util;

import com.badlogic.gdx.graphics.Color;

public class GeneralUtils {
    public static String arrToString(Object[] arr) {
        if (arr == null)
            return null;
        if (arr.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; ++i) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }

    public static Color rgbToColor(float r, float g, float b) {
        return new Color(r / 255.0F, g / 255.0F, b / 255.0F, 1.0F);
    }
}
