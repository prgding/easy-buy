import me.dingshuai.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")
public class UserMapperTest {
	@Autowired
	private AccountService accountService;

	@Test
	public String testCheckIfExists() {
		int exist = accountService.CheckIfExists("admin");
		if (exist == 1) {
			System.out.println("用户名已存在");
		} else {
			System.out.println("用户名可用");
		}
		return "用户名已存在";
	}
}
