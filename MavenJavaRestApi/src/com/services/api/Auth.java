package com.services.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.services.dao.LoginDAO;
import com.services.dao.TokenDAO;
import com.services.entity.Login;
import com.services.entity.Token;
import com.services.exception.APIException;
import com.services.util.Constant;
import com.services.util.Utility;

@Path("/auth")
public class Auth extends BaseApi {
	private Login login;
	private Token token;

	private LoginDAO loginDAO = LoginDAO.getInstance();
	private TokenDAO tokenDao = TokenDAO.getInstance();

	public Auth() {
		login = new Login();
		token = new Token();
	}

	@POST
	@Path("/merchant")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(MediaType.APPLICATION_JSON)
	public Response authCheck(@FormParam("email") String email,
			@FormParam("password") String password) {
		login = new Login(email, password);
		long merchantTokenId = 0;
		try {
			Utility.isValidEmail(login.getEmail());
			Utility.isNullOrEmpty(login.getPassword());

			login.setRole(Constant.ROLE_MERCHANT);
			Login loginSuccess = loginDAO.get(login);
			Utility.isLoginSuccess(loginSuccess);
			long loginId = loginSuccess.getId();
			merchantTokenId = Utility.getCurrentTimeInMillis();
			token.setLoginId(loginId);
			token.setTokenKey(merchantTokenId);
			token.setValidFor();
			tokenDao.add(token);
			setDefaultSuccess();
		} catch (APIException e) {
			genericExceptionHandler(e);
		}
		prepareResponse(merchantTokenId);
		return getResponse();
	}

}