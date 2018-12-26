package com.cgi.sdm_project.util;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

/**
 * Decora appCompat para que todas las activities compartan el contexto del singleton
 *
 * @author Samuel
 */
public class AppCompatActivityLocale extends AppCompatActivity {
    private Locale locale = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale();
    }

    private void setLocale() {
        Configuration config = getBaseContext().getResources().getConfiguration();

        Enumerates.Idioma idioma = Enumerates.Idioma.values()[Conf.getInstancia().getIdioma()];
        String lang = "es";
        switch (idioma) {
            case ENGLISH:
                lang = "en";
                break;
            case SPANISH:
                lang = "es";
                break;
        }
        if (!config.locale.getLanguage().equals(lang)) {

            locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            newConfig.locale = locale;
            Locale.setDefault(locale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}
