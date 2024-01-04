package user.main;

import java.util.Scanner;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

public class UserMain {

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		UserService userService = null; // 인터페이스는 new 객체 생성 불가

		while (true) {
			System.out.println();
			System.out.println("===== MENU =====");
			System.out.println(" 1. 입력");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 수정");
			System.out.println(" 4. 삭제");
			System.out.println(" 5. 검색");
			System.out.println(" 6. 종료");
			System.out.println("================");
			System.out.print("SELECT NUMBER: ");
			num = scanner.nextInt();
			if (num == 6) {
				break;
			} else if (num == 1) {
				userService = new UserInsertService();
			} else if (num == 2) {
				userService = new UserSelectService();
			} else if (num == 3) {
				userService = new UserUpdateService();
			} else if (num == 4) {
				userService = new UserDeleteService();
			} else if (num == 5) {
				userService = new UserSearchService();
			}
			userService.execute();
		}
	}

	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu();
		System.out.println("프로그램 종료");
	}

}
