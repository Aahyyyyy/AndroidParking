package com.myapplication1.my.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.myapplication1.R;
import com.myapplication1.my.dao.OwnerDao;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/9 20:59
 */
public class TestActivity extends AppCompatActivity {
    private OwnerDao ownerDao;
    private EditText test_phone;
    private Button test_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        SQLiteStudioService.instance().start(this);

        ownerDao = new OwnerDao(getApplicationContext());

        test_phone = findViewById(R.id.phone);
        test_button = findViewById(R.id.button);

        test_button.setOnClickListener(v -> {
            String phone = test_phone.getText().toString();
            ownerDao.doLogin(phone);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SQLiteStudioService.instance().stop();
    }

}
