import me.dingshuai.mapper.UserMapper;
import me.dingshuai.pojo.Users;
import me.dingshuai.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

	@Test
	public void testCheck() {
		UserMapper userMapper = SqlSessionUtil.open().getMapper(UserMapper.class);
		// 成功
		List<Users> users = userMapper.findAll();
		System.out.println(users);
		// 失败
		Users user = userMapper.checkPwd("admin","admin");
		System.out.println(user);
	}

	@Test
	public void testFindAll() {
		UserMapper userMapper = SqlSessionUtil.open().getMapper(UserMapper.class);
		List<Users> users = userMapper.findAll();
		System.out.println(users);
	}

	@Test
	public void testCheckIfExists() {
		UserMapper userMapper = SqlSessionUtil.open().getMapper(UserMapper.class);
		Users admin = userMapper.checkIfExists("admin");
		System.out.println(admin);
	}
}
