package app.swoking.fr.application.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://192.168.1.63:8080/LoginRegister/getUserInfo.php";
    private Map<String, String> params;

    public UserRequest(int id, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id", String.valueOf(id));
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
