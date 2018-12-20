package com.cgi.sdm_project.igu.juego.loop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.FinJuego;
import com.cgi.sdm_project.logica.juego.activities.IFinJuego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.Camara;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CamaraActivity extends AppCompatActivity implements InicioJuego, IFinJuego {
    static final int REQUEST_TAKE_PHOTO = 1;

    private Camara regla;
    private String mCurrentPhotoPath;

    private ImageView imageView;
    private FloatingActionButton fabCamara;
    private FloatingActionButton fabShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        regla = (Camara) Juego.getInstance().getJuegoActual();

        imageView = findViewById(R.id.imgCamara);
        fabCamara = findViewById(R.id.fabCamara);
        fabShare = findViewById(R.id.fabShare);

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.txtCamara)).setText(regla.getTexto());
    }

    public void pulsarCamara(View view) {
        dispatchTakePictureIntent();
    }

    public void compartir(View view) {
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpg");
        shareIntent.putExtra(Intent.EXTRA_STREAM, mCurrentPhotoPath);
        startActivity(Intent.createChooser(shareIntent, "Share image using"));
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            galleryAddPic();
            setPic();

            imageView.setVisibility(ImageView.VISIBLE);
            fabShare.setVisibility(FloatingActionButton.VISIBLE);
            fabCamara.setVisibility(FloatingActionButton.VISIBLE);
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
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
        // Get the dimensions of the View
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        new FinJuego().cargarSiguienteJuego(view);
    }
}
