package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService{

	@Override
	public void execute() {
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름 입력: ");
		String name = scanner.next();
		
		System.out.println("아이디 입력:");
		String id = scanner.next();
		
		System.out.println("비밀번호 입력: ");
		String pwd = scanner.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.insertUser(userDTO);
		
		System.out.println("데이터를 저장하였습니다.");
	}
}