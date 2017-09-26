package org.cchao.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.cchao.imagepreviewlib.ImageLoader;
import org.cchao.imagepreviewlib.ImageLoaderListener;
import org.cchao.imagepreviewlib.ImagePreViewActivity;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();

    private ImageView imgOrigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgOrigin = (ImageView) findViewById(R.id.img_origin);

        Glide.with(this)
                .load("http://img3.duitang.com/uploads/item/201606/04/20160604010014_Art48.thumb.224_0.jpeg")
                .into(imgOrigin);

        ImageLoader.init(new ImageLoaderListener() {
            @Override
            public void load(Fragment fragment, PhotoView photoView, String imageUrl) {
                Glide.with(fragment)
                        .load(imageUrl)
                        .into(photoView);
            }
        });

        imgOrigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + imgOrigin.getMeasuredWidth() + "-->" + imgOrigin.getMeasuredHeight() + "-->" + imgOrigin.getPivotX() + "-->" + imgOrigin.getPivotY());
                ArrayList<String> imageList = new ArrayList<>();
                imageList.add("http://img3.duitang.com/uploads/item/201606/04/20160604010014_Art48.thumb.224_0.jpeg");
                imageList.add("http://imgsrc.baidu.com/forum/w=580/sign=a3d6766038292df597c3ac1d8c305ce2/20e941c2d5628535d2e5616e92ef76c6a6ef63b5.jpg");
                imageList.add("http://imgsrc.baidu.com/forum/w%3D580/sign=ba6c1291f21f3a295ac8d5c6a924bce3/028195504fc2d562b30d63a2e51190ef77c66cb5.jpg");
                imageList.add("http://pic1.ipadown.com/imgs/20110326172546834.jpg");
                imageList.add("http://n.sinaimg.cn/97973/transform/20160115/5AgV-fxnqrkc6483530.jpg");
                ImagePreViewActivity.launch(MainActivity.this, 0, imageList);
            }
        });
    }
}
