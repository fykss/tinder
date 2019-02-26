package utils;

import exceptions.NoParametersException;
import javax.servlet.http.HttpServletRequest;

public class ParameterFromRequest {
    private final HttpServletRequest req;

    public ParameterFromRequest(HttpServletRequest req) {
        this.req = req;
    }

    public int getInt(String name) throws NoParametersException {
        if(req.getParameter(name) == null || req.getParameter(name).equals("")){
            throw new NoParametersException(String.format("Parameter %s missing",name));
        }
        return Integer.parseInt(req.getParameter(name));
    }

    public String getStr(String name) throws NoParametersException {
        if(req.getParameter(name) == null || req.getParameter(name).equals("")){
            throw new NoParametersException(String.format("Parameter %s missing",name));
        }
        return req.getParameter(name);

    }
}
