package android.kaban

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import java.util.*

class WelcomeScreen : AppCompatActivity() {

    companion object {
        const val EMAIL = "email";
    }

    lateinit var loginButton: LoginButton;
    val TAG = WelcomeScreen.javaClass.name;
    var callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)



        this.initializeUI()
        this.addCallBack();
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun initializeUI() {
        loginButton = findViewById(R.id.loginButton) as LoginButton;
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
    }

    fun addCallBack() {


        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                Log.d(TAG, "success");
            }

            override fun onCancel() {

            }

            override fun onError(exception: FacebookException) {

            }
        });
    }
}
