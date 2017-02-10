package crunchifytutorial;

import crunchifytutorial.CrunchifyGetPropertyValues;

import java.io.IOException;

/**
 * Created by alexanderboffin on 9/02/17.
 */
public class CrunchifyReadConfigMain {
    public static void main(String[] args) throws IOException {
        CrunchifyGetPropertyValues properties = new CrunchifyGetPropertyValues();
        properties.getPropValues();
    }
}
