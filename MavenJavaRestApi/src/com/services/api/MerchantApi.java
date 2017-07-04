package com.services.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.services.dao.LoginDAO;
import com.services.dao.MerchantDAO;
import com.services.dao.TokenDAO;
import com.services.entity.Login;
import com.services.entity.Merchant;
import com.services.entity.Token;
import com.services.exception.APIException;
import com.services.util.Utility;



@Path("/merchant")
public class MerchantApi extends BaseMerchantAPI {
	private Merchant merchant;
	private Login login;
	private Token token;

	private MerchantDAO merchantDAO = MerchantDAO.getInstance();
	private LoginDAO login_dao = LoginDAO.getInstance();
	private TokenDAO tokenDAO = TokenDAO.getInstance();

	public MerchantApi() {
		merchant = new Merchant();
		token = new Token();
	}

	@Path("/new")
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(@FormParam("Email") String email,
			@FormParam("FirstName") String firstName,
			@FormParam("LastName") String lastName,
			@FormParam("MobileNo") String mobileNo,
			@FormParam("Password") String password,
			@FormParam("ApplicationKey") String applicationKey,
			@FormParam("DeveloperKey") String developerKey) {
		long authToken = 0;
		merchant = new Merchant(email, firstName, lastName, mobileNo, password,
				applicationKey, developerKey);
		try {
			Utility.isNullOrEmpty(merchant.getFirstName());
			Utility.isAlphabet(merchant.getFirstName());
			Utility.isNullOrEmpty(merchant.getLastName());
			Utility.isAlphabet(merchant.getLastName());
			Utility.isNullOrEmpty(merchant.getPassword());
			Utility.isValidEmail(merchant.getEmail());
			Utility.isValidMobileNumber(merchant.getMobileNo());
			Utility.isUniqueEmail(login_dao.existingEmail(merchant.getEmail()));
			Utility.isUniqueMobileNumber(merchantDAO
					.existingMerchantMobile(mobileNo));

			login = new Login();
			login.setEmail(merchant.getEmail());
			login.setPassword(merchant.getPassword());
			login.setRole("merchant");
			login.setApplicationKey(merchant.getApplicationKey());
			login.setDeveloperKey(merchant.getDeveloperKey());
			login_dao.add(login);

			int loginId = login_dao.maxId();
			merchant.setLoginId(loginId);
			long merchantId = merchantDAO.add(merchant);
			if (merchantId > 0) {
				authToken = System.currentTimeMillis();
				token.setLoginId(loginId);
				token.setTokenKey(authToken);
				token.setValidFor();
				tokenDAO.add(token);
				setDefaultSuccess();
			}
		} catch (APIException e) {
			genericExceptionHandler(e);
		}
		createResponse(authToken);
		return getResponse();
	}

}
