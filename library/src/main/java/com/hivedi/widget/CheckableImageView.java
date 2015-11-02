package com.hivedi.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

/**
 * Created by Hivedi on 2015-11-02.
 *
 */
public class CheckableImageView extends ImageView implements Checkable {

	private static final int[] CHECKED_STATE_SET = {
		android.R.attr.state_checked
	};

	private boolean checked = false;

	public CheckableImageView(Context context) {
		super(context);
		init();
	}

	public CheckableImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CheckableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public CheckableImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	private void init() {

	}

	@Override
	public int[] onCreateDrawableState(int extraSpace) {
		final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
		if (isChecked()) {
			mergeDrawableStates(drawableState, CHECKED_STATE_SET);
		}
		return drawableState;
	}

	@Override
	public boolean isChecked() {
		return checked;
	}

	@Override
	public void toggle() {
		this.checked = !this.checked;
		setChecked(this.checked);
	}

	@Override
	public void setChecked(boolean checked) {
		this.checked = checked;
		refreshDrawableState();
	}

}
