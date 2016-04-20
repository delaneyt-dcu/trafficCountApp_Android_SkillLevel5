package com.example.delaneyt.trafficcountapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by delaneyt on 09/04/2016.
 */
public class FourArmJntActivity extends AppCompatActivity {

    /**
     * Debug Tag for use logging debug output to LogCat
     */
    private final String TAG = "FourArmJntActivity";

    // Variables declared and initialised
    MySQLiteHelperCountTable myDb;
    Button m_BtnAddToDb, m_BtnViewAllData, m_BtnResetCountData;
    ImageButton m_BtnAtoB, m_BtnAtoC,  m_BtnAtoD, m_BtnBtoA, m_BtnBtoC, m_BtnBtoD,
            m_BtnCtoA, m_BtnCtoB, m_BtnCtoD, m_BtnDtoA, m_BtnDtoB, m_BtnDtoC;
    TextView m_TextViewAtoBVehs, m_TextViewAtoCVehs, m_TextViewAtoDVehs,
            m_TextViewBtoAVehs, m_TextViewBtoCVehs, m_TextViewBtoDVehs,
            m_TextViewCtoAVehs, m_TextViewCtoBVehs,  m_TextViewCtoDVehs,
            m_TextViewDtoAVehs, m_TextViewDtoBVehs,  m_TextViewDtoCVehs;
    EditText m_EditTextArmAName, m_EditTextArmBName, m_EditTextArmCName, m_EditTextArmDName;
    int m_NoOfAtoBVehs =0, m_NoOfAtoBLGVs =0, m_NoOfAtoBHGVs =0,
            m_NoOfAtoCVehs =0, m_NoOfAtoCLGVs =0, m_NoOfAtoCHGVs =0,
            m_NoOfAtoDVehs =0, m_NoOfAtoDLGVs =0, m_NoOfAtoDHGVs =0,
            m_NoOfBtoAVehs =0, m_NoOfBtoALGVs =0, m_NoOfBtoAHGVs =0,
            m_NoOfBtoCVehs =0, m_NoOfBtoCLGVs =0, m_NoOfBtoCHGVs =0,
            m_NoOfBtoDVehs =0, m_NoOfBtoDLGVs =0, m_NoOfBtoDHGVs =0,
            m_NoOfCtoAVehs =0, m_NoOfCtoALGVs =0, m_NoOfCtoAHGVs =0,
            m_NoOfCtoBVehs =0, m_NoOfCtoBLGVs =0, m_NoOfCtoBHGVs =0,
            m_NoOfCtoDVehs =0, m_NoOfCtoDLGVs =0, m_NoOfCtoDHGVs =0,
            m_NoOfDtoAVehs =0, m_NoOfDtoALGVs =0, m_NoOfDtoAHGVs =0,
            m_NoOfDtoBVehs =0, m_NoOfDtoBLGVs =0, m_NoOfDtoBHGVs =0,
            m_NoOfDtoCVehs =0, m_NoOfDtoCLGVs =0, m_NoOfDtoCHGVs =0;

    // To prevent NullPointerException error
    //@Nullable

    /**
     * Public View method that inflates the layout with a value each time a button is pressed.
     */
//    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_arm_jnt);
        myDb = new MySQLiteHelperCountTable(this);

        m_BtnAtoB = (ImageButton) findViewById(R.id.imageButton_AtoB);
        m_BtnAtoC = (ImageButton) findViewById(R.id.imageButton_AtoC);
        m_BtnAtoD = (ImageButton) findViewById(R.id.imageButton_AtoD);
        m_BtnBtoA = (ImageButton) findViewById(R.id.imageButton_BtoA);
        m_BtnBtoC = (ImageButton) findViewById(R.id.imageButton_BtoC);
        m_BtnBtoD = (ImageButton) findViewById(R.id.imageButton_BtoD);
        m_BtnCtoA = (ImageButton) findViewById(R.id.imageButton_CtoA);
        m_BtnCtoB = (ImageButton) findViewById(R.id.imageButton_CtoB);
        m_BtnCtoD = (ImageButton) findViewById(R.id.imageButton_CtoD);
        m_BtnDtoA = (ImageButton) findViewById(R.id.imageButton_DtoA);
        m_BtnDtoB = (ImageButton) findViewById(R.id.imageButton_DtoB);
        m_BtnDtoC = (ImageButton) findViewById(R.id.imageButton_DtoC);

        m_BtnAddToDb = (Button) findViewById(R.id.button_AddToDb);
        m_BtnViewAllData = (Button) findViewById(R.id.button_ViewAllData);
        m_BtnResetCountData = (Button) findViewById(R.id.button_ResetCountData);

        m_EditTextArmAName = (EditText) findViewById(R.id.editTextArmAName);
        m_EditTextArmBName = (EditText) findViewById(R.id.editTextArmBName);
        m_EditTextArmCName = (EditText) findViewById(R.id.editTextArmCName);
        m_EditTextArmDName = (EditText) findViewById(R.id.editTextArmDName);

        m_TextViewAtoBVehs = (TextView) findViewById(R.id.textViewVehsAtoB);
        m_TextViewAtoCVehs = (TextView) findViewById(R.id.textViewVehsAtoC);
        m_TextViewAtoDVehs = (TextView) findViewById(R.id.textViewVehsAtoD);
        m_TextViewBtoAVehs = (TextView) findViewById(R.id.textViewVehsBtoA);
        m_TextViewBtoCVehs = (TextView) findViewById(R.id.textViewVehsBtoC);
        m_TextViewBtoDVehs = (TextView) findViewById(R.id.textViewVehsBtoD);
        m_TextViewCtoAVehs = (TextView) findViewById(R.id.textViewVehsCtoA);
        m_TextViewCtoBVehs = (TextView) findViewById(R.id.textViewVehsCtoB);
        m_TextViewCtoDVehs = (TextView) findViewById(R.id.textViewVehsCtoD);
        m_TextViewDtoAVehs = (TextView) findViewById(R.id.textViewVehsDtoA);
        m_TextViewDtoBVehs = (TextView) findViewById(R.id.textViewVehsDtoB);
        m_TextViewDtoCVehs = (TextView) findViewById(R.id.textViewVehsDtoC);

        addData();
        viewAll();

        // Arm A
        // When  short pressed, both LGVs and total no of vehicles are incremented by 1
        m_BtnAtoC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfAtoCVehs++;
                m_NoOfAtoCLGVs++;
                m_TextViewAtoCVehs.setText(Integer.toString(m_NoOfAtoCVehs));
            }
        });
        // Tag marker for this activity
        Log.i(TAG, "The total vehicles has been updated following Left button short pressed.");

        // When  long pressed, both HGVs and total no of vehicles are incremented by 1
        m_BtnAtoC.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfAtoCVehs++;
                m_NoOfAtoCHGVs++;
                m_TextViewAtoCVehs.setText(Integer.toString(m_NoOfAtoCVehs));
                return true;
            }
        });
        // Tag marker for this activity
        Log.i(TAG, "The total vehicles has been updated following Left button long pressed.");

        m_BtnAtoB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfAtoBVehs++;
                m_NoOfAtoBLGVs++;
                m_TextViewAtoBVehs.setText(Integer.toString(m_NoOfAtoBVehs));
            }
        });
        m_BtnAtoB.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfAtoBVehs++;
                m_NoOfAtoBHGVs++;
                m_TextViewAtoBVehs.setText(Integer.toString(m_NoOfAtoBVehs));
                return true;
            }
        });
        m_BtnAtoD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfAtoDVehs++;
                m_NoOfAtoDLGVs++;
                m_TextViewAtoDVehs.setText(Integer.toString(m_NoOfAtoDVehs));
            }
        });
        m_BtnAtoD.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfAtoDVehs++;
                m_NoOfAtoDHGVs++;
                m_TextViewAtoDVehs.setText(Integer.toString(m_NoOfAtoDVehs));
                return true;
            }
        });

        // Arm B
        m_BtnBtoA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfBtoAVehs++;
                m_NoOfBtoALGVs++;
                m_TextViewBtoAVehs.setText(Integer.toString(m_NoOfBtoAVehs));
            }
        });
        m_BtnBtoA.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfBtoAVehs++;
                m_NoOfBtoAHGVs++;
                m_TextViewBtoAVehs.setText(Integer.toString(m_NoOfBtoAVehs));
                return true;
            }
        });
        m_BtnBtoC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfBtoCVehs++;
                m_NoOfBtoCLGVs++;
                m_TextViewBtoCVehs.setText(Integer.toString(m_NoOfBtoCVehs));
            }
        });
        m_BtnBtoC.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfBtoCVehs++;
                m_NoOfBtoCHGVs++;
                m_TextViewBtoCVehs.setText(Integer.toString(m_NoOfBtoCVehs));
                return true;
            }
        });
        m_BtnBtoD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfBtoDVehs++;
                m_NoOfBtoDLGVs++;
                m_TextViewBtoDVehs.setText(Integer.toString(m_NoOfBtoDVehs));
            }
        });
        m_BtnBtoD.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfBtoDVehs++;
                m_NoOfBtoDHGVs++;
                m_TextViewBtoDVehs.setText(Integer.toString(m_NoOfBtoDVehs));
                return true;
            }
        });

        // Arm C
        m_BtnCtoB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfCtoBVehs++;
                m_NoOfCtoBLGVs++;
                m_TextViewCtoBVehs.setText(Integer.toString(m_NoOfCtoBVehs));
            }
        });
        m_BtnCtoB.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfCtoBVehs++;
                m_NoOfCtoBHGVs++;
                m_TextViewCtoBVehs.setText(Integer.toString(m_NoOfCtoBVehs));
                return true;
            }
        });
        m_BtnCtoA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfCtoAVehs++;
                m_NoOfCtoALGVs++;
                m_TextViewCtoAVehs.setText(Integer.toString(m_NoOfCtoAVehs));
            }
        });
        m_BtnCtoA.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfCtoAVehs++;
                m_NoOfCtoAHGVs++;
                m_TextViewCtoAVehs.setText(Integer.toString(m_NoOfCtoAVehs));
                return true;
            }
        });
        m_BtnCtoD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfCtoDVehs++;
                m_NoOfCtoDLGVs++;
                m_TextViewCtoDVehs.setText(Integer.toString(m_NoOfCtoDVehs));
            }
        });
        m_BtnCtoD.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfCtoDVehs++;
                m_NoOfCtoDHGVs++;
                m_TextViewCtoDVehs.setText(Integer.toString(m_NoOfCtoDVehs));
                return true;
            }
        });

        // Arm D
        m_BtnDtoB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfDtoBVehs++;
                m_NoOfDtoBLGVs++;
                m_TextViewDtoBVehs.setText(Integer.toString(m_NoOfDtoBVehs));
            }
        });
        m_BtnDtoB.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfDtoBVehs++;
                m_NoOfDtoBHGVs++;
                m_TextViewDtoBVehs.setText(Integer.toString(m_NoOfDtoBVehs));
                return true;
            }
        });
        m_BtnDtoA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfDtoAVehs++;
                m_NoOfDtoALGVs++;
                m_TextViewDtoAVehs.setText(Integer.toString(m_NoOfDtoAVehs));
            }
        });
        m_BtnDtoA.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfDtoAVehs++;
                m_NoOfDtoAHGVs++;
                m_TextViewDtoAVehs.setText(Integer.toString(m_NoOfDtoAVehs));
                return true;
            }
        });
        m_BtnDtoC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfDtoCVehs++;
                m_NoOfDtoCLGVs++;
                m_TextViewDtoCVehs.setText(Integer.toString(m_NoOfDtoCVehs));
            }
        });
        m_BtnDtoC.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                m_NoOfDtoCVehs++;
                m_NoOfDtoCHGVs++;
                m_TextViewDtoCVehs.setText(Integer.toString(m_NoOfDtoCVehs));
                return true;
            }
        });

        // sets the onClick listener for buttonReset to resetCountData both all count data and arm names field
        m_BtnResetCountData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetCountData();
                // Tag marker for this activity
                Log.i(TAG, "The count data was been resetCountData.");
            }
        });
    }

    public void addData() {
        m_BtnAddToDb.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                boolean isInserted = myDb.insertData(
                                                        Integer.toString(m_NoOfAtoBLGVs),
                                                        Integer.toString(m_NoOfAtoBHGVs),
                                                        Integer.toString(m_NoOfAtoCLGVs),
                                                        Integer.toString(m_NoOfAtoCHGVs),
                                                        Integer.toString(m_NoOfAtoDLGVs),
                                                        Integer.toString(m_NoOfAtoDHGVs),
                                                        Integer.toString(m_NoOfBtoALGVs),
                                                        Integer.toString(m_NoOfBtoAHGVs),
                                                        Integer.toString(m_NoOfBtoCLGVs),
                                                        Integer.toString(m_NoOfBtoCHGVs),
                                                        Integer.toString(m_NoOfBtoDLGVs),
                                                        Integer.toString(m_NoOfBtoDHGVs),
                                                        Integer.toString(m_NoOfCtoALGVs),
                                                        Integer.toString(m_NoOfCtoAHGVs),
                                                        Integer.toString(m_NoOfCtoBLGVs),
                                                        Integer.toString(m_NoOfCtoBHGVs),
                                                        Integer.toString(m_NoOfCtoDLGVs),
                                                        Integer.toString(m_NoOfCtoDHGVs),
                                                        Integer.toString(m_NoOfDtoALGVs),
                                                        Integer.toString(m_NoOfDtoAHGVs),
                                                        Integer.toString(m_NoOfDtoBLGVs),
                                                        Integer.toString(m_NoOfDtoBHGVs),
                                                        Integer.toString(m_NoOfDtoCLGVs),
                                                        Integer.toString(m_NoOfDtoCHGVs));
                                                if (isInserted == true) {
                                                    Toast.makeText(FourArmJntActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                                    resetCountData();
                                                }

                                                else {
                                                    Toast.makeText(FourArmJntActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        }
        );}
/**
    public void addData() {
        m_BtnAddToDb.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                boolean isInserted = countTable.insertData(
m_NoOfAtoBLGVs.getTest().toString(),
m_NoOfAtoBHGVs.getTest().toString(),
m_NoOfAtoCLGVs.getTest().toString(),
m_NoOfAtoCHGVs.getTest().toString(),
m_NoOfAtoDLGVs.getTest().toString(),
m_NoOfAtoDHGVs.getTest().toString(),
m_NoOfBtoALGVs.getTest().toString(),
m_NoOfBtoAHGVs.getTest().toString(),
m_NoOfBtoCLGVs.getTest().toString(),
m_NoOfBtoCHGVs.getTest().toString(),
m_NoOfBtoDLGVs.getTest().toString(),
m_NoOfBtoDHGVs.getTest().toString(),
m_NoOfCtoALGVs.getTest().toString(),
m_NoOfCtoAHGVs.getTest().toString(),
m_NoOfCtoBLGVs.getTest().toString(),
m_NoOfCtoBHGVs.getTest().toString(),
m_NoOfCtoDLGVs.getTest().toString(),
m_NoOfCtoDHGVs.getTest().toString(),
m_NoOfDtoALGVs.getTest().toString(),
m_NoOfDtoAHGVs.getTest().toString(),
m_NoOfDtoBLGVs.getTest().toString(),
m_NoOfDtoBHGVs.getTest().toString(),
m_NoOfDtoCLGVs.getTest().toString(),
m_NoOfDtoCHGVs.getTest().toString() );


                                                if (isInserted == true) {
                                                    Toast.makeText(FourArmJntActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                                    resetCountData();
                                                }

                                                else {
                                                    Toast.makeText(FourArmJntActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        }
        );}

    */















    /**
     * Public void method called upon Reset in RugbyMatchActivity resetButton pressed
     */
    public void resetCountData() {
        m_NoOfAtoBVehs = m_NoOfAtoBLGVs = m_NoOfAtoBHGVs =
                m_NoOfAtoCVehs = m_NoOfAtoCLGVs = m_NoOfAtoCHGVs =
                        m_NoOfAtoDVehs = m_NoOfAtoDLGVs = m_NoOfAtoDHGVs =
                                m_NoOfBtoAVehs = m_NoOfBtoALGVs = m_NoOfBtoAHGVs =
                                        m_NoOfBtoCVehs = m_NoOfBtoCLGVs = m_NoOfBtoCHGVs =
                                                m_NoOfBtoDVehs = m_NoOfBtoDLGVs = m_NoOfBtoDHGVs =
                                                        m_NoOfCtoAVehs = m_NoOfCtoALGVs = m_NoOfCtoAHGVs =
                                                                m_NoOfCtoBVehs = m_NoOfCtoBLGVs = m_NoOfCtoBHGVs =
                                                                        m_NoOfCtoDVehs = m_NoOfCtoDLGVs = m_NoOfCtoDHGVs =
                                                                                m_NoOfDtoAVehs = m_NoOfDtoALGVs = m_NoOfDtoAHGVs =
                                                                                        m_NoOfDtoBVehs = m_NoOfDtoBLGVs = m_NoOfDtoBHGVs =
                                                                                                m_NoOfDtoCVehs = m_NoOfDtoCLGVs = m_NoOfDtoCHGVs =0;

        m_TextViewAtoBVehs.setText(Integer.toString(m_NoOfAtoBVehs));
        m_TextViewAtoCVehs.setText(Integer.toString(m_NoOfAtoCVehs));
        m_TextViewAtoDVehs.setText(Integer.toString(m_NoOfAtoDVehs));
        m_TextViewBtoAVehs.setText(Integer.toString(m_NoOfBtoAVehs));
        m_TextViewBtoCVehs.setText(Integer.toString(m_NoOfBtoCVehs));
        m_TextViewBtoDVehs.setText(Integer.toString(m_NoOfBtoDVehs));
        m_TextViewCtoAVehs.setText(Integer.toString(m_NoOfCtoAVehs));
        m_TextViewCtoBVehs.setText(Integer.toString(m_NoOfCtoBVehs));
        m_TextViewCtoDVehs.setText(Integer.toString(m_NoOfCtoDVehs));
        m_TextViewDtoAVehs.setText(Integer.toString(m_NoOfDtoAVehs));
        m_TextViewDtoBVehs.setText(Integer.toString(m_NoOfDtoBVehs));
        m_TextViewDtoCVehs.setText(Integer.toString(m_NoOfDtoCVehs));

        m_EditTextArmAName.setText(null);
        m_EditTextArmBName.setText(null);
        m_EditTextArmCName.setText(null);
        m_EditTextArmDName.setText(null);
    }

    public void viewAll() {
        m_BtnViewAllData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MySQLiteHelperCountTable myTrafficSurveysDb = new MySQLiteHelperCountTable(FourArmJntActivity.this);
                        Cursor res = myTrafficSurveysDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "No data found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id: " + res.getString(0) + "\nMovement Nos:\n");
                            buffer.append("AtoBLGV: " + res.getString(1) + "\n");
                            buffer.append("AtoBHGV: " + res.getString(2) + "\n");
                            buffer.append("AtoCLGV: " + res.getString(3) + "\n");
                            buffer.append("AtoCHGV: " + res.getString(4) + "\n");
                            buffer.append("AtoDLGV: " + res.getString(5) + "\n");
                            buffer.append("AtoDHGV: " + res.getString(6) + "\n");
                            buffer.append("BtoALGV: " + res.getString(7) + "\n");
                            buffer.append("BtoAHGV: " + res.getString(8) + "\n");
                            buffer.append("BtoCLGV: " + res.getString(9) + "\n");
                            buffer.append("BtoCHGV: " + res.getString(10) + "\n");
                            buffer.append("BtoDLGV: " + res.getString(11) + "\n");
                            buffer.append("BtoDHGV: " + res.getString(12) + "\n");
                            buffer.append("CtoALGV: " + res.getString(13) + "\n");
                            buffer.append("CtoAHGV: " + res.getString(14) + "\n");
                            buffer.append("CtoBLGV: " + res.getString(15) + "\n");
                            buffer.append("CtoBHGV: " + res.getString(16) + "\n");
                            buffer.append("CtoDLGV: " + res.getString(17) + "\n");
                            buffer.append("CtoDHGV: " + res.getString(18) + "\n");
                            buffer.append("DtoALGV: " + res.getString(19) + "\n");
                            buffer.append("DtoAHGV: " + res.getString(20) + "\n");
                            buffer.append("DtoBLGV: " + res.getString(21) + "\n");
                            buffer.append("DtoBHGV: " + res.getString(22) + "\n");
                            buffer.append("DtoCLGV: " + res.getString(23) + "\n");
                            buffer.append("DtoCHGV: " + res.getString(24) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                        return;
                    }
                });
    }

    public void showMessage (String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(FourArmJntActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}