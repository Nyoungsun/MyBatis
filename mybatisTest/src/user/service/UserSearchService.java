package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);

		UserDAO userDAO = UserDAO.getInstance();
		Map<String, String> map = null;

		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.print("SELECT NUMBER: ");
		int num = scanner.nextInt();

		if (num == 1) {
			System.out.print("찾고자 하는 이름 입력: ");
			String name = scanner.next();

			map = new HashMap<>();
			map.put("col_name", "name");
			map.put("value", name);

		} else if (num == 2) {
			System.out.print("찾고자 하는 아이디 입력:");
			String id = scanner.next();

			map = new HashMap<>();
			map.put("col_name", "id");
			map.put("value", id);
		} else {
			System.out.println("다시 선택하세요.");
		}
		
		List<UserDTO> list = userDAO.searchUser(map);
		
		System.out.println("이름\t" + "ID\t" + "PWD");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}

	}
}
