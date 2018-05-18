
package ar.com.sourcesistemas.service;

import ar.com.sourcesistemas.model.User;

public interface UserService {
	public User findUserByEmail(String email);

	public void saveUser(User user);
}
