package com.assignmentchuyennt.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignmentchuyennt.R;

/**
 * Created by tuanlq@mobgame.vn on 14/5/2019.
 */
public class ErrorView extends ConstraintLayout {
    private static final int DELAY = 100;
    private static final int DURATION = 1000;
    private Handler mHandler;

    private TextView tvTitle;
    private TextView tvMessage;
    private TextView btnAction;
    private ImageView ivError;

    public ErrorView(Context context) {
        super(context);
        init(null);
    }

    public ErrorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ErrorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mHandler = new Handler();
        inflate(getContext(), R.layout.fragment_data_error, this);
//        String no_internet = getContext().getString(R.string.no_internet);
//        String titleDefault = getContext().getString(R.string.txt_error_title_default);
//        String tryagain = getContext().getString(R.string.txt_error_try_again);

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.ErrorView);
//        String title = ta.getString(R.styleable.ErrorView_title);
//        String message = ta.getString(R.styleable.ErrorView_message);
//        String action = ta.getString(R.styleable.ErrorView_action);

        tvTitle = findViewById(R.id.tvTitle);
        tvMessage = findViewById(R.id.tvMessage);
        btnAction = findViewById(R.id.btnAction);
        ivError = findViewById(R.id.ivError);

//        btnAction.setText(TextUtils.isEmpty(action) ? tryagain : action);
//        tvTitle.setText(TextUtils.isEmpty(title) ? titleDefault : title);
//        tvMessage.setText(TextUtils.isEmpty(message) ? no_internet : message);

        ta.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        startAnimationView();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimationView();
    }

    // alternate the view's background color
    Runnable mRunnableCode = new Runnable() {
        @Override
        public void run() {
            ivError.setVisibility(View.VISIBLE);
            tvTitle.setVisibility(View.VISIBLE);
            tvMessage.setVisibility(View.VISIBLE);
            btnAction.setVisibility(View.VISIBLE);

//            YoYo.with(Techniques.Pulse).duration(DURATION).pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT).playOn(ivError);
//            YoYo.with(Techniques.FadeInUp).duration(DURATION).playOn(tvTitle);
//            YoYo.with(Techniques.FadeInUp).duration(DURATION).playOn(tvMessage);

        }
    };

    private void startAnimationView() {
        mHandler.postDelayed(mRunnableCode, DELAY);

    }

    private void stopAnimationView() {
        mHandler.removeCallbacks(mRunnableCode);
    }

//    public View getBtnClose() {
//        return btnClose;
//    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvMessage() {
        return tvMessage;
    }

    public TextView getBtnAction() {
        return btnAction;
    }
}
