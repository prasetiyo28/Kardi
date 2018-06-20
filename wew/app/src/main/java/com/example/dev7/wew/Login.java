package com.example.dev7.wew;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev7.wew.network.LoginService;

import android.text.TextUtils;


import com.example.dev7.wew.model.User;
import com.example.dev7.wew.util.PrefUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btGo;
    private CardView cv;
    private FloatingActionButton fab;


    private EditText emailText;
    private EditText passwordText;
    private Button btnLogin;
    private TextView registerCaption;

    private LoginService loginService;


    public static void start(Context context) {
        Intent intent = new Intent(context, Login.class);
        context.startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setListener();

        if(isSessionLogin()) {
            MainActivity.start(this);
            Login.this.finish();
        }

        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAct();
            }
        });

//        String caption = "Dont have an account? <b>RegisterActivity</b>";
//        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(caption));
//        spannableStringBuilder.setSpan(new ClickableSpan() {
//
//            @Override
//            public void onClick(View view) {
//                Register.start(Login.this);
//            }
//        }, caption.indexOf("RegisterActivity") - 3, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.WHITE), caption
//                .indexOf("RegisterActivity") - 3, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        registerCaption.setText(spannableStringBuilder);
//        registerCaption.setMovementMethod(LinkMovementMethod.getInstance());
    }
    void loginAct() {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if(TextUtils.isEmpty(email)) {
            emailText.setError("Email cannot be empty!");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            passwordText.setError("Password cannot be empty");
            return;
        }

        loginService = new LoginService(this);
        loginService.doLogin(email, password, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                User user = (User) response.body();

                if(user != null) {
                    if(!user.isError()) {
                        PrefUtil.putUser(Login.this, PrefUtil.USER_SESSION, user);
                        MainActivity.start(Login.this);
                        Login.this.finish();
                    }

                    Toast.makeText(Login.this, user.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Login.this, "An error occurred!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    boolean isSessionLogin() {
        return PrefUtil.getUser(this, PrefUtil.USER_SESSION) != null;
    }

    private void initView() {
//        etUsername = findViewById(R.id.et_username);
//        etPassword = findViewById(R.id.et_password);
//        btGo = findViewById(R.id.bt_go);
        cv = findViewById(R.id.cv);
        fab = findViewById(R.id.fab);
    }

    private void setListener() {
//        btGo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Explode explode = new Explode();
//                explode.setDuration(500);
//
//                getWindow().setExitTransition(explode);
//                getWindow().setEnterTransition(explode);
//                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(Login.this);
//                Intent i2 = new Intent(Login.this,MainActivity.class);
//                startActivity(i2, oc2.toBundle());
//            }
//        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, fab, fab.getTransitionName());
                startActivity(new Intent(Login.this, Register.class), options.toBundle());
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        fab.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fab.setVisibility(View.VISIBLE);
    }
}
