package com.example.testing.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testing.Activity.HolderActivity;
import com.example.testing.Activity.ItemPageSelectListener;
import com.example.testing.ModelClasses.Model;
import com.example.testing.R;

import static android.app.Activity.RESULT_OK;

public class UploadFragment extends Fragment implements View.OnClickListener {

    private static final int PICK_IMAGE_REQUEST_PASSPORT = 1;
    private static final int PICK_IMAGE_REQUEST_PIC = 2;
    private Uri selectedImage1,selectedImage2;
    private Button passButton, picButton, previous_up, next_up;
    private ImageView imageViewPass, imageViewPic;

    Model model = Model.newInstance();

    ItemPageSelectListener listener;
    String text;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ItemPageSelectListener) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_upload, container, false);

        passButton = v.findViewById(R.id.buttonPass);
        picButton = v.findViewById(R.id.buttonPic);
        previous_up = v.findViewById(R.id.up_previous);
        next_up = v.findViewById(R.id.up_next);

        imageViewPass = v.findViewById(R.id.imagePass);
        imageViewPic = v.findViewById(R.id.imagePic);

        text = getResources().getString(R.string.error_pic);



        passButton.setOnClickListener(this);
        picButton.setOnClickListener(this);

        previous_up.setOnClickListener(this);
        next_up.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPass:
                showFileChooser();
                break;
            case R.id.buttonPic:
                showFileChooserNID();
                break;
            case R.id.up_previous:
                listener.onSelectPreviousItem();
                break;
            case R.id.up_next:
                if(model.getPassportSizePhoto()!=null && model.getFullSizePhoto() != null){
                Intent intent = new Intent(getActivity(), HolderActivity.class);
                intent.putExtra("model",model);
                Log.d("DDDDDDDDDbefore", model.toString());
                startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select an image"), PICK_IMAGE_REQUEST_PASSPORT);
    }

    private void showFileChooserNID() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select an image"), PICK_IMAGE_REQUEST_PIC);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST_PASSPORT && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImage1 = data.getData();
            imageViewPass.setImageURI(selectedImage1);
            model.setPassportSizePhoto(selectedImage1.toString());


        } else if (requestCode == PICK_IMAGE_REQUEST_PIC && resultCode == RESULT_OK && data != null && data.getData() != null) {
            //filePath = data.getData();
            selectedImage2 = data.getData();
            imageViewPic.setImageURI(selectedImage2);
            model.setFullSizePhoto(selectedImage2.toString());


        }
    }
}