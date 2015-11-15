package DAO;

import Model.User;

public interface UserDAO
{
	public boolean verificarUser(String userName, String md5Encode);
	public User getUser(String userName, String md5Encode);
}
