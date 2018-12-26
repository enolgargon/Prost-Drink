package com.cgi.sdm_project.igu.juego.loop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.ContinuarRonda;
import com.cgi.sdm_project.logica.juego.activities.FinJuego;
import com.cgi.sdm_project.logica.juego.activities.IFinJuego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Camara;
import com.cgi.sdm_project.util.PermissionChecker;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CamaraActivity extends Loop implements InicioJuego, IFinJuego {
    static final int REQUEST_TAKE_PHOTO = 1;

    private String mCurrentPhotoPath;

    private ImageView imageView;
    private FloatingActionButton fabCamara;
    private FloatingActionButton fabShare;

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] redes = cm.getAllNetworks();
            for (Network red : redes)
                if (cm.getNetworkInfo(red).getState().equals(NetworkInfo.State.CONNECTED))
                    return true;
            return false;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        Camara regla = (Camara) Juego.getInstance().getJuegoActual();

        imageView = findViewById(R.id.imgCamara);
        fabCamara = findViewById(R.id.fabCamara);
        fabShare = findViewById(R.id.fabShare);

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.txtCamara)).setText(regla.getTexto());
    }

    public void pulsarCamara(View view) {
        PermissionChecker permissionChecker = PermissionChecker.getInstance();
        if (!permissionChecker.isCameraPermissionGranted(this))
            permissionChecker.pedirPermisos(PermissionChecker.CAMARA_LOC, PermissionChecker.MY_PERMISSIONS_CAMARA, this);
        else
            dispatchTakePictureIntent();
    }

    public void retomarPulsarCamara() {
        if (!PermissionChecker.getInstance().isCameraPermissionGranted(this)) {
            new ContinuarRonda().cargarSiguienteJuego(null);
            finish();
        } else
            dispatchTakePictureIntent();
    }


    public void compartir(View view) {
        if (!isConnected(getApplicationContext()))
            Toast.makeText(getApplicationContext(), R.string.error_conexion, Toast.LENGTH_LONG).show();
        else {
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.putExtra(Intent.EXTRA_STREAM,
                    FileProvider.getUriForFile(this, "com.example.android.fileprovider", new File(mCurrentPhotoPath)));
            intent.putExtra(Intent.EXTRA_SUBJECT, R.string.compartir_publi);
            intent.setType("image/jpg");
            startActivity(intent);
        }

        new FinJuego().cargarSiguienteJuego(null);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            galleryAddPic();
            setPic();

            imageView.setVisibility(ImageView.VISIBLE);
            fabShare.setVisibility(FloatingActionButton.VISIBLE);
            fabCamara.setVisibility(FloatingActionButton.GONE);
        }
    }

    /**
     * Handles the result of the request for location permissions.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        PermissionChecker.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
        retomarPulsarCamara();
    }

    private File createImageFile() throws IOException {
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, "", Toast.LENGTH_LONG).show();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void setPic() {
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        new FinJuego().cargarSiguienteJuego(view);
    }
}
