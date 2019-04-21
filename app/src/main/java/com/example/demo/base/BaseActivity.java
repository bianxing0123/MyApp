package com.example.demo.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.demo.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public abstract class BaseActivity extends AppCompatActivity {
	protected Context mContext = this;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ImagePipelineConfig frescoConfig = ImagePipelineConfig.newBuilder(this).setDownsampleEnabled(true).build();
		Fresco.initialize(this, frescoConfig);
		setContentView(getLayoutId());
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_shopdetail);
		toolbar.setTitle("");
		setSupportActionBar(toolbar);
	}

	protected abstract int getLayoutId();

	public void close(View view) {
		finish();
	}

	public void goAccount(View view) {
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
}
