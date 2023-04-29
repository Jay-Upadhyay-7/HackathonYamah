package com.example.tarang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarang.ml.AgeModel;
import com.example.tarang.MainActivity;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MainActivity2 extends AppCompatActivity {
    private final int GALLERY_REQ_CODE = 1000;
    private final int CAP_REQ_CODE = 1001;
    ImageView imgal ;
    TextView teev;

    Bitmap bitmap;
    int m=0;
    String[] perm={"android.permission.CAMERA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestPermissions(perm,90);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn;
//        teev= findViewById(R.id.demo);
        imgal=findViewById(R.id.imageView);
        btn= findViewById(R.id.button1);
        Button cap;
        cap=findViewById(R.id.capture1);

        cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAP_REQ_CODE);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent igal=new Intent ();
                igal.setAction(Intent.ACTION_GET_CONTENT);
                igal.setType("image/*");
                startActivityForResult(igal,GALLERY_REQ_CODE);
            }
        });
        Button PredButton=findViewById(R.id.predict);
        PredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    AgeModel model = AgeModel.newInstance(MainActivity2.this);
                    if (bitmap == null) {
                        // handle null input data
                        return;
                    }
                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 50, 50, 3}, DataType.FLOAT32);
                    bitmap= Bitmap.createScaledBitmap(bitmap,50,50,true);
                    inputFeature0.loadBuffer(TensorImage.fromBitmap(bitmap).getBuffer());
                    AgeModel.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                    String result=getMax(outputFeature0.getFloatArray())+"";
//                    teev.setText(result);
                    model.close();
                } catch (IOException e) {
                    // TODO Handle the exception
                    System.out.println(e);
                }
            }
        });
    }
    int getMax(float[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[max])max=i;
        }
        return max;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==90){
            if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                Context context= getApplicationContext();
                int duration=Toast.LENGTH_SHORT;
                Toast toast =Toast.makeText(context,"permission not given",duration);
                m=0;
            }
            else {
                m=1;
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if(resultCode==RESULT_OK){
                if(requestCode==GALLERY_REQ_CODE){
                    bitmap=MediaStore.Images.Media.getBitmap(this.getContentResolver(),data.getData());
                    imgal.setImageBitmap(bitmap);
                }
                if(requestCode==CAP_REQ_CODE){
                    bitmap=(Bitmap)data.getExtras().get("data");
                    imgal.setImageBitmap(bitmap);
                }
            }

        }
        catch (Exception e){
            Context context= getApplicationContext();
            int duration=Toast.LENGTH_SHORT;
            Toast toast =Toast.makeText(context,"permission not given",duration);
        }
    }
}