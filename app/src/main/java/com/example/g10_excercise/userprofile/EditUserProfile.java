package com.example.g10_excercise.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g10_excercise.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class EditUserProfile<random> extends AppCompatActivity {
    Button save;
    EditText eemail ,nname,ccontact;
    String path;
    //private static int RESULT_LOAD_IMAGE = 1;
    private static final String IMAGE_DIRECTORY = "/G10Project";
    ImageView imageView;
    private String ImageURL="https://www.freepngimg.com/thumb/cartoon/2-2-cartoon-png-picture.png";
    private int GALLERY = 1, CAMERA = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_profile);
        save =(Button)findViewById(R.id.save);
        nname =(EditText)findViewById(R.id.name);
        eemail =(EditText)findViewById(R.id.email);
        ccontact =(EditText)findViewById(R.id.contact);
        final ImageView imageView =(ImageView)findViewById(R.id.profile);
        final ImageView avatar = findViewById(R.id.profile);
        Intent i = getIntent();
        final UserProfileModel upm1 = (UserProfileModel)i.getSerializableExtra("User");

        eemail.setText(upm1.getEmail());
        nname.setText(upm1.getName());
        ccontact.setText(upm1.getContact());
        new DownloadImageFromInternet(avatar).execute(upm1.getImageURL());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = eemail.getText().toString();
                String Name = nname.getText().toString();
                String Contact = ccontact.getText().toString();
                if (Email.isEmpty()) {
                    eemail.setError("This field can not be empty");
                } else if (Name.isEmpty()) {
                    nname.setError("this field can not be empty");
                } else if (Contact.isEmpty()) {
                    ccontact.setError("this field can not be empty");
                }
                else if((imageView.getTag())==null)
                {
                    UserProfileModel upm = new UserProfileModel(Email, Name,Contact ,upm1.getImageURL());
                    Intent ii = new Intent(getApplicationContext(), UserProfileActivity.class);
                    ii.putExtra("User", upm);
                    setResult(RESULT_OK, ii);
                    finish();

                }
                else
                {UserProfileModel upm = new UserProfileModel(Email, Name, Contact,(avatar.getTag()).toString());
                    Intent ii = new Intent(getApplicationContext(), UserProfileActivity.class);
                    ii.putExtra("User", upm);
                    setResult(RESULT_OK, ii);
                    finish();

                }
            }
        });
        avatar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                showPictureDialog();
                return false;

            }
        });
    }
    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();}
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.profile);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            Toast.makeText(this, picturePath, Toast.LENGTH_LONG).show();
            imageView.setTag(selectedImage);
        }
        else if (requestCode == CAMERA && resultCode == RESULT_OK && null != data ) {
            Bitmap bitMap = (Bitmap) data.getExtras().get("data");
            ImageView imageView = (ImageView) findViewById(R.id.profile);
            imageView.setImageBitmap(bitMap);
            path = saveImage(bitMap);
            Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
            imageView.setTag(path);

        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY );// create a File/folder  object for the parent directory
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }
        try {
            File f = new File(wallpaperDirectory, "Img_" + Calendar.getInstance()
                        .getTimeInMillis() + ".jpg");// create a File /images name  object for the output file
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);//To write the data to file,convert the data into bytes and save it to file./ now attach the OutputStream to the file object, instead of a String representation
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::---&gt;" + f.getAbsolutePath());
            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
    }

