package com.services.util;

public class DBQuery {

	public static final String LOGIN_GET = "select * from logins where "
			+ "email = #{email} and password = #{password} and role = #{role}";
	public static final String EXISTING_EMAIL = "select email from logins where email = #{email}";
	public static final String MAX_ID = "select max(id) from logins";
	public static final String LOGIN_ADD = "insert into logins (email, password, role, ApplicationKey, DeveloperKey) values (#{email}, #{password}, #{role}, #{applicationKey}, #{developerKey})";
	public static final String GET_PASSWORD = "select password from logins where id = #{id} ";

	public static final String MERCHANT_ADD = "insert into merchant (FirstName, LastName, Email, MobileNo, LoginId, ApplicationKey, DeveloperKey) values (#{firstName}, #{lastName}, #{email}, #{mobileNo}, #{loginId}, #{applicationKey}, #{developerKey})";
	public static final String EXISTING_MERCHANT_MOBILE = "select MobileNo from merchant where MobileNo = #{mobileNo}";

	public static final String TOKEN_ADD = "insert into token (tokenKey, loginId, validFor) values (#{tokenKey}, #{loginId}, #{validFor})";
}
