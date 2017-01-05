package com.example.jerry.testing.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jerry.testing.R;
import com.example.jerry.testing.wedgit.CircleImageView;

import java.io.File;

public class PersonInformationActivity extends BaseActivity implements View.OnClickListener{
    private ImageView image_back,Iv_collection;
    private Context mContext;
    private TextView tv_title,tv_nickname,tv_email;
    private RelativeLayout camera, phone, cancel;
    private CircleImageView  image;
    private android.app.AlertDialog alertDlg;
    private int OK = 100;
    private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    private static final int GAMES = 4;// 游戏
    private static final String PHOTO_FILE_NAME = "temps_photo.jpg";
    private Bitmap bitmap;
    private File tempFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);
        mContext = this;
        initHead();
        image=(CircleImageView)findViewById(R.id.image);
        tv_nickname=(TextView)findViewById(R.id.tv_nickname) ;
        tv_email=(TextView)findViewById(R.id.tv_email) ;
        tv_email.setOnClickListener(this);
        tv_nickname.setOnClickListener(this);
        image.setOnClickListener(this);
    }
    private void initHead() {
        ImageView image_back = (ImageView) findViewById(R.id.image_back);
        ImageView Iv_collection= (ImageView) findViewById(R.id.collection);
        TextView tv_title=(TextView)findViewById(R.id.tv_title) ;
        tv_title.setText("个人信息");
        Iv_collection.setVisibility(View.GONE);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showImgDialog() {
        alertDlg = new android.app.AlertDialog.Builder(this).create();
        alertDlg.show();
        Window window = alertDlg.getWindow();
        window.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        window.setContentView(R.layout.dialog_02);
        camera = (RelativeLayout) window.findViewById(R.id.camera);
        phone = (RelativeLayout) window.findViewById(R.id.phone);
        cancel = (RelativeLayout) window.findViewById(R.id.cancel);
        camera.setOnClickListener(this);
        phone.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }
    /*
   * 从相机获取
   */
    public void camera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    /*
     * 从相册获取
	 */
    public void gallery() {
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    /**
     * 剪切图片
     */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        // 图片格式
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == OK) {
                String ok = data.getExtras().get("ok").toString();
                if (ok.equals("true")) {
                    finish();
                }
            }
            if (requestCode == PHOTO_REQUEST_GALLERY) {
                if (data != null) {
                    // 得到图片的全路径
                    Uri uri = data.getData();
                    crop(uri);
                }

            } else if (requestCode == PHOTO_REQUEST_CAMERA) {
                if (hasSdcard()) {
                    tempFile = new File(Environment.getExternalStorageDirectory(),
                            PHOTO_FILE_NAME);
                    crop(Uri.fromFile(tempFile));
                } else {

                }

            } else if (requestCode == PHOTO_REQUEST_CUT) {
                try {
                    bitmap = data.getParcelableExtra("data");
                    image.setImageBitmap(bitmap);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (requestCode == GAMES) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }

                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                alertDlg.dismiss();
                break;
            case R.id.phone:
                gallery();
                alertDlg.dismiss();
                break;
            case R.id.camera:
                camera();
                alertDlg.dismiss();
                break;
            case R.id.image:
                    showImgDialog();

                break;
            case R.id.tv_nickname:
                Intent intent=new Intent(PersonInformationActivity.this,UpdataNicknameActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_email:
                Intent in=new Intent(PersonInformationActivity.this,UpdataEmailActivity.class);
                startActivity(in);
                break;
        }
    }

}
