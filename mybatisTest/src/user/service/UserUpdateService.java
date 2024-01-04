package user.service;

import java.util.Scanner;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);

			System.out.print("아이디 입력: ");
			String id = scanner.next();

			UserDAO userDAO = UserDAO.getInstance();
			
			UserDTO userDTO = userDAO.getUser(id);
			if (userDTO == null) {
				System.out.println("존재하지 않는 아이디입니다.");
			} else {
				System.out.println("이름\t" + "ID\t" + "PWD");
				System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			    
				System.out.print("변경할 이름 입력 :");
				String name = scanner.next();
				
				System.out.print("변경할 비밀번호 입력 :");
				String pwd = scanner.next();
				
				userDTO.setId(id);
				userDTO.setName(name);
				userDTO.setPwd(pwd);
				
				userDAO.updateUser(userDTO);
				System.out.println("수정 완료");
		}
	}
}
