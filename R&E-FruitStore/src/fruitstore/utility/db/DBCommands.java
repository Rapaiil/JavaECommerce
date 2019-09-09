package fruitstore.utility.db;

public interface DBCommands {
	final String CHECK_UNAME = "SELECT * FROM users WHERE user_name = ?";
	final String CHECK_EMAIL = "SELECT * FROM usersinfo WHERE user_email = ?";
	final String ADD_USER_INFO = "INSERT INTO usersinfo(user_name, user_first_name, "
			+ "user_last_name, user_phone_number, user_email) "
			+ "VALUES(?,?,?,?,?)";
	final String ADD_USER = "INSERT INTO users(user_name, user_password) "
			+ "VALUES(?,?)";
}
