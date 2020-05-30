package test.csq.com.pidcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_t1;
    private Button btn_t2;
    private Button btn_t3;
    private Button btn_t4;
    private Button btn_t5;
    private Button btn_t6;
    private Button btn_t7;
    private Button btn_t8;

//    private int pageId=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        initView();
    }

    private void initView() {
        btn_t1 = findViewById(R.id.btn_t1);
        btn_t2 = findViewById(R.id.btn_t2);
        btn_t3 = findViewById(R.id.btn_t3);
        btn_t4 = findViewById(R.id.btn_t4);
        btn_t5 = findViewById(R.id.btn_t5);
        btn_t6 = findViewById(R.id.btn_t6);
        btn_t7 = findViewById(R.id.btn_t7);
        btn_t8 = findViewById(R.id.btn_t8);
        btn_t1.setOnClickListener(this);
        btn_t2.setOnClickListener(this);
        btn_t3.setOnClickListener(this);
        btn_t4.setOnClickListener(this);
        btn_t5.setOnClickListener(this);
        btn_t6.setOnClickListener(this);
        btn_t7.setOnClickListener(this);
        btn_t8.setOnClickListener(this);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_t1:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this,ControlActivity.class);
                intent1.putExtra("T",1);
                this.startActivity(intent1);
                break;
            case R.id.btn_t2:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this,ControlActivity.class);
                intent2.putExtra("T",2);
                this.startActivity(intent2);
                break;
            case R.id.btn_t3:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this,ControlActivity.class);
                intent3.putExtra("T",3);
                this.startActivity(intent3);
                break;
            case R.id.btn_t4:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this,ControlActivity.class);
                intent4.putExtra("T",4);
                this.startActivity(intent4);
                break;
            case R.id.btn_t5:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this,ControlActivity.class);
                intent5.putExtra("T",5);
                this.startActivity(intent5);
                break;
            case R.id.btn_t6:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this,ControlActivity.class);
                intent6.putExtra("T",6);
                this.startActivity(intent6);
                break;
            case R.id.btn_t7:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this,ControlActivity.class);
                intent7.putExtra("T",7);
                this.startActivity(intent7);
                break;
            case R.id.btn_t8:
//                Toast.makeText(this,"题目1",Toast.LENGTH_SHORT).show();
                Intent intent8 = new Intent(this,ControlActivity.class);
                intent8.putExtra("T",8);
                this.startActivity(intent8);
                break;

        }
    }
}
