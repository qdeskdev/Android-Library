package com.qdesk.toasty;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.*;

public class Toaster {
    private static final int DEFAULT_TEXT_COLOR = Color.WHITE;
    private static final int DEFAULT_CORNER_RADIUS = 24; // dp
    private static final int DEFAULT_ELEVATION = 8; // dp
    private static final int ANIMATION_DURATION = 300; // ms
    private static final int ICON_SIZE = 24; // dp

    public enum Style {
        STANDARD("#333333", R.drawable.ic_custom),
        SUCCESS("#4CAF50", R.drawable.ic_success),
        ERROR("#F44336", R.drawable.ic_error),
        WARNING("#FF9800", R.drawable.ic_warning),
        INFO("#2196F3", R.drawable.ic_info);

        final String bgColor;
        final int iconRes;

        Style(String bgColor, @DrawableRes int iconRes) {
            this.bgColor = bgColor;
            this.iconRes = iconRes;
        }
    }

    public static void show(Context context, String message) {
        show(context, message, Style.STANDARD, Toast.LENGTH_SHORT);
    }

    public static void success(Context context, String message) {
        show(context, message, Style.SUCCESS, Toast.LENGTH_SHORT);
    }

    public static void error(Context context, String message) {
        show(context, message, Style.ERROR, Toast.LENGTH_SHORT);
    }

    public static void warning(Context context, String message) {
        show(context, message, Style.WARNING, Toast.LENGTH_SHORT);
    }

    public static void info(Context context, String message) {
        show(context, message, Style.INFO, Toast.LENGTH_SHORT);
    }

    public static void showLong(Context context, String message) {
        show(context, message, Style.STANDARD, Toast.LENGTH_LONG);
    }

    private static void show(Context context, String message, Style style, int duration) {
        new Handler(Looper.getMainLooper()).post(() -> {
            try {
                Toast toast = new Toast(context);
                View view = LayoutInflater.from(context).inflate(
                        R.layout.custom_toast, null);

                // Configure views
                ViewGroup container = view.findViewById(com.qdesk.toasty.R.id.toast_container);
                ImageView icon = view.findViewById(com.qdesk.toasty.R.id.toast_icon);
                TextView text = view.findViewById(com.qdesk.toasty.R.id.toast_text);

                // Set style properties
                GradientDrawable bg = new GradientDrawable();
                bg.setColor(Color.parseColor(style.bgColor));
                bg.setCornerRadius(dpToPx(context, DEFAULT_CORNER_RADIUS));
                container.setBackground(bg);
                container.setElevation(dpToPx(context, DEFAULT_ELEVATION));

                // Set content
                icon.setImageResource(style.iconRes);
                icon.setColorFilter(DEFAULT_TEXT_COLOR);
                text.setText(message);
                text.setTextColor(DEFAULT_TEXT_COLOR);

                // Animate and show
                animateToast(view, () -> {
                    toast.setView(view);
                    toast.setDuration(duration);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, dpToPx(context, 60));
                    toast.show();
                });
            } catch (Exception e) {
                Toast.makeText(context, message, duration).show();
            }
        });
    }

    private static void animateToast(View view, Runnable onComplete) {
        view.setAlpha(0f);
        view.setTranslationY(-dpToPx(view.getContext(), 20));

        view.animate()
                .alpha(1f)
                .translationY(0)
                .setDuration(ANIMATION_DURATION)
                .setInterpolator(new DecelerateInterpolator())
                .withEndAction(onComplete)
                .start();
    }

    private static int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}