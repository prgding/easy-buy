import me.dingshuai.mapper.UsersMapper;
import me.dingshuai.pojo.Users;
import me.dingshuai.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

	@Test
	public void testCheck() {
		UsersMapper usersMapper = SqlSessionUtil.open().getMapper(UsersMapper.class);
		// 成功
		List<Users> users = usersMapper.findAll();
		System.out.println(users);
		// 失败
		Users user = usersMapper.checkPwd("admin","admin");
		System.out.println(user);
	}

	@Test
	public void testFindAll() {
		UsersMapper usersMapper = SqlSessionUtil.open().getMapper(UsersMapper.class);
		List<Users> users = usersMapper.findAll();
		System.out.println(users);
	}

	@Test
	public void testCheckIfExists() {
		UsersMapper usersMapper = SqlSessionUtil.open().getMapper(UsersMapper.class);
		Users admin = usersMapper.checkIfExists("admin");
		System.out.println(admin);
	}
}
