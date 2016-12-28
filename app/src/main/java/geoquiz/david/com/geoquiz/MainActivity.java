package geoquiz.david.com.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mPreviusbutton;
    private ImageButton mNextButton;
    private TextView mQuestionTextView;

    private static final String TAG = "QuizActivity";

    //arreglo de preguntas
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    //indice para el arreglo de preguntas
    private int mCurrentIndex = 0;

    //metodo para cambiar las preguntas
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    //Este método aceptará una variable booleana que identifica si el usuario presionó True o False.
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mensaje en consola
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        //imprimir pregunta
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        //casting y setter del boton true
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast -> display message in screen
                //Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();

                checkAnswer(true);
            }
        });

        //casting y setter del boton false
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

                checkAnswer(false);
            }
        });

        //casting y setter del boton next
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calcula la posicion del indice del arreglo y lo indica en siguiente
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();

        //casting y setter del boton previus
        mNextButton = (ImageButton) findViewById(R.id.previus_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*calcula la posicion del indice del arreglo y lo indica en siguiente
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();*/
            }
        });
        updateQuestion();
    }


    //mensajes de estado de la aplicacion en consola
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
