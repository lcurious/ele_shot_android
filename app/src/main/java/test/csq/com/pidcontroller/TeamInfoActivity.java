package test.csq.com.pidcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TeamInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_start;
    private Button btn_connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);

        initView();
    }

    private void initView() {
        btn_start = findViewById(R.id.btn_start);
        btn_connect = findViewById(R.id.btn_connect);
        btn_start.setOnClickListener(this);
        btn_connect.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_start:
                Toast.makeText(this,"开始演示",Toast.LENGTH_SHORT).show();
                intent = new Intent(this,ChooseActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_connect:
                 intent = new Intent(this,ConnectActivity.class);
                startActivity(intent);
                break;
        }
    }
}
