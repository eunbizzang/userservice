package ko.getarrays.userservice.Service;

import ko.getarrays.userservice.domain.Role;
import ko.getarrays.userservice.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void adddRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
