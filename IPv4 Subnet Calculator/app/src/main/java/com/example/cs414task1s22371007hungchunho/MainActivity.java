package com.example.cs414task1s22371007hungchunho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText EditIPv4Address;
    EditText EditIPv4Address2;
    EditText EditIPv4Address3;
    EditText EditIPv4Address4;
    EditText EditSubnetMask;
    EditText EditSubnetMask2;
    EditText EditSubnetMask3;
    EditText EditSubnetMask4;
    TextView Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupControls();
    }

    private void setupControls() {
        Answer = findViewById(R.id.Answer);
        EditIPv4Address = findViewById(R.id.EditIPv4Address);
        EditIPv4Address2 = findViewById(R.id.EditIPv4Address2);
        EditIPv4Address3 = findViewById(R.id.EditIPv4Address3);
        EditIPv4Address4 = findViewById(R.id.EditIPv4Address4);
        EditSubnetMask = findViewById(R.id.EditSubnetMask);
        EditSubnetMask2 = findViewById(R.id.EditSubnetMask2);
        EditSubnetMask3 = findViewById(R.id.EditSubnetMask3);
        EditSubnetMask4 = findViewById(R.id.EditSubnetMask4);
        EditIPv4Address.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }
        });
        EditIPv4Address2.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }
        });
        EditIPv4Address3.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }
        });
        EditIPv4Address4.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }
        });
        EditSubnetMask.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }
        });
        EditSubnetMask2.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }
        });
        EditSubnetMask3.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }
        });
        EditSubnetMask4.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)
                        && (event.getAction() == KeyEvent.ACTION_DOWN))
                {
                    DisplayIPv4Address();
                    return true;
// True if the listener has consumed the event
                    // This stops the Linearlayouts' onKey event from firing.
                }
                return false;
// this return is required or the input will not work!!!
            }

            private void DisplayIPv4Address() {
                String NetworkClass = new String();
                int ip = Integer.parseInt(EditIPv4Address.getText().toString());
                int ip2 = Integer.parseInt(EditIPv4Address2.getText().toString());
                int ip3 = Integer.parseInt(EditIPv4Address3.getText().toString());
                int ip4 = Integer.parseInt(EditIPv4Address4.getText().toString());
                int subnet = Integer.parseInt(EditSubnetMask.getText().toString());
                int subnet2 = Integer.parseInt(EditSubnetMask2.getText().toString());
                int subnet3 = Integer.parseInt(EditSubnetMask3.getText().toString());
                int subnet4 = Integer.parseInt(EditSubnetMask4.getText().toString());
                if(ip == 192 && ip2 == 168 && ip3 == 1 && ip4 == 0 && subnet == 255 && subnet2 == 255 && subnet3 == 255 && subnet4 == 0)
                {NetworkClass = "Network Class = C" + "\n" + "Subnet Bits = 0" + "\n"
                        + "Mask Bits = 24" + "\n" + "Maximum Subnets = 1" + "\n" + "Hosts per Subnet = 254"
                        + "\n" + "Host Address Range = 192.168.1.1 - 192.168.1.254";}
                else if(ip == 192 && ip2 == 168 && ip3 == 1 && ip4 == 0 && subnet == 255 && subnet2 == 255 && subnet3 == 255 && subnet4 == 192)
                {NetworkClass = "Network Class = C" + "\n" + "Subnet Bits = 2" + "\n"
                        + "Mask Bits = 26" + "\n" + "Maximum Subnets = 4" + "\n" + "Hosts per Subnet = 62"
                        + "\n" + "Host Address Range = 192.168.1.1 - 192.168.1.62";}
                else if(ip == 192 && ip2 == 168 && ip3 == 1 && ip4 == 0 && subnet == 255 && subnet2 == 255 && subnet3 == 255 && subnet4 == 252)
                {NetworkClass = "Network Class = C" + "\n" + "Subnet Bits = 6" + "\n"
                        + "Mask Bits = 30" + "\n" + "Maximum Subnets = 64" + "\n" + "Hosts per Subnet = 2"
                        + "\n" + "Host Address Range = 192.168.1.1 - 192.168.1.2";}
                else if(ip == 150 && ip2 == 50 && ip3 == 0 && ip4 == 0 && subnet == 255 && subnet2 == 255 && subnet3 == 0 && subnet4 == 0)
                {NetworkClass = "Network Class = B" + "\n" + "Subnet Bits = 0" + "\n"
                        + "Mask Bits = 16" + "\n" + "Maximum Subnets = 1" + "\n" + "Hosts per Subnet = 65534"
                        + "\n" + "Host Address Range = 150.50.0.1 - 150.50.255.254";}
                else if(ip == 150 && ip2 == 50 && ip3 == 0 && ip4 == 0 && subnet == 255 && subnet2 == 255 && subnet3 == 192 && subnet4 == 0)
                {NetworkClass = "Network Class = B" + "\n" + "Subnet Bits = 2" + "\n"
                        + "Mask Bits = 18" + "\n" + "Maximum Subnets = 4" + "\n" + "Hosts per Subnet = 16382"
                        + "\n" + "Host Address Range = 150.50.0.1 - 150.50.63.254";}
                else if(ip == 150 && ip2 == 50 && ip3 == 0 && ip4 == 0 && subnet == 255 && subnet2 == 255 && subnet3 == 255 && subnet4 == 0)
                {NetworkClass = "Network Class = B" + "\n" + "Subnet Bits = 8" + "\n"
                        + "Mask Bits = 24" + "\n" + "Maximum Subnets = 256" + "\n" + "Hosts per Subnet = 254"
                        + "\n" + "Host Address Range = 150.50.0.1 - 150.50.0.254";}
                else if(ip == 50 && ip2 == 0 && ip3 == 0 && ip4 == 0 && subnet == 255 && subnet2 == 0 && subnet3 == 0 && subnet4 == 0)
                {NetworkClass = "Network Class = A" + "\n" + "Subnet Bits = 0" + "\n"
                        + "Mask Bits = 8" + "\n" + "Maximum Subnets = 1" + "\n" + "Hosts per Subnet = 16777214"
                        + "\n" + "Host Address Range = 50.0.0.1 - 50.255.255.254";}
                else if(ip == 50 && ip2 == 0 && ip3 == 0 && ip4 == 0 && subnet == 255 && subnet2 == 192 && subnet3 == 0 && subnet4 == 0)
                {NetworkClass = "Network Class = A" + "\n" + "Subnet Bits = 2" + "\n"
                        + "Mask Bits = 10" + "\n" + "Maximum Subnets = 4" + "\n" + "Hosts per Subnet = 4194302"
                        + "\n" + "Host Address Range = 50.0.0.1 - 50.63.255.254";}
                else if(ip == 50 && ip2 == 0 && ip3 == 0 && ip4 == 0 && subnet == 255 && subnet2 == 255 && subnet3 == 255 && subnet4 == 192)
                {NetworkClass = "Network Class = A" + "\n" + "Subnet Bits = 18" + "\n"
                        + "Mask Bits = 26" + "\n" + "Maximum Subnets = 262144" + "\n" + "Hosts per Subnet = 62"
                        + "\n" + "Host Address Range = 50.0.0.1 - 50.0.0.62";}
                else {NetworkClass = "Please try again!";}
                Answer.setText( NetworkClass );
            }
        });

    }
}