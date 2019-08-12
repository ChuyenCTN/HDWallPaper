package com.assignmentchuyennt.ui.common;

import android.app.ProgressDialog;
import android.content.Context;

public final class ShowCommon {

    private static final String TAG = "ShowCommon";

    private Context mContext;

    private ProgressDialog progressDialog;

    public ShowCommon(Context mContext) {
        this.mContext = mContext;
    }

//    public ProgressDialog showLoadingDialog() {
//        progressDialog = new ProgressDialog(mContext);
//        progressDialog.show();
//        if (progressDialog.getWindow() != null) {
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        progressDialog.setContentView(R.layout.progress_dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setCancelable(false);
//        progressDialog.setCanceledOnTouchOutside(false);
//        return progressDialog;
//    }

    public void hideLoadingDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


//    public static void showDialogMessage(Context context, String message) {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        String title = context.getString(R.string.title_alert);
////        set color title
//        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.BLACK);
//        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(title);
//        stringBuilder.setSpan(foregroundColorSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        // Set Title
//        builder.setTitle(stringBuilder);
//        builder.setMessage(message);
//        builder.setCancelable(false);
//        builder.setNegativeButton(context.getString(R.string.txt_no), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        builder.setPositiveButton(context.getString(R.string.txt_yes), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

//    public static void showMessage(Context context, String message) {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        String title = context.getString(R.string.title_alert);
////        set color title
//        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.BLACK);
//        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(title);
//        stringBuilder.setSpan(foregroundColorSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        // Set Title
//        builder.setTitle(stringBuilder);
//        builder.setMessage(message);
//        builder.setCancelable(false);
//        builder.setPositiveButton(context.getString(R.string.txt_agree), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

//    public static void showImage(Context context, String url, ImageView image) {
//        String url2 = (String) url.replace(String.valueOf("\\"), "/");
//        Picasso.with(context).load(Const.BASE_URL + url2).fit().centerInside().into(image);
//    }

    public void showProgressBar() {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

}
