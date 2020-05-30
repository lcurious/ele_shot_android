package test.csq.com.pidcontroller;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import test.csq.com.pidcontroller.bt.BtBase;
import test.csq.com.pidcontroller.bt.BtClient;
import test.csq.com.pidcontroller.bt.BtDevAdapter;
import test.csq.com.pidcontroller.util.BtReceiver;

public class ControlActivity extends Activity implements View.OnClickListener,  BtBase.Listener{

    private int info = 0;
    private boolean pid_visibility = false;
    private Button btn_pid;
    private Button btn_play;
    private Button btn_end;
    private Button btn_send;
    private ImageView img_choose_bg;
    private LinearLayout ll_pid;
    private int[] bg_list = {
            R.drawable.choose1bg,
            R.drawable.choose2bg,
            R.drawable.choose3bg,
            R.drawable.choose4bg,
            R.drawable.choose5bg,
            R.drawable.choose6bg,
            R.drawable.choose7bg,
            R.drawable.choose8bg };

    private Button btn_p_plus;
    private Button btn_i_plus;
    private Button btn_d_plus;
    private Button btn_c_plus;
    private Button btn_p_minus;
    private Button btn_i_minus;
    private Button btn_d_minus;
    private Button btn_c_minus;

    private EditText edit_p;
    private EditText edit_i;
    private EditText edit_d;
    private EditText edit_c;
    private Button btn_update;
    private ImageView img_p;
    private ImageView img_i;
    private ImageView img_d;
    private ImageView img_c;

    private Button btn_reconnect;
    private BtReceiver mBtReceiver;
    public final BtClient mClient = new BtClient(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        //接受页面传递参数info
        Intent intent = getIntent();
       info = intent.getIntExtra("T",1);
        Log.i("TTTTTTT",info+"");

        initView();
        if (mClient.isConnected(ConnectActivity.device)) {
            APP.toast("已经连接了", 0);
            return;
        }else{
        mClient.connect(ConnectActivity.device);
        APP.toast("正在连接...", 0);
        }
    }
    private void initView() {
        btn_play = findViewById(R.id.btn_play);
        btn_end = findViewById(R.id.btn_end);
        btn_pid = findViewById(R.id.btn_pid);
        btn_send = findViewById(R.id.btn_send);
        img_choose_bg = findViewById(R.id.img_choose_bg);
        ll_pid = findViewById(R.id.ll_pid);
        btn_p_plus = findViewById(R.id.btn_p_plus);
        btn_i_plus = findViewById(R.id.btn_i_plus);
        btn_d_plus = findViewById(R.id.btn_d_plus);
//        btn_c_plus = findViewById(R.id.btn_c_plus);

        btn_p_minus = findViewById(R.id.btn_p_minus);
        btn_i_minus = findViewById(R.id.btn_i_minus);
        btn_d_minus = findViewById(R.id.btn_d_minus);
//        btn_c_minus = findViewById(R.id.btn_c_minus);

        edit_p = findViewById(R.id.edit_p);
        edit_i = findViewById(R.id.edit_i);
        edit_d = findViewById(R.id.edit_d);
//        edit_c = findViewById(R.id.edit_c);
        btn_update = findViewById(R.id.btn_update);
        btn_reconnect = findViewById(R.id.btn_reconnect);

        btn_play.setOnClickListener(this);
        btn_end.setOnClickListener(this);
        btn_pid.setOnClickListener(this);
        btn_send.setOnClickListener(this);
        btn_p_plus.setOnClickListener(this);
        btn_i_plus.setOnClickListener(this);
        btn_d_plus.setOnClickListener(this);
//        btn_c_plus.setOnClickListener(this);
        btn_p_minus.setOnClickListener(this);
        btn_i_minus.setOnClickListener(this);
        btn_d_minus.setOnClickListener(this);
//        btn_c_minus.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_reconnect.setOnClickListener(this);
//        edit_p.setOnClickListener(this);
//        edit_d.setOnClickListener(this);
//        edit_d.setOnClickListener(this);
        img_p = findViewById(R.id.img_p);
        img_i = findViewById(R.id.img_i);
        img_d = findViewById(R.id.img_d);
//        img_c = findViewById(R.id.img_c);

        img_p.setOnClickListener(this);
        img_i.setOnClickListener(this);
        img_d.setOnClickListener(this);


        bg_change();
    }

    private void bg_change() {
        switch (info){
            case 1:
                img_choose_bg.setBackgroundResource(bg_list[0]);
                break;
            case 2:
                img_choose_bg.setBackgroundResource(bg_list[1]);
                break;
            case 3:
                img_choose_bg.setBackgroundResource(bg_list[2]);
                break;
            case 4:
                img_choose_bg.setBackgroundResource(bg_list[3]);
                break;
            case 5:
                img_choose_bg.setBackgroundResource(bg_list[4]);
                break;
            case 6:
                img_choose_bg.setBackgroundResource(bg_list[5]);
                break;
            case 7:
                img_choose_bg.setBackgroundResource(bg_list[6]);
                break;
            case 8:
                img_choose_bg.setBackgroundResource(bg_list[7]);
                break;


        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                Toast.makeText(this,"电机工作!",Toast.LENGTH_SHORT).show();
//                发送数据
                mClient.sendMsg("{@"+info+"@"+1+"}");
                break;
            case R.id.btn_end:
                Toast.makeText(this,"复位!",Toast.LENGTH_SHORT).show();
                mClient.sendMsg("{@"+info+"@"+2+"}");
                break;
            case R.id.btn_send:
                Toast.makeText(this,"开始执行!",Toast.LENGTH_SHORT).show();
                mClient.sendMsg("{@"+info+"@"+4+"}");
                break;
            case R.id.img_p:
                Toast.makeText(this,"长度设置!",Toast.LENGTH_SHORT).show();
                mClient.sendMsg("{@"+info+"@"+3+"@"+(1)+"#"+edit_p.getText().toString().trim()+"}");
                break;
            case R.id.img_i:
                Toast.makeText(this,"角度设置!",Toast.LENGTH_SHORT).show();
                mClient.sendMsg("{@"+info+"@"+3+"@"+(2)+"#"+edit_i.getText().toString().trim()+"}");
                break;
            case R.id.img_d:
                Toast.makeText(this,"俯仰设置!",Toast.LENGTH_SHORT).show();
                mClient.sendMsg("{@"+info+"@"+3+"@"+(3)+"#"+edit_d.getText().toString().trim()+"}");
                break;
            case R.id.btn_pid:
//                Toast.makeText(this,"PID!",Toast.LENGTH_SHORT).show();
                if (pid_visibility == false){
                    ll_pid.setVisibility(View.VISIBLE);
                    pid_visibility = true;
                }else {
                    ll_pid.setVisibility(View.GONE);
                    pid_visibility = false;
                }
                break;
            case R.id.btn_reconnect:
                if (mClient.isConnected(ConnectActivity.device)) {
                    APP.toast("已经连接了", 0);
                    return;
                }
                mClient.connect(ConnectActivity.device);
                APP.toast("正在连接...", 0);
                break;
            case R.id.btn_p_plus:
                Log.i("p_edit",edit_p.getText().toString());
                Toast.makeText(this,"+p",Toast.LENGTH_SHORT).show();
                int P_value = Integer.parseInt(edit_p.getText().toString());
                P_value++;
                edit_p.setText(String.valueOf(P_value));
                break;

            case R.id.btn_p_minus:
                Log.i("p_edit",edit_p.getText().toString());
                Toast.makeText(this,"+p",Toast.LENGTH_SHORT).show();
                int P_value1 = Integer.parseInt(edit_p.getText().toString());
                P_value1--;
                edit_p.setText(String.valueOf(P_value1));
                break;
            case R.id.btn_i_plus:
                Log.i("p_edit",edit_i.getText().toString());
                Toast.makeText(this,"+i",Toast.LENGTH_SHORT).show();
                int I_value = Integer.parseInt(edit_i.getText().toString());
                I_value++;
                edit_i.setText(String.valueOf(I_value));
                break;
            case R.id.btn_i_minus:
                Log.i("p_edit",edit_i.getText().toString());
                Toast.makeText(this,"+i",Toast.LENGTH_SHORT).show();
                int I_value1 = Integer.parseInt(edit_i.getText().toString());
                I_value1--;
                edit_i.setText(String.valueOf(I_value1));
                break;
            case R.id.btn_d_plus:
                Log.i("p_edit",edit_d.getText().toString());
                Toast.makeText(this,"+d",Toast.LENGTH_SHORT).show();
                int D_value = Integer.parseInt(edit_d.getText().toString());
                D_value++;
                edit_d.setText(String.valueOf(D_value));
                break;
            case R.id.btn_d_minus:
                Log.i("p_edit",edit_d.getText().toString());
                Toast.makeText(this,"+d",Toast.LENGTH_SHORT).show();
                int D_value1 = Integer.parseInt(edit_d.getText().toString());
                D_value1--;
                edit_d.setText(String.valueOf(D_value1));
                break;
//            case R.id.b
//            case R.id.btn_c_minus:
//                Log.i("p_edit",edit_c.getText().toString());
//                Toast.makeText(this,"-c",Toast.LENGTH_SHORT).show();
//                int c_value1 = Integer.parseInt(edit_c.getText().toString());
//                c_value1--;
//                edit_c.setText(String.valueOf(c_value1));
//                break;
            case R.id.btn_update:
                Toast.makeText(this,"update data!",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void socketNotify(int state, Object obj) {
        if (isDestroyed())
            return;
        String msg = null;
        switch (state) {
            case BtBase.Listener.CONNECTED:
                BluetoothDevice dev = (BluetoothDevice) obj;
                msg = String.format("与%s(%s)连接成功", dev.getName(), dev.getAddress());
//				mTips.setText(msg);
                APP.toast(msg, 0);
                break;
            case BtBase.Listener.DISCONNECTED:
                msg = "连接断开";
//				mTips.setText(msg);
                break;
            case BtBase.Listener.MSG:
                msg = String.format("\n%s", obj);
//				mLogs.append(msg);
                break;
        }
        APP.toast(msg, 0);
    }

}
