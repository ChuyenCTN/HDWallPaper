package com.assignmentchuyennt.ui.imagedetail;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.ui.base.BaseActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class ImageDetailActivity extends BaseActivity<ImageDetailPresenter> implements ImageDetailView {
    private ImageView imgDetailImage;
    private FloatingActionsMenu fabOptionImageDetail;
    private FloatingActionButton action4;
    private FloatingActionButton action3;
    private FloatingActionButton action2;
    private FloatingActionButton action1;
    private Toolbar toolbarImageDetail;
    private ImageView imgBackActivity;
    private DisplayMetrics displayMetrics;
    int width, height;
    String urlImage;
    private ProgressDialog progressBar;


    @Override
    protected int getIdLayout() {
        return R.layout.activity_image_detail;
    }

    @Override
    protected void initData() {
        setSupportActionBar(toolbarImageDetail);
        mPresenter = new ImageDetailPresenter();
        mPresenter.attachView(this);
        mapping();

        Intent intent = getIntent();
        urlImage = intent.getStringExtra("url");
        Picasso.get().load(urlImage).into(imgDetailImage);
        imgBackActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        onClickFabButton();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showListisEmpty(String message) {

    }

    @Override
    public void showError() {

    }

    void mapping() {
        toolbarImageDetail = (Toolbar) findViewById(R.id.toolbar_imageDetail);
        imgBackActivity = (ImageView) findViewById(R.id.img_backActivity);
        imgDetailImage = (ImageView) findViewById(R.id.img_detailImage);
        fabOptionImageDetail = (FloatingActionsMenu) findViewById(R.id.fab_optionImageDetail);
        action4 = (FloatingActionButton) findViewById(R.id.action4);
        action3 = (FloatingActionButton) findViewById(R.id.action3);
        action2 = (FloatingActionButton) findViewById(R.id.action2);
        action1 = (FloatingActionButton) findViewById(R.id.action1);
    }

    void onClickFabButton() {
        action1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ImageDetailActivity.this);
                View v1 = getLayoutInflater().inflate(R.layout.dialog_setwall, null);
                Button btnHome = v1.findViewById(R.id.btnHome);
                Button btnLock = v1.findViewById(R.id.btnLock);
                Button btnBoth = v1.findViewById(R.id.btnBoth);
                TextView tvCancel = (TextView) v1.findViewById(R.id.tv_cancel);

                builder.setView(v1);
                final Dialog dialog = builder.create();
                dialog.show();

                tvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnBoth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GetScreenWidthHeight();
                        final Bitmap bitmapImg = ((BitmapDrawable) imgDetailImage.getDrawable()).getBitmap();
                        final WallpaperManager wallManager = WallpaperManager.getInstance(getApplicationContext());
                        try {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                // On Android N and above use the new API to set both the general system wallpaper and
                                // the lock-screen-specific wallpaper
                                wallManager.setBitmap(bitmapImg, null, true, WallpaperManager.FLAG_LOCK | WallpaperManager.FLAG_LOCK);
                            } else {
                                wallManager.setBitmap(bitmapImg);

                            }
                            Toast.makeText(ImageDetailActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } catch (IOException ex) {
                        }
                    }
                });
                btnHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GetScreenWidthHeight();
                        final Bitmap bitmapImg = ((BitmapDrawable) imgDetailImage.getDrawable()).getBitmap();
                        final WallpaperManager wallManager = WallpaperManager.getInstance(getApplicationContext());
                        try {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                // On Android N and above use the new API to set both the general system wallpaper and
                                // the lock-screen-specific wallpaper
                                wallManager.setBitmap(bitmapImg, null, true, WallpaperManager.FLAG_SYSTEM);
                            } else {
                                wallManager.setBitmap(bitmapImg);

                            }
                            Toast.makeText(ImageDetailActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } catch (IOException ex) {
                        }
                    }
                });
                btnLock.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GetScreenWidthHeight();
                        final Bitmap bitmapImg = ((BitmapDrawable) imgDetailImage.getDrawable()).getBitmap();
                        final WallpaperManager wallManager = WallpaperManager.getInstance(getApplicationContext());
                        try {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                // On Android N and above use the new API to set both the general system wallpaper and
                                // the lock-screen-specific wallpaper
                                wallManager.setBitmap(bitmapImg, null, true, WallpaperManager.FLAG_LOCK);
                            } else {
                                wallManager.setBitmap(bitmapImg);

                            }
                            Toast.makeText(ImageDetailActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } catch (IOException ex) {
                        }
                    }
                });

            }
        });
        action3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(imgDetailImage.getDrawable()));
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        action2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadFileFromURL(ImageDetailActivity.this).execute(urlImage);
            }
        });

        action4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageDetailActivity.this, "Favorite", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void GetScreenWidthHeight() {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2) {
            displayMetrics = new DisplayMetrics();
            width = displayMetrics.widthPixels;
            height = displayMetrics.heightPixels;
        } else {
            displayMetrics = new DisplayMetrics();
            Point size = new Point();
            WindowManager windowManager = getWindowManager();
            windowManager.getDefaultDisplay().getSize(size);
            width = size.x;
            height = size.y;
        }
    }

    private void saveImage() {
        Picasso.get()
                .load(urlImage)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        try {
                            File mydie = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + "/Camera");
                            if (!mydie.exists()) {
                                mydie.mkdirs();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(mydie, new Date().toString() + ".jpg"));
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            Toast.makeText(getApplicationContext(), "Save Successfully", Toast.LENGTH_LONG).show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }

                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }

    class DownloadFileFromURL extends AsyncTask<String, Integer, String> {
        public Context context;

        public DownloadFileFromURL(Context context) {
            this.context = context;
        }

        /**
         * Before starting background thread
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("Starting download");
            progressBar = new ProgressDialog(ImageDetailActivity.this);
            progressBar.setMessage("Loading... Please wait...");
            progressBar.setIndeterminate(false);
            progressBar.setCancelable(false);
            progressBar.show();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            String param = f_url[0];
            try {
                String root = Environment.getExternalStorageDirectory().toString();
                URL url = new URL(param);
                URLConnection connection = url.openConnection();
                connection.connect();
                int lenghtOfFile = connection.getContentLength();
                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                // Output stream to write file
                int start = urlImage.length() - 10;
                int end = urlImage.length();

                OutputStream output = new FileOutputStream(root + "/" + urlImage.substring(start, end));

                byte data[] = new byte[1024];

                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress((int) (total * 100 / lenghtOfFile));
                    // writing data to file
                    output.write(data, 0, count);
                }
                // flushing output
                output.flush();
                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
            return null;
        }

        /**
         * After completing background task
         **/
        @Override
        protected void onPostExecute(String file_url) {
            progressBar.dismiss();
            Toast.makeText(context, "Download Success", Toast.LENGTH_SHORT).show();
        }

    }
}
