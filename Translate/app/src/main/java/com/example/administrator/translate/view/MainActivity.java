package com.example.administrator.translate.view;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.translate.Cheeses;
import com.example.administrator.translate.R;
import com.example.administrator.translate.base.MyApplication;
import com.example.administrator.translate.interFace.BaiduEncyclopediaInterFace;
import com.example.administrator.translate.interFace.BingInterFace;
import com.example.administrator.translate.interFace.YoudaoInterFace;
import com.example.administrator.translate.presenter.BingPresenter;
import com.example.administrator.translate.util.EditTextInputListener;
import com.example.administrator.translate.util.TypewritingVisual;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BingInterFace.BingPicView, YoudaoInterFace.YoudaoView, BaiduEncyclopediaInterFace.BaiduEncyclopediaView {
    private final String TAG = "运行至此";
    private ListView lv_left;
    private View iv_header;
    private DragLayout dl;
    private ImageView bing_img;
    private EditText input;
    private TextView output;
    private LinearLayout layoutmain, lin1;
    private TypewritingVisual typewritingVisual;
    private BingInterFace.BingPicPresenter bingPicPresenter;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Button clear_btn, recording_btn;
    private LinearLayout invisible_layout, btn_layout;
    private TextView network_data;

    /*
    初始化函数，初始化界面等
     */
    private void initialize() {
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        typewritingVisual = new TypewritingVisual(MainActivity.this);
        layoutmain = (LinearLayout) findViewById(R.id.linearlayout_main);
        lin1 = (LinearLayout) findViewById(R.id.line1);
        input = (EditText) findViewById(R.id.edit_input);
        output = (TextView) findViewById(R.id.output_textv);
        bing_img = (ImageView) findViewById(R.id.bing_pic_img);
        network_data = (TextView) findViewById(R.id.network_data);
        invisible_layout = (LinearLayout) findViewById(R.id.invisible_layout);
        btn_layout = (LinearLayout) findViewById(R.id.btn_layout);
        recording_btn = (Button) findViewById(R.id.recording_btn);
        clear_btn = (Button) findViewById(R.id.clear_btn);
        iv_header = findViewById(R.id.iv_header);
        lv_left = (ListView) findViewById(R.id.lv_left);
        lv_left.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.WHITE);
                return view;
            }
        });
        dl = (DragLayout) findViewById(R.id.dl);
        dl.setOnDragUpdateListener(new DragLayout.OnDragUpdateListener() {
            @Override
            public void onOpen() {
            }

            @Override
            public void onDraging(float percent) {
                ViewHelper.setAlpha(iv_header, 1 - percent);
                dl.requestFocus();
                typewritingVisual.tooggleSoftInputHide(dl);
            }

            @Override
            public void onClose() {
                ObjectAnimator animator = ObjectAnimator.ofFloat(iv_header, "translationX", 15f);
                animator.setInterpolator(new CycleInterpolator(4));
                animator.setDuration(500);
                animator.start();
            }
        });
        iv_header.setOnClickListener(this);
        layoutmain.setOnClickListener(this);
        lin1.setOnClickListener(this);
        clear_btn.setOnClickListener(this);
        recording_btn.setOnClickListener(this);
//        input.setOnTouchListener(this);
        bingPicPresenter = new BingPresenter(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        input.addTextChangedListener(new EditTextInputListener(input, MainActivity.this, clear_btn, invisible_layout, MainActivity.this, btn_layout));
        bingPicPresenter.bingPicLoadData();

    }

    /*
        本Activity内所有控件的点击事件响应
         */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_header:
                dl.open(true);
                break;
            case R.id.linearlayout_main:
                dl.close(true);
                break;
            case R.id.clear_btn:
                input.setText("");
                invisible_layout.setVisibility(View.GONE);
                btn_layout.setVisibility(View.VISIBLE);
                break;
            case R.id.recording_btn:
                if (recording_btn.getText().toString().equals("中")) {
                    recording_btn.setText("英");
                } else {
                    recording_btn.setText("中");
                }
                break;
            default:
                dl.close(true);
                break;
        }
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        int action = event.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN: //手指按下
//                dl.close(true);
//                typewritingVisual.toggleSoftInput(v);
//                break;
//            case MotionEvent.ACTION_MOVE: //手指移动（从手指按下到抬起 move多次执行）
//                typewritingVisual.tooggleSoftInputHide(v);
//                break;
//            case MotionEvent.ACTION_UP: //手指抬起
//                break;
//        }
//        return true; //表示消费了触摸事件，onTouch之后才执行onClick,这里被消费了，所以，相关的点击事件不会执行。
//    }

    @Override
    public void bingPicSetdata(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                Glide.with(MyApplication.getContext()).load(str).into(bing_img);
                editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("bing_pic", str);
                editor.apply();
            }
        });
    }

    @Override
    public void youdaoSetdata(final String str) {
        if (input.getText().toString().equals("")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    output.setText("");
                }
            });
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    output.setText(str);
                }
            });
        }
    }

    @Override
    public void baiduEncyclopediaSetData(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                network_data.setText(str);
            }
        });
    }

    public void readBingUrl() {
        pref = getSharedPreferences("data", MODE_PRIVATE);
        String bing_pic = pref.getString("bing_pic", "");
        Glide.with(MyApplication.getContext()).load(bing_pic).into(bing_img);
        Log.d(TAG, "saveBingUrl: " + bing_pic);
    }


}
