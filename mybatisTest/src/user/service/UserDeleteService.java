package user.service;

import java.util.Scanner;

import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		UserDAO userDAO = UserDAO.getInstance();

		System.out.print("삭제하고자 하는 아이디 입력: ");
		String id = scanner.next();
		
		
		userDAO.deleteUser(id);
		System.out.println("삭제 완료");
	}
}