package com.myapplication1.my.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import com.mob.MobSDK;
import com.myapplication1.MainActivity;
import com.myapplication1.R;
import com.myapplication1.my.dao.OwnerDao;

public class LoginActivity extends AppCompatActivity{
    String APPKEY = "35791500161ad";
    String APPSECRETE = "e17788c872154e98f53740947cd67f19";

    private Button login_gotoBack, login_getCode, login_goLog;
    private OwnerDao ownerDao;
    private EditText login_phone, login_code;
    private CheckBox login_agree;
    private Boolean isLogin = false;
    private Boolean isCert = false;
    private Boolean isCheck = false;

    int i = 30;

    private void initView() {
        ownerDao = new OwnerDao(getApplicationContext());

        login_gotoBack = findViewById(R.id.login_gotoBack);
        login_getCode = findViewById(R.id.login_getCode);
        login_goLog = findViewById(R.id.login_goLog);

        login_phone = findViewById(R.id.login_phone);
        login_code = findViewById(R.id.login_code);

        MobSDK.init(this, APPKEY, APPSECRETE);
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int i, int i1, Object o) {
                Message msg = new Message();
                msg.arg1 = i;
                msg.arg2 = i1;
                msg.obj = o;
                handler.sendMessage(msg);
            }
        };
        SMSSDK.registerEventHandler(eventHandler);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @SuppressLint("SetTextI18n")
        public void handleMessage(Message msg) {
            if (msg.what == -9) {
                login_getCode.setText("重新发送(" + i + ")");
            } else if (msg.what == -8) {
                login_getCode.setText("获取验证码");
                login_getCode.setClickable(true);
                i = 30;
            } else {
                int event = msg.arg1;
                int result = msg.arg2;
                Object data = msg.obj;
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 短信注册成功后，返回MainActivity,然后提示
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功
                        isLogin = true;
                        String phone = login_phone.getText().toString();
                        ownerDao.doLogin(phone);
                        SharedPreferences preferences = getSharedPreferences("ownerState", Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("isLogin", isLogin);
                        editor.putBoolean("isCert", isCert);
                        editor.putBoolean("isCheck", isCheck);
                        editor.apply();

                        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        Toast.makeText(getApplicationContext(), "正在获取验证码，请稍候", Toast.LENGTH_SHORT).show();
                    } else {
                        ((Throwable) data).printStackTrace();
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                    Toast.makeText(getApplicationContext(), "获取验证码错误，请稍后重试" + result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        initView();

        login_gotoBack.setOnClickListener(v -> finish());

        login_getCode.setOnClickListener(v -> {
            String phone = login_phone.getText().toString().trim();
            System.out.println(phone);
            if(!judgePhoneNums(phone)) {
                return;
            }
            SMSSDK.getVerificationCode("86", phone);
            login_getCode.setClickable(false);
            login_getCode.setText("重新发送(" + i + ")");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (; i > 0; i--) {
                        handler.sendEmptyMessage(-9);
                        if (i <= 0) {
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    handler.sendEmptyMessage(-8);
                }
            }).start();
        });

        login_goLog.setOnClickListener(v -> {
            String phone = login_phone.getText().toString().trim();
            String code = login_code.getText().toString();
            if (TextUtils.isEmpty(code)) {
                Toast.makeText(getApplicationContext(), "验证码不能为空", Toast.LENGTH_SHORT).show();
            } else {
                SMSSDK.submitVerificationCode("86", phone, code);
            }
        });
        MobSDK.submitPolicyGrantResult(true, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }

    private boolean judgePhoneNums(String phoneNums) {
        if (isMatchLength(phoneNums, 11) && isMobileNO(phoneNums)) {
            return true;
        }
        Toast.makeText(this, "手机号码输入有误！", Toast.LENGTH_SHORT).show();
        return false;
    }

    private static boolean isMatchLength(String str, int length) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.length() == length;
        }
    }

    private static boolean isMobileNO(String mobileNums) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }
}
