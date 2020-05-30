package test.csq.com.pidcontroller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import test.csq.com.pidcontroller.bt.BtBase;
import test.csq.com.pidcontroller.bt.BtClient;
import test.csq.com.pidcontroller.bt.BtDevAdapter;
import test.csq.com.pidcontroller.util.BtReceiver;

public class ConnectActivity extends AppCompatActivity implements View.OnClickListener,  BtBase.Listener, BtReceiver.Listener, BtDevAdapter.Listener {
    private final BtDevAdapter mBtDevAdapter = new BtDevAdapter(this);
    public static BluetoothDevice device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        initView();
    }

    private void initView() {
        RecyclerView rv = findViewById(R.id.rv_bt);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mBtDevAdapter);
//		mTips = findViewById(R.id.tv_tips);
//		mInputMsg = findViewById(R.id.input_msg);
//		mInputFile = findViewById(R.id.input_file);
//		mLogs = findViewById(R.id.tv_log);
//        mBtReceiver = new BtReceiver(this, this);//注册蓝牙广播
        BluetoothAdapter.getDefaultAdapter().startDiscovery();
    }

    // 重新扫描
    public void reScan(View view) {
        mBtDevAdapter.reScan();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(BluetoothDevice dev) {
        device = dev;
        finish();
    }

    @Override
    public void foundDev(BluetoothDevice dev) {

    }

    @Override
    public void socketNotify(int state, Object obj) {

    }
}
