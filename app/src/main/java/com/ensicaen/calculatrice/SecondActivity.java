package com.ensicaen.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonSub;
    Button buttonDiv;
    Button buttonMult;
    Button buttonChift;
    Button buttonEqual;
    Button buttonPt;
    EditText screen;

    private double _number;
    private boolean _clicOp = false;
    private boolean _updated_screen = true; //le dernier button cliqué n'est pas un nombre true, else false
    private String _operator = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPt = (Button) findViewById(R.id.buttonPt);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonChift = (Button) findViewById(R.id.buttonChift);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);

        screen = (EditText) findViewById(R.id.EditText);

        //On attribue un écouteur d’évènement à tous les boutons
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                subClick();
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multClick();
            }
        });

        buttonChift.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                equalClick();
            }
        });

        buttonPt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick(".");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberClick("9");
            }
        });
    }
        public void numberClick(String justTyped) {
            if(_updated_screen) _updated_screen = false;
            else {
                if(!screen.getText().equals("0")) justTyped = screen.getText().toString() + justTyped;
            }
            screen.setText(justTyped);
        }
        public void plusClick() {
            if (_clicOp) {
                count();
                screen.setText(String.valueOf(_number));
            } else {
                _number = Double.valueOf(screen.getText().toString()).doubleValue();
                _clicOp = true;
            }
            _operator = "+";
            _updated_screen = true;
        }
        public void subClick() {
            if (_clicOp) {
                count();
                screen.setText(String.valueOf(_number));
            } else {
                _number = Double.valueOf(screen.getText().toString()).doubleValue();
                _clicOp = true;
            }
            _operator = "-";
            _updated_screen = true;
        }
        public void multClick() {
            if (_clicOp) {
                count();
                screen.setText(String.valueOf(_number));
            } else {
                _number = Double.valueOf(screen.getText().toString()).doubleValue();
                _clicOp = true;
            }
            _operator = "*";
            _updated_screen = true;
        }
        public void divClick() {
            if (_clicOp) {
                count();
                screen.setText(String.valueOf(_number));
            } else {
                _number = Double.valueOf(screen.getText().toString()).doubleValue();
                _clicOp = true;
            }
            _operator = "/";
            _updated_screen = true;
        }
        public void equalClick() {
            count();
            _updated_screen = true;
            _clicOp = false;
            _operator = "";
        }
        public void resetClick() {
            _updated_screen =  true;
            _clicOp = false;
            _operator = "";
            _number = 0;
            screen.setText("");
        }

        public void count() {
            switch (_operator) {
                case "+":
                    _number += Double.valueOf(screen.getText().toString()).doubleValue();
                    screen.setText(String.valueOf(_number));
                    break;
                case "-":
                    _number -= Double.valueOf(screen.getText().toString()).doubleValue();
                    screen.setText(String.valueOf(_number));
                    break;
                case "*":
                    _number *= Double.valueOf(screen.getText().toString()).doubleValue();
                    screen.setText(String.valueOf(_number));
                    break;
                case "/":
                    if (Double.valueOf(screen.getText().toString()).doubleValue() == 0) {
                        screen.setText("0");
                        screen.setText(String.valueOf(_number));
                    } else {
                        _number /= Double.valueOf(screen.getText().toString()).doubleValue();
                        screen.setText(String.valueOf(_number));
                    }
                    break;
            }

    }
}
